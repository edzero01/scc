package mx.isban.scc.service;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mx.isban.scc.model.dto.SccMxTablaCaratulaDTO;
import mx.isban.scc.model.dto.SccMxTablaMagisterioDTO;
import mx.isban.scc.model.dto.SccMxTablaRiesDTO;
import mx.isban.scc.utilerias.CalculaCaratula;
import mx.isban.scc.utilerias.CalculaPlanMagisterio;
import mx.isban.scc.utilerias.CalculaRies;

class CalculoMagisterioServiceTest {

	@InjectMocks
	private CalculoMagisterioService tablaService = new CalculoMagisterioService();

	@Mock
	private CalculaRies calculaRies;
	
	@Mock
	private CalculaCaratula calculaCaratula;
	
	@Mock
	private CalculaPlanMagisterio calculaPlanMagisterio;

	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void obtenTablaRiesTest() {

		// datos de prueba
		ByteArrayOutputStream plantillaStream = new ByteArrayOutputStream();
		SccMxTablaRiesDTO tablaRies = new SccMxTablaRiesDTO();
		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();

		// Configuracion de la respuesta de prueba
		when(calculaRies.calculaRies(tablaRies, plantillaStream)).thenReturn(plantillaStream);

		// Accion
		plantillaOut = tablaService.obtenTablaRies(tablaRies, plantillaStream);

		// Evaluacion del resultado
		assertTrue(plantillaOut.size() == 0);

	}

	@Test
	void obtenTablaRiesExceptionTest() {
		// datos de prueba
		ByteArrayOutputStream plantillaStream = new ByteArrayOutputStream();
		SccMxTablaRiesDTO tablaRies = new SccMxTablaRiesDTO();
		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();

		// Configuracion de la respuesta de prueba
		when(calculaRies.calculaRies(tablaRies, plantillaStream)).thenThrow(new NumberFormatException());
		plantillaOut = tablaService.obtenTablaRies(tablaRies, plantillaStream);
		
		// Accion
		assertNull(plantillaOut);
	}
	
	@Test
	void obtenTablaCaratulaTest() {

		// datos de prueba
		ByteArrayOutputStream plantillaStream = new ByteArrayOutputStream();
		SccMxTablaCaratulaDTO tablaCaratula = new SccMxTablaCaratulaDTO();
		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();

		// Configuracion de la respuesta de prueba
		when(calculaCaratula.calculaCaratula(tablaCaratula, plantillaStream)).thenReturn(plantillaStream);

		// Accion
		plantillaOut = tablaService.obtenTablaCaratula(tablaCaratula, plantillaStream);

		// Evaluacion del resultado
		assertTrue(plantillaOut.size() == 0);
	}
	
	@Test
	void obtenTablaCaratulaExceptionTest() {
		// datos de prueba
		ByteArrayOutputStream plantillaStream = new ByteArrayOutputStream();
		SccMxTablaCaratulaDTO tablaCaratula = new SccMxTablaCaratulaDTO();
		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();

		// Configuracion de la respuesta de prueba
		when(calculaCaratula.calculaCaratula(tablaCaratula, plantillaStream)).thenThrow(new NumberFormatException());
		plantillaOut = tablaService.obtenTablaCaratula(tablaCaratula, plantillaStream);
		
		// Accion
		assertNull(plantillaOut);
	}
	
	@Test
	void obtenTablaPlanMagisterioTest() {

		// datos de prueba
		ByteArrayOutputStream plantillaStream = new ByteArrayOutputStream();
		SccMxTablaMagisterioDTO tablaMagisterio = new SccMxTablaMagisterioDTO();
		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();

		// Configuracion de la respuesta de prueba
		when(calculaPlanMagisterio.calculaPlanMagisterio(tablaMagisterio, plantillaStream)).thenReturn(plantillaStream);

		// Accion
		plantillaOut = tablaService.obtenTablaPlanMagisterio(tablaMagisterio, plantillaStream);

		// Evaluacion del resultado
		assertTrue(plantillaOut.size() == 0);
	}
	
	@Test
	void obtenTablaPlanMagisterioExceptionTest() {
		// datos de prueba
		ByteArrayOutputStream plantillaStream = new ByteArrayOutputStream();
		SccMxTablaMagisterioDTO tablaMagisterio = new SccMxTablaMagisterioDTO();
		ByteArrayOutputStream plantillaOut = new ByteArrayOutputStream();

		// Configuracion de la respuesta de prueba
		when(calculaPlanMagisterio.calculaPlanMagisterio(tablaMagisterio, plantillaStream)).thenThrow(new NumberFormatException());
		plantillaOut = tablaService.obtenTablaPlanMagisterio(tablaMagisterio, plantillaStream);
		
		// Accion
		assertNull(plantillaOut);
	}
}