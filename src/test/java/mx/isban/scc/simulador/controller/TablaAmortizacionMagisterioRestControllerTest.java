package mx.isban.scc.simulador.controller;

import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessException;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import mx.isban.scc.service.CalculoMagisterioService;
import mx.isban.scc.service.CalculoTblAmtzService;
import mx.isban.scc.service.PlantillasService;
import mx.isban.scc.utilerias.plantillas.ConPDF;
import mx.isban.scc.utilerias.plantillas.PlantillaCaratula;

@WebMvcTest(TablaAmortizacionMagisterioRestController.class)
@ContextConfiguration(classes = TablaAmortizacionMagisterioRestController.class)
class TablaAmortizacionMagisterioRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CalculoMagisterioService service;

	@MockBean
	private CalculoTblAmtzService negocioService;

	@MockBean
	private PlantillasService buscaPlatnilla;

	@MockBean
	private ConPDF pdf;

	@InjectMocks
	private PlantillaCaratula plantilla = new PlantillaCaratula();

	@Test
	void tablaAmtzMagisterioTest() throws Exception {
		ByteArrayOutputStream plantillaStream = new ByteArrayOutputStream();
		createDocument();
		plantillaStream = readDocument();

		String request = this.getStringRequest();
		Mockito.when(buscaPlatnilla.obtenerPlantillaTablaAmortiz(ArgumentMatchers.any())).thenReturn(plantillaStream);

		Mockito.when(service.obtenTablaPlanMagisterio(ArgumentMatchers.any(), ArgumentMatchers.any()))
				.thenReturn(plantillaStream);

		Mockito.when(pdf.convertToPDF(plantillaStream)).thenReturn(plantillaStream);

		mockMvc.perform(post("/api/simulador/tabla_amortizacion_magisterio").contentType(MediaType.APPLICATION_JSON)
				.content(request)).andExpect(status().isOk());
	}

	@Test
	void tablaAmtzMagisterioExceptionTest() throws Exception {
		
		
		doThrow(new DataAccessException("Error Test") {
			private static final long serialVersionUID = 1L;
		}).when(buscaPlatnilla).obtenerPlantillaTablaAmortiz(ArgumentMatchers.any());

		
		String request = this.getStringRequest();
		mockMvc.perform(post("/api/simulador/tabla_amortizacion_magisterio").contentType(MediaType.APPLICATION_JSON)
				.content(request)).andExpect(status().is5xxServerError());
	}

	private String getStringRequest() {
		String request = "{\r\n" + "    \"plan\": 3,\r\n" + "    \"gracia\": \"M:0;Q:0;C:0;S:0;A:0;\",\r\n"
				+ "    \"recurrencia\": \"1\",\r\n" + "    \"caucion\": 0,\r\n" + "    \"plantilla\": \"4\",\r\n"
				+ "    \"tablaCat\": {\r\n" + "        \"cat\": 37.6,\r\n" + "        \"codigoCliente\": 4248,\r\n"
				+ "        \"comisionPorApertura\": 0,\r\n" + "        \"comisionPorDisposicion\": 1.75,\r\n"
				+ "        \"importeNetoCredito\": 19518.121739130438,\r\n"
				+ "        \"nombreCliente\": \"Hugo Garcia Perez\",\r\n" + "        \"numeroPagos\": 48,\r\n"
				+ "        \"descPeriodo\":\"Mensual\",\r\n" + "        \"plazo\": 48,\r\n"
				+ "        \"seguros\": \"seguros\",\r\n" + "        \"tasaInteresAnual\": 3,\r\n"
				+ "        \"producto\": \"Crédito Nomina Magisterio - Restitución MA\"\r\n" + "    },\r\n"
				+ "    \"amortizationRec\": {\r\n" + "        \"amortizationInfo\": {\r\n"
				+ "            \"instalmentCount\": \"038\", \r\n" + "            \"instalmentCurAmt\": {\r\n"
				+ "                \"amt\": \"0000000006430514\" \r\n" + "            },\r\n"
				+ "            \"totalCurAmt\": {\r\n" + "                \"amt\": \"0000000240303565\" \r\n"
				+ "            },\r\n" + "            \"intRateData\": {\r\n"
				+ "                \"rateMatrixTier\": [\r\n" + "                    {\r\n"
				+ "                        \"intAPR\": \"007470\"\r\n" + "                    }\r\n"
				+ "                ]\r\n" + "            },\r\n" + "         \"amortizationPeriodData\": [\r\n"
				+ "		 ]\r\n" + "		}\r\n" + "    },\r\n" + "    \"rqUID\": \"196c55656435f184030cfe03\"\r\n" + "}";

		return request;
	}

	/**
	 * Metodo Auxiliar: Genera un documento docx en blanco para pruebas
	 */
	private void createDocument() {

		try (XWPFDocument document = new XWPFDocument()) {

			FileOutputStream out = null;
			out = new FileOutputStream(new File("example.docx"));
			document.write(out);
			out.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Metodo Auxiliar: Lee el documento de prueba y regresa un objeto
	 * ByteArrayOutputStream
	 * 
	 * @return
	 */
	private ByteArrayOutputStream readDocument() {
		try {
			FileInputStream fis = new FileInputStream("example.docx");
			byte[] bytes = IOUtils.toByteArray(fis);
			ByteArrayOutputStream baos = new ByteArrayOutputStream(bytes.length);
			baos.write(bytes, 0, bytes.length);
			return baos;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
