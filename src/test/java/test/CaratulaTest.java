package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import mx.isban.scc.model.dto.SccMxTablaCaratulaDTO;
import mx.isban.scc.service.ICalculoMagisterioService;
import mx.isban.scc.simulador.controller.CaratulaRestController;
import java.io.ByteArrayOutputStream;
import static org.mockito.Mockito.verify;

public class CaratulaTest {
	
	@Mock
	private ICalculoMagisterioService negocioService;
	
	@InjectMocks
	private CaratulaRestController caratulaRestController;
	
	SccMxTablaCaratulaDTO RECORD1 = new SccMxTablaCaratulaDTO();
	
	SccMxTablaCaratulaDTO RECORD2 = new SccMxTablaCaratulaDTO();
	
	ByteArrayOutputStream plantillaStream = null;
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void obtenCaratula() throws Exception {
		
		RECORD1.setProducto("Nomina magisterio");
		RECORD1.setTipoOferta("1");
		RECORD1.setCat(Double.valueOf(2));
		RECORD1.setTasaInteresAnual(Double.valueOf(3));
		RECORD1.setValorCredito(Double.valueOf(4000));
		RECORD1.setMontoPagar(Double.valueOf(5000));
		RECORD1.setDiaPago("6 de cada mes");
		RECORD1.setPlazo(7);
		RECORD1.setComisionAperturaSinIva(Double.valueOf(8));
		RECORD1.setPeriodicidad("Semanal");
		RECORD1.setIdProducto(Long.valueOf(59));
		
		ByteArrayOutputStream plantillaStream = null;		
	}
}
