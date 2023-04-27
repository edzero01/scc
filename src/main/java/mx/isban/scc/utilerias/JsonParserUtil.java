package mx.isban.scc.utilerias;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Clase de utileria que decodifica la cadena en base 64 proveniente del cliente con la información
 * de los parámetros que llegan en las peticiones GET
 * además de eso convierte el objeto json al tipo
 * de dato pasado como parámetro 
 */
@Component
public class JsonParserUtil {
	
	/**
	 * Decodifica la cadena en base 64 proveniente del cliente con la información
	 * de los parámetros que llegan en las peticiones GET
	 * además de eso convierte el objeto json al tipo
	 * de dato pasado como parámetro 
	 * @param <T> Clase del tipo de dato que se debe decodificar
	 * @param b64String la cadena en base 64 a decodificar
	 * @param objectType El tipo de datpo que se requiere decodificar
	 * @return Regresa el objeto de tipo de datos indicado en el template
	 * @throws JsonParseException si ocurre un error al parsear el json
	 * @throws JsonMappingException Si ocurre un error al parsear el json a objeto
	 * SE RETIRAN los throws anteriores debido a que el sonar indica que son un 
	 * subconjunto de IOException
	 * @throws IOException En caso de error al leer el objeto y pasarlo a Object de tipo T
	 */
	public <T> T fromJSON(String b64String , Class<T> objectType) throws  IOException {
		String json = new String( Base64.getDecoder().decode(b64String), "ISO-8859-1");
		ObjectMapper oMaper = new ObjectMapper();

		return oMaper.readValue(json, objectType);
	}

}
