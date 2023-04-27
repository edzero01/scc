package mx.isban.scc.utilerias.plantillas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mx.isban.scc.dao.SccMxMaeProductoDAO;
import mx.isban.scc.model.SccMxMaeProducto;
import mx.isban.scc.model.dto.SccMxTablaCaratulaDTO;
import mx.isban.scc.model.dto.SccMxTablaCaratulaValorDTO;

class PlantillaCaratulaTest {
	
	@InjectMocks
	private PlantillaCaratula plantilla = new PlantillaCaratula();
	
	@Mock
	private SccMxMaeProductoDAO dao;
	
	@BeforeEach
    public void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

	@Test
	void formatoDivisaUnDecimalTest() {
		String result = plantilla.formatoDivisaUnDecimal((Double)1000000.00);
		assertEquals(" 1,000,000.0", result);
	}
	
	@Test
	void docCaratulaCatorcenalTest() {
		
		// Configuracion datos de prueba
		List<SccMxTablaCaratulaValorDTO> tablaCaratulaValor = new ArrayList<>();		
		
		SccMxTablaCaratulaDTO tablaCaratula = new SccMxTablaCaratulaDTO();
		tablaCaratula = getTablaCaratula("Catorcenal", null, null);
		
		ByteArrayOutputStream plantillaStream = new ByteArrayOutputStream();
		createDocument();
		plantillaStream = readDocument();
		
		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();
		
		SccMxMaeProducto prod = new SccMxMaeProducto();
		prod = getProd();
		
		// Configuracion de la respuesta de prueba
		when(dao.buscaProdPorId(59)).thenReturn(prod);
		
		// Accion
		plantillaOut = plantilla.docCaratula(plantillaStream, tablaCaratulaValor, tablaCaratula);
		
		// Evaluacion del resultado
		assertTrue(plantillaOut.size()>0);
		
	}
	
	@Test
	void docCaratulaSemanalTest() {
		
		// Configuracion datos de prueba
		List<SccMxTablaCaratulaValorDTO> tablaCaratulaValor = new ArrayList<>();		
		
		SccMxTablaCaratulaDTO tablaCaratula = new SccMxTablaCaratulaDTO();
		tablaCaratula = getTablaCaratula("Semanal", 1.0, 100);
		
		ByteArrayOutputStream plantillaStream = new ByteArrayOutputStream();
		createDocument();
		plantillaStream = readDocument();
		
		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();
		
		SccMxMaeProducto prod = new SccMxMaeProducto();
		prod = getProd();
		
		// Configuracion de la respuesta de prueba
		when(dao.buscaProdPorId(59)).thenReturn(prod);
		
		// Accion
		plantillaOut = plantilla.docCaratula(plantillaStream, tablaCaratulaValor, tablaCaratula);
		
		// Evaluacion del resultado
		assertTrue(plantillaOut.size()>0);
		
	}
	
	@Test
	void docCaratulaQuincenalTest() {
		
		// Configuracion datos de prueba
		List<SccMxTablaCaratulaValorDTO> tablaCaratulaValor = new ArrayList<>();		
		
		SccMxTablaCaratulaDTO tablaCaratula = new SccMxTablaCaratulaDTO();
		tablaCaratula = getTablaCaratula("Quincenal", 2.0, null);
		
		ByteArrayOutputStream plantillaStream = new ByteArrayOutputStream();
		createDocument();
		plantillaStream = readDocument();
		
		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();
		
		SccMxMaeProducto prod = new SccMxMaeProducto();
		prod = getProd();
		
		// Configuracion de la respuesta de prueba
		when(dao.buscaProdPorId(59)).thenReturn(prod);
		
		// Accion
		plantillaOut = plantilla.docCaratula(plantillaStream, tablaCaratulaValor, tablaCaratula);
		
		// Evaluacion del resultado
		assertTrue(plantillaOut.size()>0);
		
	}
	
	@Test
	void docCaratulaMensualTest() {
		
		// Configuracion datos de prueba
		List<SccMxTablaCaratulaValorDTO> tablaCaratulaValor = new ArrayList<>();		
		
		SccMxTablaCaratulaDTO tablaCaratula = new SccMxTablaCaratulaDTO();
		tablaCaratula = getTablaCaratula("Mensual", null, 100);
		
		ByteArrayOutputStream plantillaStream = new ByteArrayOutputStream();
		createDocument();
		plantillaStream = readDocument();
		
		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();
		
		SccMxMaeProducto prod = new SccMxMaeProducto();
		prod = getProd();
		
		// Configuracion de la respuesta de prueba
		when(dao.buscaProdPorId(59)).thenReturn(prod);
		
		// Accion
		plantillaOut = plantilla.docCaratula(plantillaStream, tablaCaratulaValor, tablaCaratula);
		
		// Evaluacion del resultado
		assertTrue(plantillaOut.size()>0);
		
	}
	
	/**
	 * Metodo Auxiliar: Genera un objeto tipo SccMxMaeProducto con datos genericos
	 * @return
	 */
	private SccMxMaeProducto getProd() {
		SccMxMaeProducto prod = new SccMxMaeProducto();
		prod.setDscCoberturaSeg("Cubre el saldo insoluto del crédito en caso de Desempleo involuntario, Fallecimiento, Invalidez total y permanente.");
		prod.setDscEntidadCrd("BANCO SANTANDER (MEXICO) S.A., INSTITUCION DE BANCA MULTIPLE, GRUPO FINANCIERO SANTANDER MEXICO");
		prod.setDscExclusionSeg("En vida, suicidio; y en desempleo, renuncia o perdida voluntaria del trabajo. Para el caso del seguro de desempleo, éste tiene un periodo de carencia de cobertura de 30 días naturales a partir de la disposición del crédito, por lo que si el siniestro ocurriera durante este periodo de tiempo no se cubriría el monto asegurado.");
		return prod;
	}
	
	/**
	 * Metodo Auxiliar: Genera un objeto de tipo SccMxTablaCaratulaDTO
	 * @return
	 */
	private SccMxTablaCaratulaDTO getTablaCaratula(String periodicidad, Double caucion, Integer puntos) {
		SccMxTablaCaratulaDTO tablaCaratula = new SccMxTablaCaratulaDTO();
		tablaCaratula.setCat(2.0);
		tablaCaratula.setComisionAperturaSinIva(8.0);
		tablaCaratula.setDiaPago("6 de cada mes");
		tablaCaratula.setIdProducto(Integer.toUnsignedLong(59));
		tablaCaratula.setMontoPagar(5.0);
		tablaCaratula.setPeriodicidad(periodicidad);
		tablaCaratula.setPlazo(7);
		tablaCaratula.setProducto("Nomina Magisterio");
		tablaCaratula.setTasaInteresAnual(3.0);
		tablaCaratula.setTipoOferta("1");
		tablaCaratula.setValorCredito(4.0);
		tablaCaratula.setCaucion(caucion);
		tablaCaratula.setPuntos(puntos);
		return tablaCaratula;
	}
	
	/**
	 * Metodo Auxiliar:  Genera un documento docx en blanco para pruebas 
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
	 * Metodo Auxiliar: Lee el documento de prueba y regresa un objeto ByteArrayOutputStream
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
