package mx.isban.scc.simulador.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import mx.isban.scc.exception.ObjectNotFoundException;
import mx.isban.scc.model.pb53.PrestamoNominaResponse;
import mx.isban.scc.model.pb53.Status;
import mx.isban.scc.service.PrestamoNominaService;

@WebMvcTest(PrestamoNominaController.class)
@ContextConfiguration(classes = PrestamoNominaController.class)
class PrestamoNominaControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PrestamoNominaService service;

	@Test
	void prestamoNominaTest() throws Exception {
		PrestamoNominaResponse prestamoResponse = new PrestamoNominaResponse();
		prestamoResponse = this.getPrestamoResponseAux("INFO");
		
		String request = this.getStringRequest();
		Mockito.when(service.createPrestamoNomina(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong(), ArgumentMatchers.any())).thenReturn(prestamoResponse);
		
		mockMvc.perform(
				post("/api/simulador/prestamo-nomina/offers/123456/123456/cuotas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request))
		.andExpect(status().isOk());	
	}
	
	@Test
	void prestamoNominaBadRequestTest() throws Exception {
		PrestamoNominaResponse prestamoResponse = new PrestamoNominaResponse();
		prestamoResponse = this.getPrestamoResponseAux("ERROR");
		
		Mockito.when(service.createPrestamoNomina(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong(), ArgumentMatchers.any())).thenReturn(prestamoResponse);
		
		String request = this.getStringRequest();
		mockMvc.perform(
				post("/api/simulador/prestamo-nomina/offers/123456/123456/cuotas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request))
		.andExpect(status().is4xxClientError());	
	}
	
	@Test
	void prestamoNominaObjectNotFoundExceptionTest() throws Exception {
		
		Mockito.when(service.createPrestamoNomina(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong(), ArgumentMatchers.any())).thenThrow(new ObjectNotFoundException ());
		
		String request = this.getStringRequest();
		mockMvc.perform(
				post("/api/simulador/prestamo-nomina/offers/123456/123456/cuotas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request))
		.andExpect(status().is4xxClientError());	
	}
	
	@Test
	void prestamoNominaExceptionTest() throws Exception {
		
		Mockito.when(service.createPrestamoNomina(ArgumentMatchers.anyLong(), ArgumentMatchers.anyLong(), ArgumentMatchers.any())).thenThrow(new RuntimeException());
		
		String request = this.getStringRequest();
		mockMvc.perform(
				post("/api/simulador/prestamo-nomina/offers/123456/123456/cuotas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(request))
		.andExpect(status().is5xxServerError());	
	}
	
	
	private PrestamoNominaResponse getPrestamoResponseAux(String statusDesc) {
		PrestamoNominaResponse auxResponse = new PrestamoNominaResponse();
		Status status = new Status();
		
		status.setSeverity(statusDesc);
		auxResponse.setStatus(status);
		return auxResponse;
	}
	
	private String getStringRequest() {
		String request = "{\r\n"
				+ "  \"rqUID\": \"8137566219927552\",\r\n"
				+ "  \"amortizationSel\": {\r\n"
				+ "    \"requestDt\": \"2009-09-11\",\r\n"
				+ "    \"totalCurAmt\": {\r\n"
				+ "      \"amt\": 46.95838233\r\n"
				+ "    },\r\n"
				+ "    \"recurRule\": {\r\n"
				+ "      \"recurType\": \"bewruph\",\r\n"
				+ "      \"dayOfMonth\": 72164002\r\n"
				+ "    },\r\n"
				+ "    \"rateMatrixTier\": [\r\n"
				+ "      {\r\n"
				+ "        \"tier\": \"ligahmotihr\",\r\n"
				+ "        \"intAPR\": 58.96547006,\r\n"
				+ "        \"rate\": 30.48730083\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"tier\": \"webzav\",\r\n"
				+ "        \"intAPR\": 56.28398887,\r\n"
				+ "        \"rate\": 44.75612172\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"tier\": \"codjoragubal\",\r\n"
				+ "        \"intAPR\": 96.54370375,\r\n"
				+ "        \"rate\": 63.57794069\r\n"
				+ "      }\r\n"
				+ "    ],\r\n"
				+ "    \"acctKeys\": {\r\n"
				+ "      \"subProductIdent\": \"548434381635584\",\r\n"
				+ "      \"productIdent\": \"1569268221083648\",\r\n"
				+ "      \"curCode\": {\r\n"
				+ "        \"curCodeValue\": \"99.33\",\r\n"
				+ "        \"curCodeType\": \"igdivd\"\r\n"
				+ "      }\r\n"
				+ "    },\r\n"
				+ "    \"term\": {\r\n"
				+ "      \"count\": 10458904,\r\n"
				+ "      \"termUnits\": \"cihkoriskifo\"\r\n"
				+ "    },\r\n"
				+ "    \"reviewFrequency\": {\r\n"
				+ "      \"recurTypeCode\": \"cehwujumoriwamaz\"\r\n"
				+ "    }\r\n"
				+ "  }\r\n"
				+ "}";
		return request;
	}

}
