package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import mx.isban.scc.model.dto.SccMxTablaRiesDTO;
import mx.isban.scc.service.ICalculoMagisterioService;
import mx.isban.scc.simulador.controller.RiesRestController;

import java.io.ByteArrayOutputStream;


public class RiesTest {
	
	@Mock
	private ICalculoMagisterioService negocioService;
	
	@InjectMocks
	private RiesRestController riesRestController;
	
	SccMxTablaRiesDTO RECORD1 = new SccMxTablaRiesDTO();
	
	SccMxTablaRiesDTO RECORD2 = new SccMxTablaRiesDTO();
	
	ByteArrayOutputStream docStream = new ByteArrayOutputStream();
	
	
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void obtenCaratula() throws Exception {
		
		RECORD1.setSucursal(1234);
		RECORD1.setNombreCliente("Juan Perez");
		RECORD1.setCodigoCliente(123456);
		RECORD1.setNoCuenta(67890L);
		RECORD1.setModalidad("campaña");
		RECORD1.setTasaInteresAnual(Double.valueOf(3));
		RECORD1.setNumeroPagos(4);
		RECORD1.setPlazo(5);
		RECORD1.setPeriodicidad("Mensual");
		RECORD1.setFormaPago("efectivo");
		RECORD1.setSubproducto("Credito nomina magisterio");
		RECORD1.setValorCredito(Double.valueOf(5000));
		RECORD1.setComisionAperturaSinIva(Double.valueOf(6));
		RECORD1.setComisionPorDisposicion(Double.valueOf(7));
		RECORD1.setSeguros(Double.valueOf(8));
		RECORD1.setSaldoRes("4500");
		RECORD1.setImporteNetoCredito(Double.valueOf(5500));
		RECORD1.setCuota(Double.valueOf(9));
		RECORD1.setCat(Double.valueOf(10));
	
		ByteArrayOutputStream plantillaStream = null;
	}

}
