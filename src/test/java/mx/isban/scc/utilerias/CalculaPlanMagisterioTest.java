package mx.isban.scc.utilerias;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mx.isban.scc.model.dto.SccMxAmtzAmortizationPeriodDataDTO;
import mx.isban.scc.model.dto.SccMxAmtzInfoDTO;
import mx.isban.scc.model.dto.SccMxAmtzInstalmentCurAmtDTO;
import mx.isban.scc.model.dto.SccMxAmtzRecDTO;
import mx.isban.scc.model.dto.SccMxTablaMagisterioDTO;
import mx.isban.scc.utilerias.plantillas.PlantillaPlanMagisterio;

class CalculaPlanMagisterioTest {

	@InjectMocks
	private CalculaPlanMagisterio utileriaPlanMagisterio = new CalculaPlanMagisterio();

	@Mock
	PlantillaPlanMagisterio magisterio;

	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void calculaMagisterio() {
		// Datos de prueba
		SccMxTablaMagisterioDTO magisterioDTO = new SccMxTablaMagisterioDTO();
		ByteArrayOutputStream plantillaDocx = new ByteArrayOutputStream();
		List<SccMxAmtzAmortizationPeriodDataDTO> tablaMagisterio = new ArrayList<>();
		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();

		SccMxAmtzRecDTO tablaMagisRec = new SccMxAmtzRecDTO();
		SccMxAmtzInfoDTO tablaMagisInfo = new SccMxAmtzInfoDTO();
		SccMxAmtzInstalmentCurAmtDTO tablaMagisInfoCur = new SccMxAmtzInstalmentCurAmtDTO();

		tablaMagisInfoCur.setAmt("12.85");

		tablaMagisInfo.setInstalmentCurAmt(tablaMagisInfoCur);

		tablaMagisRec.setAmortizationInfo(tablaMagisInfo);
		
		SccMxAmtzAmortizationPeriodDataDTO magisPD = new SccMxAmtzAmortizationPeriodDataDTO();
		 
		magisPD.setDueDt("17-12-95");
		magisPD.setCompositeCurAmt(null);
		magisPD.setInstalmentCurAmt(null);
		magisPD.setStmtRunningBal(null);
		magisPD.setTotalCurAmt(null);
		
		tablaMagisterio.add(magisPD);
		
		tablaMagisInfo.setAmortizationPeriodData(tablaMagisterio);
		
		magisterioDTO.setAmortizationRec(tablaMagisRec);
		
		
		
		for (int i = 0; i < 1; i++) {
			SccMxAmtzAmortizationPeriodDataDTO tablaMagisValor = new SccMxAmtzAmortizationPeriodDataDTO();
			tablaMagisValor = magisterioDTO.getAmortizationRec().getAmortizationInfo().getAmortizationPeriodData().get(i);
			
			tablaMagisterio.add(tablaMagisValor);
		}
	

		// Configuración de respuesta
		when(magisterio.docAmortizacion(plantillaDocx, tablaMagisterio, magisterioDTO)).thenReturn(plantillaDocx);
		plantillaOut = utileriaPlanMagisterio.calculaPlanMagisterio(magisterioDTO, plantillaDocx);

		// Evaluacion de la respuesta
		assertTrue(plantillaOut.size() == 0);
	}

}
