package mx.isban.scc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.isban.scc.exception.ObjectNotFoundException;
import mx.isban.scc.model.lza0.NumCuentaResponse;

/**
 * Implementaión de los metodos de la interfaz para obtener los numeros de cuenta
 * @author Edgar Daniel Garcia Serrano
 * 
 * NTT DATA
 * Noviembre 2022
 * 
 */
@Service
public class NumeroCuentaService implements INumeroCuentaService {
	
	@Value("${magisterio.lza0.url}")
	private String uri;
	
	@Value("${magisterio.lza0.token.url}")
	private String tokenUri;
	
	@Value("${magisterio.lza0.scope}")
	private String apiScope;
	
	@Value("${magisterio.lza0.client-id}")
	private String apiClientId;
	
	@Value("${magisterio.lza0.client-secret}")
	private String apiClientSecret;
	
	@Value("${magisterio.lza0.ibm-client-id}")
	private String ibmClientId;
	
	@Autowired
    private RestTemplate rt;
	
	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * Metodo para obtener
	 * los numeros de cuenta
	 * @throws JsonProcessingException 
	 */
	@Override
	public NumCuentaResponse obtenerNumerosCuenta(String idCuenta, String ownerInd, String activeInd, String subseqRec, String cursorValue) throws JsonProcessingException {

		try {
			// Obtener token para consumir el servicio
			String token = this.obtenerToken();
			if(token != null) {
				
				// Se agregan los headers
				HttpHeaders headers = new HttpHeaders();
				headers.setBearerAuth(token);
				headers.add("X-IBM-Client-Id", ibmClientId);
				
				// Se agregan los query params
				UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(uri)
		                .queryParam("ownerInd", ownerInd)
		                .queryParam("activeInd", activeInd)
		                .queryParam("subseqRec", subseqRec)
		                .queryParam("cursorValue", cursorValue);
				
				// Construccion y envio de la peticion
				HttpEntity<Void> entity = new HttpEntity<>(headers);
				ResponseEntity<NumCuentaResponse> responseEntity = rt.exchange(uriBuilder.toUriString(), HttpMethod.GET, entity, NumCuentaResponse.class, idCuenta);
				
				return responseEntity.getBody();
			}else {
				throw new ObjectNotFoundException("La petición no ha sido autorizada");
			}
		}catch(HttpClientErrorException httpEx) {
			return objectMapper.readValue(httpEx.getResponseBodyAsString(), NumCuentaResponse.class);
		}
	}

	private String obtenerToken() throws JsonProcessingException {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("scope", apiScope);
		map.add("grant_type","client_credentials");
		map.add("client_id", apiClientId);
		map.add("client_secret", apiClientSecret);
		
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);
		
		try{
			ResponseEntity<String> response = rt.exchange(tokenUri, HttpMethod.POST, entity, String.class);
		
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(response.getBody());
			return root.get("access_token").textValue();
		}catch (HttpClientErrorException httpEx) {
			httpEx.getMessage();
			return null;
		}
	}
}
