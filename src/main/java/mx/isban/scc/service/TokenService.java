package mx.isban.scc.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import mx.isban.scc.model.dto.TokenDTO;
import mx.isban.scc.utilerias.TokenData;

/**
 * Implementacion de la interfaz que consulta 
 * Si el token es valido
 * @author Hitss
 * 
 * Octubre 2019 
 * 
 * Sprint 5
 */
@Service
public class TokenService implements ITokenService {
	
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TokenService.class);
	
	/**
	 * Valida si el el token es válido
	 * 
	 * @param tokenData TokenData a validar
	 * @return TokenData TokenData.isValid()==true si es valido, false de otra forma
	 */
	@Override
	public TokenData isValid(TokenData tokenData) {
		//Aqui debe llamar al mock o al servicio de Santander
		/*
		 * poner las llamadas a los servicios
		 */
		boolean isValid = true;
	
		tokenData.setValid(isValid);
		tokenData.setUpdateStatus(isValid);
		tokenData.setLastValidated(new Date());
		return tokenData;
	}

	/**
	 * Llama al servicio que extiende la vida del token
	 * 
	 * @param tokenData TokenData a validar
	 * @return TokenData TokenData.getLastValidated() 
	 * muestra si se extendio la vida del token con exito, 
	 * false de otra manera
	 */
	@Override
	public TokenData extendTokenLife(TokenData tokenData) {
		/*
		 * poner las llamadas a los servicios de Santander
		 */
		boolean isValid = true;
		
		tokenData.setValid(isValid);
		tokenData.setUpdateStatus(isValid);
		tokenData.setLastRenewed(new Date());
		return tokenData;
	}
	/**
	 * Llama al servicio que obtiene 
	 * la estructura de centros de costo
	 * 
	 * @param tokenData TokenData  a validar
	 * @return TokenData TokenData.getCostCenter() contendrá el valor del centro de costos
	 */
	@Override
	public TokenData costCenter(TokenData tokenData) {
		/*
		 * poner las llamadas a los servicios
		 * no se si se guardara la estructura en TokenData
		 * se debe obtener del servicio del portal: GetLocationFromCorpID
		 */
		try {
			   Integer myCc = getCostCenterFromHashtable(tokenData.getToken());
			   //PARA QUE NO SEA NULO NUNCA
			   if (myCc == null) {
				   myCc =  Integer.valueOf(1);
			   }
			   tokenData.setCostCenter(myCc);
			   tokenData.setUpdateStatus(true);
			   tokenData.setValid(true);
			   
		} catch (NumberFormatException nfe) {
			LOGGER.error(nfe.getMessage(), nfe);
			tokenData.setUpdateStatus(false);
			tokenData.setValid(false);
		}
		return tokenData;
	}
	

	/**
	 * Metodo para parsear los datos del token de acceso
	 * @param strToken String token recibido
	 * @return TokenData Datos del Token
	 */
	@Override
	public TokenData parseToken(String strToken) {
		TokenData retVal = new TokenData();
		TokenDTO tokenDTO = new TokenDTO();
		//Primero se decodifica el string base 64		 
		byte[] byteArray = Base64.getDecoder().decode(strToken);
		String decodedToken = Arrays.toString(byteArray);
		//Se separa en tokens con StringTokenizer
		//El separador es '#'
		StringTokenizer st = new StringTokenizer(decodedToken, "#");
		ArrayList<String> alTokens = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			alTokens.add(st.nextToken());
		}
		Object[] objArray = alTokens.toArray();
		String[] tokenArray = Arrays.copyOf(objArray, objArray.length, String[].class);
		
		tokenDTO.setSessionId(tokenArray[0]);
		tokenDTO.setIpAddress(tokenArray[1]);
		tokenDTO.setEpochCaducidad(Long.parseLong(tokenArray[2]));
		tokenDTO.setUserDataXML(tokenArray[3]);
		tokenDTO.setCipherType(tokenArray[4]);
		tokenDTO.setTokenVersion(tokenArray[5]);
		tokenDTO.setTokenIssuer(tokenArray[6]);
		tokenDTO.setCipherXML(tokenArray[7]);
		tokenDTO.setDigitalSignatureType(tokenArray[8]);
		tokenDTO.setDigitalSignature(tokenArray[9]);
		
		//ANTES DE COMPROBAR LA FIRMA SE PONE EL TOKEN COMO INVALIDO
		retVal.setUpdateStatus(false);
		retVal.setValid(false);
		
		//Comprobar la firma
		if (checkSignature(tokenDTO.getDigitalSignatureType(), tokenDTO.getDigitalSignature())) {
			retVal.setToken(strToken);
			retVal.setTokenDTO(tokenDTO);
			//Llamar al servicio de costCenter
			Integer costCenter = Integer.valueOf(2);
			retVal.setCostCenter(costCenter);
			//AQUI PODRIAMOS HACER ALGUNOS CALCULOS
			retVal.setLastRenewed(new Date());
			retVal.setLastRenewed(new Date());
			retVal.setValid(true);
		}

		return retVal;
	}

	/**
	 * Obtiene el centro de costos de una hashtable 
	 * Este método se usa cuando está conectado como Mock
	 * (fuera de la intranet de Santander)
	 * @param token  String a buscar en la hashtable
	 * @return Integer Centro de costos 
	 */
	private Integer getCostCenterFromHashtable(String token) {
		HashMap<String, Integer> htTokenCc = initializeHashtable();
		return htTokenCc.get(token); 
	}
	
	/**
	 * Inicializa la hashtable this.htTokenCc
	 * Este método se usa cuando está conectado como Mock
	 * (fuera de la intranet de Santander)
	 */
	private HashMap<String, Integer> initializeHashtable() {
		/*
		 * Tipo de Usuario	Usuario	Contraseña	Codigo de Puesto	Descripción de Puesto	Centro de Costos
		 *  Sucursal	n011449	Jn28santan	SUB405	EJECUTIVO CTA. A UNIVERSIDADES	2
		 *  Sucursal	n011450	Jn28santan	SUB301	DIRECTOR SUCURSAL AA	4
		 *  Sucursal	n011451	Jn28santan	SUB602	SUBDIRECTOR SUCURSAL	5
		 *  Sucursal	n011452	Jn28santan	SUB404	EJECUTIVO CTA. B	6
		 *  Sucursal	n011453	Jn28santan	SUB306	EJECUTIVO DE CUENTA PREMIER	6
		 *  Sucursal	n011454	Jn28santan	SUB307	GERENTE NEGOCIO SELECT	11
		 *  Sucursal	n011455	Jn28santan	SUB400	EJECUTIVO CTA. A	15
		 *  Sucursal	n011456	Jn28santan	SUB200	DIRECTOR SUCURSAL AAA	5043
		 *  Contact Center	n011457	Jn28santan	GTB696	Gerente M&M	3272
		 *  Contact Center	n011458	Jn28santan	GTB706	Gerente Mesa de Validación	3272
		 *  Contact Center	n011459	Jn28santan	GTB013	Gerente RRAA	3272
		 *  Contact Center	n011460	Jn28santan	GTB699	Gerente Créditos Personales	3272
		 *  Contact Center	n011461	Jn28santan	ESB279	Ejecutivo M&M	3272
		 *  Contact Center	n011462	Jn28santan	EJB001	Ejecutivo RRAA	3272
		 *  Contact Center	n011463	Jn28santan	CAX701	Ejecutivo Mesa de Validación	3272
		 *  Contact Center	n011464	Jn28santan	ESB281	Ejecutivo Créditos Personales	3272
		 *
		 *	TOKENS
		 *  https://generate.plus/en/base64
		 *  sSX3-QAQ_T5p4wP-llXNfg
		 *  euGguhGT51Z0xn9HNa2iNg
		 */
		HashMap<String, Integer> htTokenCc = new HashMap<String, Integer>();
	    htTokenCc.put("4X3F1jNURqfDbXCUFWrcfQ", Integer.valueOf(2));
		htTokenCc.put("12Cek66UUs2Nvpz6-GJyrQ", Integer.valueOf(4));
		htTokenCc.put("KElDAps5ekJoaD5AuTVCCw", Integer.valueOf(5));
		htTokenCc.put("IZG-dA93kdE8Tq1no0c2Ag", Integer.valueOf(6));
		htTokenCc.put("YlD0SN9ZOKAZnjWEsUPGnQ", Integer.valueOf(11));
		htTokenCc.put("V3kfxoWRE7pgJYEZy_Ex0Q", Integer.valueOf(15));
		htTokenCc.put("d_-RmesY9KT59i9Rb-gz3g", Integer.valueOf(5043));
		htTokenCc.put("dhih5_z8KD43VBa33Tf8BQ",  Integer.valueOf(3272));
		return htTokenCc;
	}
	
	/**
	 * Metodo para validar la firma digital del token
	 * @param signatureType String tipo de firma digital
	 * @param signature String firma digital
	 * @return boolean validez de la firma
	 */
	private boolean checkSignature(String signatureType, String signature) {
		boolean retVal = false;
		//AQUÍ TENDRÍAMOS QUE VALIDAR ALGO EN SERIO
		retVal = signatureType != null && signature != null;
		return retVal;
	}
	
}
