package mx.isban.scc.service;
import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.model.dto.SccMxCatPSGDTO;
import mx.isban.scc.model.dto.SccMxTablaAmtzInDTO;
import mx.isban.scc.utilerias.CalculaPAPRCG;
import mx.isban.scc.utilerias.CalculaPAPRSG;
import mx.isban.scc.utilerias.CalculaPAPUCG;
import mx.isban.scc.utilerias.CalculaPAPUSG;
import mx.isban.scc.utilerias.CalculaPFPRCG;
import mx.isban.scc.utilerias.CalculaPFPRSG;
import mx.isban.scc.utilerias.CalculaPFPUCG;
import mx.isban.scc.utilerias.CalculaPFPUSG;
import mx.isban.scc.utilerias.CalculoCatPSG;
import mx.isban.scc.utilerias.CalculoCatPorTirUtil;

/**
 * Implementacion de los metodos de interfaz para calculo de tablas de amortizacion y cat
 * Con estos calculos se puede generar la tabla de amortizaicon
 * que es el resultado y objetivo principal del simulador
 * ya que el cliente obtiene el plan de pagos por mes o periodo elegido
 * con sus montos e intereses

 * 
 * Simulador de Credito al Consumo
 * Global Hitss
 * Mayo 2019
 * 
 *
 * 
 * 
 * @author Christopher Espina Implementación del servicio para el cálculo de la
 *         tabla de amortización
 */
@Service
public class CalculoTblAmtzService implements ICalculoTblAmtzService {

	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CalculoTblAmtzService.class);
	/**
	 * constante de clase, con finalidad de calculos para plan frances
	 * pago unico con gracia
	 */
	@Autowired
	private  CalculaPFPUCG calculaTablaFrancesPUCG;
	/**
	 * constante de clase, con finalidad de calculos para plan frances
	 * prima unica sin gracia
	 */
	@Autowired
	private  CalculaPFPUSG calculaTablaFrancesPUSG;
	/**
	 * constante de clase, con finalidad de calculos para plan frances
	 * prima recurrente con gracia
	 */
	@Autowired
	private  CalculaPFPRCG calculaTablaFrancesPRCG;
	/**
	 * constante de clase, con finalidad de calculos para plan frances
	 * prima recurrente sin gracia 
	 */
	@Autowired
	private  CalculaPFPRSG calculaTablaFrancesPRSG;
	/**
	 * constante de clase, con finalidad de calculos para plan aleman
	 * prima unica con gracia 
	 */
	@Autowired
	private  CalculaPAPUCG calculaTablaAlemanPUCG;
	/**
	 * constante de clase, con finalidad de calculos para plan aleman
	 * prima unica sin gracia
	 */
	@Autowired
	private  CalculaPAPUSG calculaTablaAlemanPUSG;
	/**
	 * constante de clase, con finalidad de calculos para plan aleman
	 * prima recurrente con gracia 
	 */
	@Autowired
	private  CalculaPAPRCG calculaTablaAlemanPRCG;
	/**
	 * constante de clase, con finalidad de calculos para plan aleman
	 * prima recurrente sin gracia 
	 */
	@Autowired
	private  CalculaPAPRSG calculaTablaAlemanPRSG;
	/**
	 * Implementación de metodo abstracto de interfaz ObtenTablaPlanFrances
	 * 
	 * @author Christopher Espina
	 * @param tablaAmtzIn SccMxTablaAmtzInDTO
	 * dato de entrada desde front
	 * @param plantillaDocx ByteArrayOutputStream
	 * @exception NumberFormatException 
	 * excepcion de formato
	 * @return tablaAmtzValor 
	 * regresa valor de la tabla formada
	 */
	@Override
	public ByteArrayOutputStream obtenTablaPlanFrancesPUCG(SccMxTablaAmtzInDTO tablaAmtzIn,
			                                               ByteArrayOutputStream plantillaDocx) {
		ByteArrayOutputStream plantillaDocxOut = null;
		try {
			plantillaDocxOut = calculaTablaFrancesPUCG.calculaPlanFrancesPRCG(tablaAmtzIn, plantillaDocx);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return plantillaDocxOut;
	}

	/**
	 * Implementación de metodo abstracto de interfaz ObtenTablaPlanFrances
	 * 
	 * @author Christopher Espina
	 * @param tablaAmtzIn SccMxTablaAmtzInDTO  
	 * dato de entrada desde front
	 * @param plantillaDocx ByteArrayOutputStream
	 * @exception NumberFormatException 
	 * excepcion de formato
	 * @return ByteArrayOutputStream 
	 * regresa el stream que representa la plantilla Docx
	 * Cargada con Datos
	 */
	@Override
	public ByteArrayOutputStream obtenTablaPlanFrancesPUSG(SccMxTablaAmtzInDTO tablaAmtzIn, 
			                                               ByteArrayOutputStream plantillaDocx) {
		ByteArrayOutputStream plantillaDocxOut = null;
		try {
			plantillaDocxOut = calculaTablaFrancesPUSG.calculaPlanFrancesPUSG(tablaAmtzIn, plantillaDocx);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return plantillaDocxOut;
	}
	
	/**
	 * Implementación de metodo abstracto de interfaz ObtenTablaPlanFrances
	 * 
	 * @author Christopher Espina
	 * @param tablaAmtzIn SccMxTablaAmtzInDTO  
	 * dato de entrada desde front
	 * @param plantillaDocx ByteArrayOutputStream
	 * @exception NumberFormatException 
	 * excepcion de formato
	 * @return tablaAmtzValor 
	 * regresa valor de la tabla formada
	 */
	@Override
	public ByteArrayOutputStream obtenTablaPlanFrancesPRCG(SccMxTablaAmtzInDTO tablaAmtzIn, 
			                                               ByteArrayOutputStream plantillaDocx) {
		ByteArrayOutputStream plantillaDocxOut = null;
		try {
			plantillaDocxOut = calculaTablaFrancesPRCG.calculaPlanFrancesPRCG(tablaAmtzIn, plantillaDocx);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return plantillaDocxOut;
	}
	
	/**
	 * Implementación de metodo abstracto de interfaz ObtenTablaPlanFrances
	 * 
	 * @author Christopher Espina
	 * @param tablaAmtzIn SccMxTablaAmtzInDTO  
	 * dato de entrada desde front
	 * @param plantillaDocx ByteArrayOutputStream
	 * @exception NumberFormatException 
	 * excepcion de formato
	 * @return tablaAmtzValor 
	 * regresa valor de la tabla formada
	 */
	@Override
	public ByteArrayOutputStream obtenTablaPlanFrancesPRSG(SccMxTablaAmtzInDTO tablaAmtzIn, 
			                                               ByteArrayOutputStream plantillaDocx) {
		ByteArrayOutputStream plantillaDocxOut = null;
		try {
			plantillaDocxOut = calculaTablaFrancesPRSG.calculaPlanFrancesPRSG(tablaAmtzIn, plantillaDocx);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return plantillaDocxOut;
	}

	/**
	 * Implementación de metodo abstracto de interfaz ObtenTablaPlanAleman
	 * 
	 * @author Christopher Espina
	 * @param tablaAmtzIn SccMxTablaAmtzInDTO  
	 * dato de entrada desde front
	 * @param plantillaDocx ByteArrayOutputStream
	 * @exception NumberFormatException 
	 * excepcion de formato
	 * @return tablaAmtzValor 
	 * regresa valor de la tabla formada
	 */
	@Override
	public ByteArrayOutputStream obtenTablaPlanAlemanPUCG(SccMxTablaAmtzInDTO tablaAmtzIn, 
			                                              ByteArrayOutputStream plantillaDocx) {
		ByteArrayOutputStream plantillaDocxOut = null;
		try {
			plantillaDocxOut = calculaTablaAlemanPUCG.calculaPlanAlemanPUCG(tablaAmtzIn, plantillaDocx);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return plantillaDocxOut;
	}
	
	/**
	 * Implementación de metodo abstracto de interfaz ObtenTablaPlanAleman
	 * 
	 * @author Christopher Espina
	 * @param tablaAmtzIn SccMxTablaAmtzInDTO  
	 * dato de entrada desde front
	 * @param plantillaDocx ByteArrayOutputStream
	 * @exception NumberFormatException 
	 * excepcion de formato
	 * @return tablaAmtzValor 
	 * regresa valor de la tabla formada
	 */
	@Override
	public ByteArrayOutputStream obtenTablaPlanAlemanPUSG(SccMxTablaAmtzInDTO tablaAmtzIn, 
			                                              ByteArrayOutputStream plantillaDocx) {
		ByteArrayOutputStream plantillaDocxOut = null;
		try {
			plantillaDocxOut = calculaTablaAlemanPUSG.calculaPlanAlemanPUSG(tablaAmtzIn, plantillaDocx);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return plantillaDocxOut;
	}
	
	/**
	 * Implementación de metodo abstracto de interfaz ObtenTablaPlanAleman
	 * 
	 * @author Christopher Espina
	 * @param tablaAmtzIn SccMxTablaAmtzInDTO  
	 * dato de entrada desde front
	 * @param plantillaDocx ByteArrayOutputStream
	 * @exception NumberFormatException 
	 * excepcion de formato
	 * @return tablaAmtzValor 
	 * regresa valor de la tabla formada
	 */
	@Override
	public ByteArrayOutputStream obtenTablaPlanAlemanPRCG(SccMxTablaAmtzInDTO tablaAmtzIn, 
			                                              ByteArrayOutputStream plantillaDocx) {
		ByteArrayOutputStream plantillaDocxOut = null;
		try {
			plantillaDocxOut = calculaTablaAlemanPRCG.calculaPlanAlemanPRCG(tablaAmtzIn, plantillaDocx);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return plantillaDocxOut;
	}
	
	/**
	 * Implementación de metodo abstracto de interfaz ObtenTablaPlanAleman
	 * 
	 * @author Christopher Espina
	 * @param tablaAmtzIn SccMxTablaAmtzInDTO  
	 * dato de entrada desde front
	 * @param plantillaDocx ByteArrayOutputStream
	 * @exception NumberFormatException 
	 * excepcion de formato
	 * @return tablaAmtzValor 
	 * regresa valor de la tabla formada
	 */
	@Override
	public ByteArrayOutputStream obtenTablaPlanAlemanPRSG(SccMxTablaAmtzInDTO tablaAmtzIn, 
			                                              ByteArrayOutputStream plantillaDocx) {
		ByteArrayOutputStream plantillaDocxOut = null;
		try {
			plantillaDocxOut = calculaTablaAlemanPRSG.calculaPlanAlemanPRSG(tablaAmtzIn, plantillaDocx);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return plantillaDocxOut;
	}

	/**
	 * Implementación de metodo abstracto de interfaz obtenCatViaTir
	 * 
	 * @author Christopher Espina
	 * @param tablaAmtzIn SccMxTablaAmtzInDTO  
	 * dato de entrada desde front
	 * @param plan 
	 * tipo de plan para calcular cat
	 * @exception NumberFormatException 
	 * excepcion de formato
	 * @return cat 
	 * regresa valor de cat
	 */
	@Override
	public Double obtenCatViaTir(SccMxTablaAmtzInDTO tablaAmtzIn, Long plan) {
		CalculoCatPorTirUtil calculaCat = new CalculoCatPorTirUtil();
		Double cat = 0.00;
		try {
			cat = calculaCat.obtenCatViaTir(tablaAmtzIn, plan);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			return cat;
		}
		return cat;
	}

	
	/**
	 * Implementación de metodo abstracto de interfaz obtenCatViaTir
	 * 
	 * @author Christopher Espina
	 * @param datosCAT SccMxCatPSGDTO  
	 * @return cat 
	 * regresa valor de cat
	 */
	@Override
	public Double obtenCatPSG(SccMxCatPSGDTO datosCAT) {
		CalculoCatPSG calculaCatPSG = new CalculoCatPSG();
		Double cat = 0.00;
		try {
			cat = calculaCatPSG.obtenCatPSG(datosCAT);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
			return cat;
		}
		return cat;
	}
}
