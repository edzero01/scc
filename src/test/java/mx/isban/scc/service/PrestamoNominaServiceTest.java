package mx.isban.scc.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import java.nio.charset.Charset;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.isban.scc.exception.ObjectNotFoundException;
import mx.isban.scc.model.pb53.PrestamoNominaResponse;
import mx.isban.scc.model.pb53.Status;

class PrestamoNominaServiceTest {
	
	@Mock
	private RestTemplate rt;
	
	@Mock
	private ObjectMapper objectmapper;
	
	@Spy
	@InjectMocks
	private PrestamoNominaService service = new PrestamoNominaService();
	
	@BeforeEach
	public void initMocks() {
		ReflectionTestUtils.setField(service, "uri", "http://some.com.mx");
		ReflectionTestUtils.setField(service, "tokenUri", "http://some.com.mx");
		ReflectionTestUtils.setField(service, "apiScope", "string");
		ReflectionTestUtils.setField(service, "apiClientId", "string");
		ReflectionTestUtils.setField(service, "apiClientSecret", "string");
		ReflectionTestUtils.setField(service, "ibmClientId", "string");
		MockitoAnnotations.openMocks(this);
	}

	@SuppressWarnings("unchecked")
	@Test
	void createPrestamoNominaTest() throws Exception {
		String mockToken = "{\"access_token\": \"EJmmscBGw9LPCNAdcFqunxrkTopP\"}";
		ResponseEntity<String> mockResponseToken = new ResponseEntity<String>(mockToken, HttpStatus.OK);
		
		PrestamoNominaResponse prestamoResponse = new PrestamoNominaResponse();
		prestamoResponse = this.getPrestamoResponseAux("INFO");
		ResponseEntity<PrestamoNominaResponse> mockResponse = new ResponseEntity<PrestamoNominaResponse>(prestamoResponse, HttpStatus.OK);
		
		when(rt.exchange(anyString(), eq(HttpMethod.POST), (HttpEntity<?>)any(), (Class<String>)any())).thenReturn(mockResponseToken);
		when(rt.exchange(anyString(), eq(HttpMethod.POST), (HttpEntity<?>)any(), (Class<PrestamoNominaResponse>)any(), anyLong(), anyLong())).thenReturn(mockResponse);
		
		PrestamoNominaResponse response = service.createPrestamoNomina(123456, 123456, null);
		assertEquals("INFO", response.getStatus().getSeverity());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void createPrestamoNominaNoTokenTest() throws Exception {
		
		when(rt.exchange(anyString(), eq(HttpMethod.POST), (HttpEntity<?>)any(), (Class<String>)any())).thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, "La petición no ha sido autorizada"));
		
		Exception exception = assertThrows(ObjectNotFoundException.class, () -> {
			service.createPrestamoNomina(123456, 123456, null);
		});
		
		String expectedMessage = "La petición no ha sido autorizada";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void createPrestamoNominaException() throws Exception {
		
		String mockToken = "{\"access_token\": \"EJmmscBGw9LPCNAdcFqunxrkTopP\"}";
		ResponseEntity<String> mockResponseToken = new ResponseEntity<String>(mockToken, HttpStatus.OK);
		
		PrestamoNominaResponse prestamoResponse = new PrestamoNominaResponse();
		prestamoResponse = this.getPrestamoResponseAux("ERROR");
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(prestamoResponse);
		jsonString = jsonString.replaceAll("[^\\n\\r\\t\\p{Print}]", "");
		
		byte[] data = SerializationUtils.serialize(jsonString);
		when(rt.exchange(anyString(), eq(HttpMethod.POST), (HttpEntity<?>)any(), (Class<String>)any())).thenReturn(mockResponseToken);
		when(rt.exchange(anyString(), eq(HttpMethod.POST), (HttpEntity<?>)any(), (Class<PrestamoNominaResponse>)any(), anyLong(), anyLong())).thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, "String", data, Charset.forName("UTF-8")));
		
		PrestamoNominaResponse response = service.createPrestamoNomina(123456, 123456, null);
		assertNull(response);
	}
	
	private PrestamoNominaResponse getPrestamoResponseAux(String statusDesc) {
		PrestamoNominaResponse auxResponse = new PrestamoNominaResponse();
		Status status = new Status();
		
		status.setSeverity(statusDesc);
		auxResponse.setStatus(status);
		return auxResponse;
	}

}
