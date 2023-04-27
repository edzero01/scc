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
import mx.isban.scc.model.lza0.NumCuentaEstatus;
import mx.isban.scc.model.lza0.NumCuentaResponse;

class NumeroCuentaServiceTest {
	
	@Mock
	private RestTemplate rt;
	
	@Mock
	private ObjectMapper objectmapper;
	
	@Spy
	@InjectMocks
	private NumeroCuentaService service = new NumeroCuentaService();

	
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
	void obtenerNumerosCuentaTest() throws Exception{
		
		String mockToken = "{\"access_token\": \"EJmmscBGw9LPCNAdcFqunxrkTopP\"}";
		ResponseEntity<String> mockResponseToken = new ResponseEntity<String>(mockToken, HttpStatus.OK);
		
		NumCuentaResponse numCuentaResponse = new NumCuentaResponse();
		numCuentaResponse = this.getNumCuentaResponseAux("INFO");
		ResponseEntity<NumCuentaResponse> mockResponse = new ResponseEntity<NumCuentaResponse>(numCuentaResponse, HttpStatus.OK);
		
		when(rt.exchange(anyString(), eq(HttpMethod.POST), (HttpEntity<?>)any(), (Class<String>)any())).thenReturn(mockResponseToken);
		when(rt.exchange(anyString(), eq(HttpMethod.GET), (HttpEntity<?>)any(), (Class<NumCuentaResponse>)any(), anyLong())).thenReturn(mockResponse);
		
		NumCuentaResponse response = service.obtenerNumerosCuenta("123456", "S", "S", "S", "1");
		assertEquals("INFO", response.getStatus().getSeverity());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void obtenerNumerosCuentaNoTokenTest() throws Exception {
		
		when(rt.exchange(anyString(), eq(HttpMethod.POST), (HttpEntity<?>)any(), (Class<String>)any())).thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, "La petición no ha sido autorizada"));
		
		Exception exception = assertThrows(ObjectNotFoundException.class, () -> {
			service.obtenerNumerosCuenta("123456", "S", "S", "S", "1");
	    });
		
		String expectedMessage = "La petición no ha sido autorizada";
	    String actualMessage = exception.getMessage();

	    assertTrue(actualMessage.contains(expectedMessage));
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	void obtenerNumerosCuentaExceptionTest() throws Exception {
		
		String mockToken = "{\"access_token\": \"EJmmscBGw9LPCNAdcFqunxrkTopP\"}";
		ResponseEntity<String> mockResponseToken = new ResponseEntity<String>(mockToken, HttpStatus.OK);
		
		NumCuentaResponse numCuentaResponse = new NumCuentaResponse();
		numCuentaResponse = this.getNumCuentaResponseAux("ERROR");
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = mapper.writeValueAsString(numCuentaResponse);
		jsonString = jsonString.replaceAll("[^\\n\\r\\t\\p{Print}]", "");
		
		byte[] data = SerializationUtils.serialize(jsonString);
		
		when(rt.exchange(anyString(), eq(HttpMethod.POST), (HttpEntity<?>)any(), (Class<String>)any())).thenReturn(mockResponseToken);
		when(rt.exchange(anyString(), eq(HttpMethod.GET), (HttpEntity<?>)any(), (Class<NumCuentaResponse>)any(), anyLong())).thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST, "String", data, Charset.forName("UTF-8")));
		
		NumCuentaResponse response = service.obtenerNumerosCuenta("123456", "S", "S", "S", "1");
		assertNull(response);
	}
	
	private NumCuentaResponse getNumCuentaResponseAux(String statusConst) {

		NumCuentaResponse mockResponse = new NumCuentaResponse();
		NumCuentaEstatus status = new NumCuentaEstatus();
		status.setSeverity(statusConst);
		
		mockResponse.setStatus(status);
		
		return mockResponse;
	}
}
