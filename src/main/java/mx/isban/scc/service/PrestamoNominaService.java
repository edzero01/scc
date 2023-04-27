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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.isban.scc.exception.ObjectNotFoundException;
import mx.isban.scc.model.pb53.PrestamoNominaRequest;
import mx.isban.scc.model.pb53.PrestamoNominaResponse;

/**
 * Implementacion de los metodos para consumir el servicio pb53
 * @author Edgar Daniel Garcia Serrano
 * 
 * NTT DATA
 * Noviembre 2022
 * 
 */
@Service
public class PrestamoNominaService implements IPrestamoNominaService {
	
	@Value("${magisterio.pb53.url}")
	private String uri;
	
	@Value("${magisterio.pb53.token.url}")
	private String tokenUri;
	
	@Value("${magisterio.pb53.scope}")
	private String apiScope;
	
	@Value("${magisterio.pb53.client-id}")
	private String apiClientId;
	
	@Value("${magisterio.pb53.client-secret}")
	private String apiClientSecret;
	
	@Value("${magisterio.pb53.ibm-client-id}")
	private String ibmClientId;
	
	@Autowired
	private RestTemplate rt;
	
	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public PrestamoNominaResponse createPrestamoNomina(long idProducto, long idSubproducto, PrestamoNominaRequest request) throws JsonProcessingException {
		
		try {
			// Obtener token para consumir el servicio
			String token = this.obtenerToken();
			
			if(token != null) {				
				// Se agregan los headers
				HttpHeaders headers = new HttpHeaders();
				headers.setBearerAuth(token);
				headers.add("X-IBM-Client-Id", ibmClientId);
				headers.setContentType(MediaType.APPLICATION_JSON);
				
				// Construccion y envio de la peticion
				HttpEntity<PrestamoNominaRequest> entity = new HttpEntity<>(request, headers);
				ResponseEntity<PrestamoNominaResponse> responseEntity = rt.exchange(uri, HttpMethod.POST, entity, PrestamoNominaResponse.class, idProducto, idSubproducto);
				
				return responseEntity.getBody();
			}else {
				throw new ObjectNotFoundException("La petición no ha sido autorizada");
			}
		}catch(HttpClientErrorException httpEx) {
			return objectMapper.readValue(httpEx.getResponseBodyAsString(), PrestamoNominaResponse.class);
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
