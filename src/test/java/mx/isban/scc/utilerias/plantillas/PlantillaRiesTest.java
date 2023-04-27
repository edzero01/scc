package mx.isban.scc.utilerias.plantillas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.junit.jupiter.api.Test;

import mx.isban.scc.model.dto.SccMxTablaRiesDTO;
import mx.isban.scc.model.dto.SccMxTablaRiesValorDTO;

class PlantillaRiesTest {
	
	private PlantillaRies plantilla = new PlantillaRies();

	@Test
	void formatoDivisaUnDecimalTest() {
		String result = plantilla.formatoDivisaUnDecimal((Double)1000000.00);
		assertEquals(" 1,000,000.0", result);
	}

	@Test
	void docRiesSimpleTest() {
		// Configuración de datos de prueba
		List<SccMxTablaRiesValorDTO> tablaRiesValor = new ArrayList<>();

		SccMxTablaRiesDTO tablaRies = new SccMxTablaRiesDTO();
		tablaRies = getTablaRies("Catorcenal", null, null, null, null);

		ByteArrayOutputStream plantillaStream = new ByteArrayOutputStream();
		createDocument();
		plantillaStream = readDocument();

		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();

		// Accion
		plantillaOut = plantilla.docRies(plantillaStream, tablaRiesValor, tablaRies);

		// Evaluacion del resultado
		assertTrue(plantillaOut.size() > 0);
	}
	
	@Test
	void docRiesDatosClienteTest() {
		// Configuración de datos de prueba
		List<SccMxTablaRiesValorDTO> tablaRiesValor = new ArrayList<>();

		SccMxTablaRiesDTO tablaRies = new SccMxTablaRiesDTO();
		tablaRies = getTablaRies("Catorcenal", 100.0, 100, "Felipe Angeles", 999);

		ByteArrayOutputStream plantillaStream = new ByteArrayOutputStream();
		createDocument();
		plantillaStream = readDocument();

		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();

		// Accion
		plantillaOut = plantilla.docRies(plantillaStream, tablaRiesValor, tablaRies);

		// Evaluacion del resultado
		assertTrue(plantillaOut.size() > 0);
	}
	
	@Test
	void docRiesDatosCaucionTest() {
		// Configuración de datos de prueba
		List<SccMxTablaRiesValorDTO> tablaRiesValor = new ArrayList<>();

		SccMxTablaRiesDTO tablaRies = new SccMxTablaRiesDTO();
		tablaRies = getTablaRies("Catorcenal", 100.0, null, "Felipe Angeles", 999);

		ByteArrayOutputStream plantillaStream = new ByteArrayOutputStream();
		createDocument();
		plantillaStream = readDocument();

		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();

		// Accion
		plantillaOut = plantilla.docRies(plantillaStream, tablaRiesValor, tablaRies);

		// Evaluacion del resultado
		assertTrue(plantillaOut.size() > 0);
	}
	
	/**
	 * Metodo Auxiliar: Genera un objeto de tipo SccMxTablaRiesDTO
	 * @return
	 */
	private SccMxTablaRiesDTO getTablaRies(String periodicidad, Double caucion, Integer puntos, String nombre, Integer codCliente) {
		SccMxTablaRiesDTO tablaRies = new SccMxTablaRiesDTO();
		tablaRies.setCat(2.0);
		tablaRies.setComisionAperturaSinIva(8.0);
		tablaRies.setMontoPagar(5.0);
		tablaRies.setPeriodicidad(periodicidad);
		tablaRies.setPlazo(7);
		tablaRies.setProducto("Nomina Magisterio");
		tablaRies.setTasaInteresAnual(3.0);
		tablaRies.setValorCredito(4.0);
		tablaRies.setCaucion(caucion);
		tablaRies.setPuntos(puntos);
		tablaRies.setSucursal(1234);
		tablaRies.setNoCuenta(123456L);
		tablaRies.setModalidad("Campaña");
		tablaRies.setFormaPago(periodicidad);
		tablaRies.setSaldoRes("100");
		tablaRies.setImporteNetoCredito(100000.0);
		tablaRies.setCuota(100.0);
		tablaRies.setNumeroPagos(50);
		tablaRies.setNombreCliente(nombre);
		tablaRies.setCodigoCliente(codCliente);
		return tablaRies;
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
