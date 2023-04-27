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

import mx.isban.scc.model.dto.SccMxTablaRiesDTO;
import mx.isban.scc.model.dto.SccMxTablaRiesValorDTO;
import mx.isban.scc.utilerias.plantillas.PlantillaRies;

class CalculaRiesTest {

	@InjectMocks
	private CalculaRies utileriaRies = new CalculaRies();
	
	@Mock
	PlantillaRies ries;
	
	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void calculaCaratula() {
		// Datos de prueba
		SccMxTablaRiesDTO riesDTO = new SccMxTablaRiesDTO();
		ByteArrayOutputStream plantillaDocx = new ByteArrayOutputStream();
		List<SccMxTablaRiesValorDTO> tablaRiesValor = new ArrayList<>();
		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();
		
		//Configuración de respuesta
		when(ries.docRies(plantillaDocx, tablaRiesValor, riesDTO)).thenReturn(plantillaDocx);
		plantillaOut = utileriaRies.calculaRies(riesDTO, plantillaDocx);
		
		//Evaluacion de la respuesta
		assertTrue(plantillaOut.size() == 0);
	}

}
