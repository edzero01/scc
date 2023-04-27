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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import mx.isban.scc.model.dto.SccMxAmtzAmortizationPeriodDataDTO;
import mx.isban.scc.model.dto.SccMxAmtzCatMagisterioDTO;
import mx.isban.scc.model.dto.SccMxAmtzInfoDTO;
import mx.isban.scc.model.dto.SccMxAmtzInstalmentCurAmtDTO;
import mx.isban.scc.model.dto.SccMxAmtzRecDTO;
import mx.isban.scc.model.dto.SccMxTablaMagisterioDTO;

class PlantillaPlanMagisterioTest {
	
	@InjectMocks
	private PlantillaPlanMagisterio plantilla = new PlantillaPlanMagisterio();
	
	
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
	void docAmortizacionTest() {
		
		// Configuracion datos de prueba
		List<SccMxAmtzAmortizationPeriodDataDTO> tablaMagisterioValor = new ArrayList<>();		
		
		SccMxTablaMagisterioDTO  tablaMagisterio = new SccMxTablaMagisterioDTO ();
		tablaMagisterio = getTablaMagisterio();
		
		ByteArrayOutputStream plantillaStream = new ByteArrayOutputStream();
		createDocument();
		plantillaStream = readDocument();
		
		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();
		
		
		// Configuracion de la respuesta de prueba
		
		
		// Accion
		plantillaOut = plantilla.docAmortizacion(plantillaStream, tablaMagisterioValor, tablaMagisterio);
		
		// Evaluacion del resultado
		assertTrue(plantillaOut.size()>0);
		
	}
	
	
	
	/**
	 * Metodo Auxiliar: Genera un objeto tipo SccMxMaeProducto con datos genericos
	 * @return
	 */

	
	/**
	 * Metodo Auxiliar: Genera un objeto de tipo SccMxTablaCaratulaDTO
	 * @return
	 */
	private SccMxTablaMagisterioDTO getTablaMagisterio() {
		SccMxTablaMagisterioDTO tablaMagis = new SccMxTablaMagisterioDTO();
		SccMxAmtzCatMagisterioDTO tablaMagisCat = new SccMxAmtzCatMagisterioDTO();
		SccMxAmtzRecDTO tablaMagisRec = new SccMxAmtzRecDTO();
		SccMxAmtzInfoDTO tablaMagisInfo = new SccMxAmtzInfoDTO();
		SccMxAmtzInstalmentCurAmtDTO tablaMagisInfoCur = new SccMxAmtzInstalmentCurAmtDTO();
		
		tablaMagisCat.setCat(1.0);
		tablaMagisCat.setCodigoCliente(12345L);
		tablaMagisCat.setComisionPorApertura(2.0);
		tablaMagisCat.setComisionPorDisposicion(3.0);
		tablaMagisCat.setDescPeriodo("Periodo");
		tablaMagisCat.setImporteNetoCredito(4567.89);
		tablaMagisCat.setNombreCliente("Nombre");
		tablaMagisCat.setNumeroPagos(10L);
		tablaMagisCat.setPlazo(11L);
		tablaMagisCat.setProducto("Producto");
		tablaMagisCat.setSeguros("Seguros");
		tablaMagisCat.setTasaInteresAnual(4.0);
		
		tablaMagisInfoCur.setAmt("12.85");
		
		tablaMagisInfo.setInstalmentCurAmt(tablaMagisInfoCur);
		
		
		tablaMagisRec.setAmortizationInfo(tablaMagisInfo);
		
		tablaMagis.setCaucion(0L);
		tablaMagis.setGracia("Gracia");
		tablaMagis.setPlan(3L);
		tablaMagis.setPlantilla("4");
		tablaMagis.setRecurrencia("Recurrencia");
		tablaMagis.setRqUID("RqUID");
		tablaMagis.setAmortizationRec(tablaMagisRec);
		tablaMagis.setTablaCat(tablaMagisCat);
		
		
		
		return tablaMagis;
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
