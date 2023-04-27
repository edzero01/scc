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

import mx.isban.scc.model.dto.SccMxTablaCaratulaDTO;
import mx.isban.scc.model.dto.SccMxTablaCaratulaValorDTO;
import mx.isban.scc.utilerias.plantillas.PlantillaCaratula;

class CalculaCaratulaTest {
	
	@InjectMocks
	private CalculaCaratula utileriaCaratula = new CalculaCaratula();
	
	@Mock
	PlantillaCaratula caratula;
	
	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void calculaCaratula() {
		// Datos de prueba
		SccMxTablaCaratulaDTO caratulaDTO = new SccMxTablaCaratulaDTO();
		ByteArrayOutputStream plantillaDocx = new ByteArrayOutputStream();
		List<SccMxTablaCaratulaValorDTO> tablaCaratulaValor = new ArrayList<>();
		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();
		
		//Configuración de respuesta
		when(caratula.docCaratula(plantillaDocx, tablaCaratulaValor, caratulaDTO)).thenReturn(plantillaDocx);
		plantillaOut = utileriaCaratula.calculaCaratula(caratulaDTO, plantillaDocx);
		
		//Evaluacion de la respuesta
		assertTrue(plantillaOut.size() == 0);
	}

}
