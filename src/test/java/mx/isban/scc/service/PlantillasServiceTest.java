package mx.isban.scc.service;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import mx.isban.scc.utilerias.plantillas.helper.IPlantillaLookupStrategy;

class PlantillasServiceTest {
	
	@InjectMocks
	private PlantillasService plantillaService = new PlantillasService();
	
	@Mock
	private IPlantillaLookupStrategy strategy;
	
	@Mock
	private IPlantillaLoaderService plantTipoProd;
	
	@BeforeEach
	public void initMocks() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void obtenerPlantillaRies139Sftp() {
		when(strategy.lookup(6)).thenReturn(plantTipoProd);
		when(strategy.lookup(6).lookup(6, Integer.parseInt("2"))).thenReturn(new ByteArrayOutputStream());
		
		assertTrue(plantillaService.obtenerPlantillaRies139Sftp("2").size() == 0);
	}
	
	@Test
	void obtenerPlantillaCaratulaSftp() {
		when(strategy.lookup(6)).thenReturn(plantTipoProd);
		when(strategy.lookup(6).lookup(6, Integer.parseInt("2"))).thenReturn(new ByteArrayOutputStream());
		
		assertTrue(plantillaService.obtenerPlantillaCaratulaSftp("2").size() == 0);

	}

}
