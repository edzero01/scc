package mx.isban.scc.utilerias;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.isban.scc.model.SimpleResponse;
import mx.isban.scc.model.dto.AuditoriaDTO;

/**
 * Clase para invocar el servicio que inserta las pistas de auditoría
 * @author Gabriel Dolores García 2019
 *
 */
@Component
public final class PistasAuditoriaHelper {
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(PistasAuditoriaHelper.class);

	/**
	 * Objeto para obtener la ocnfiguración del servicio de las pistas de auditoría
	 */
	@Autowired
	private PistasAuditoriaConfig config;

	/**
	 * Guarda pistas de audiroría invocando al servicio rest de las pistas
	 * y se agregó un try catch en caso que no pueda acceder al 
	 * endpoint y no genere errores  que puedan estarse 
	 * propagando hasta el cliente ocasionando que se muestre el 
	 * mensaje fatal del [OBJECT OBJECT]
	 * @param dto AuditoriaDTO con la información a enviar al servicio
	 */
	public void guardaPista(AuditoriaDTO dto) {
		String endPoint = config.getEndPoint();
		RestTemplate restCall = new RestTemplate();
		ResponseEntity<SimpleResponse> resp = null;
		try {
			resp = restCall.postForEntity(endPoint, dto, SimpleResponse.class);
			if (resp.getStatusCode().is2xxSuccessful()) {
				LOGGER.info("Pista de auditoría generada para el objeto " + getJsonREpresentation(dto));
			} else {
				LOGGER.error("Ocurrió un error al guardar la pista de auditoría");
			}
		} catch (RestClientException e) {
			LOGGER.error("Ocurrió unerror de comunicación con las pistas de auditoria",e);
		}

		
	}

	/**
	 * Obteiene la representación en String con fotmato JSON del objeto a enviar a
	 * auditoría
	 * 
	 * @param dto AuditoriaDTO con la información a guardar en la pista de auditoría
	 * @return la representación en String con fotmato JSON del objeto a enviar a
	 *         auditoría
	 */
	private String getJsonREpresentation(AuditoriaDTO dto) {
		ObjectMapper mapper = new ObjectMapper();
		String json = AuditoriaDTO.class.getCanonicalName();
		try {
			json = mapper.writeValueAsString(dto);
		} catch (JsonProcessingException e) {
			LOGGER.error("No se logró serializar a JSON el DTO",e);
		}
		return json;
	}

}
