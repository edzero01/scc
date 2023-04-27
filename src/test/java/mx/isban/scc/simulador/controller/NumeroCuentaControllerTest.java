package mx.isban.scc.simulador.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import mx.isban.scc.exception.ObjectNotFoundException;
import mx.isban.scc.model.lza0.NumCuentaEstatus;
import mx.isban.scc.model.lza0.NumCuentaResponse;
import mx.isban.scc.service.NumeroCuentaService;

@WebMvcTest(NumeroCuentaController.class)
@ContextConfiguration(classes = NumeroCuentaController.class)
class NumeroCuentaControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private NumeroCuentaService service;
	
	@Test
	void getCurrentAccountsTest() throws Exception {
		NumCuentaResponse numCuentaResponse = new NumCuentaResponse();
		numCuentaResponse = this.getNumCuentaResponseAux("INFO");
		Mockito.when(service.obtenerNumerosCuenta(ArgumentMatchers.any(), ArgumentMatchers.any(),
				ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(numCuentaResponse);
		
		mockMvc.perform(get("/api/simulador/cliente/123456/cuentas?ownerInd=S&activeInd=S&subseqRec=S&cursorValue=1")).andExpect(status().isOk());	
	}
	
	@Test
	void getCurrentAccountsBadRequestTest() throws Exception {
		NumCuentaResponse numCuentaResponse = new NumCuentaResponse();
		numCuentaResponse = this.getNumCuentaResponseAux("ERROR");
		Mockito.when(service.obtenerNumerosCuenta(ArgumentMatchers.any(), ArgumentMatchers.any(),
				ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(numCuentaResponse);
		
		mockMvc.perform(get("/api/simulador/cliente/123456/cuentas?ownerInd=S&activeInd=S&subseqRec=S&cursorValue=1")).andExpect(status().is4xxClientError());	
	}
	
	@Test
	void getCurrentAccountsObjectNotFoundExceptionTest() throws Exception {
		
		Mockito.when(service.obtenerNumerosCuenta(ArgumentMatchers.any(), ArgumentMatchers.any(),
				ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())).thenThrow(new ObjectNotFoundException ());
		
		mockMvc.perform(get("/api/simulador/cliente/123456/cuentas?ownerInd=S&activeInd=S&subseqRec=S&cursorValue=1")).andExpect(status().is4xxClientError());	
	}
	
	@Test
	void getCurrentAccountsExceptionTest() throws Exception {
		
		Mockito.when(service.obtenerNumerosCuenta(ArgumentMatchers.any(), ArgumentMatchers.any(),
				ArgumentMatchers.any(), ArgumentMatchers.any(), ArgumentMatchers.any())).thenThrow(new RuntimeException ());
		
		mockMvc.perform(get("/api/simulador/cliente/123456/cuentas?ownerInd=S&activeInd=S&subseqRec=S&cursorValue=1")).andExpect(status().is5xxServerError());	
	}
	private NumCuentaResponse getNumCuentaResponseAux(String statusConst) {
		NumCuentaResponse mockResponse = new NumCuentaResponse();
		NumCuentaEstatus status = new NumCuentaEstatus();
		status.setSeverity(statusConst);
		
		mockResponse.setStatus(status);
		
		return mockResponse;
	}

}
