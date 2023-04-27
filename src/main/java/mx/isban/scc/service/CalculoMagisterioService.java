package mx.isban.scc.service;

import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.model.dto.SccMxTablaCaratulaDTO;
import mx.isban.scc.model.dto.SccMxTablaMagisterioDTO;
import mx.isban.scc.model.dto.SccMxTablaRiesDTO;
import mx.isban.scc.utilerias.CalculaCaratula;
import mx.isban.scc.utilerias.CalculaPlanMagisterio;
import mx.isban.scc.utilerias.CalculaRies;

@Service
public class CalculoMagisterioService implements ICalculoMagisterioService {
	
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con finalidad
	 * de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(CalculoMagisterioService.class);
	
	/**
	 * constante de clase, con finalidad de calculos plantilla Ries139
	 */
	@Autowired
	private  CalculaRies calculaRies;
	
	/**
	 * constante de clase, con finalidad de calculos plantilla Carátula de crédito
	 */
	@Autowired
	private  CalculaCaratula calculaCaratula;
	
	/**
	 * constante de clase, con finalidad de calculos plantilla Carátula de crédito
	 */
	@Autowired
	private  CalculaPlanMagisterio calculaPlanMagisterio;

	/**
	 * Implementación de metodo abstracto de interfaz ObtenTablaRies
	 * 
	 * @author José Luis Garcia
	 */
	@Override
	public ByteArrayOutputStream obtenTablaRies(SccMxTablaRiesDTO tablaRies139, 
			                                               ByteArrayOutputStream plantillaDocx) {
		ByteArrayOutputStream plantillaDocxOut = null;
		try {
			plantillaDocxOut = calculaRies.calculaRies(tablaRies139, plantillaDocx);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return plantillaDocxOut;
	}
	
	/**
	 * Implementación de metodo abstracto de interfaz ObtenTablaCaratula
	 * 
	 * @author José Luis Garcia
	 */
	@Override
	public ByteArrayOutputStream obtenTablaCaratula(SccMxTablaCaratulaDTO tablaAmtzIn, 
			                                               ByteArrayOutputStream plantillaDocx) {
		ByteArrayOutputStream plantillaDocxOut = null;
		try {
			plantillaDocxOut = calculaCaratula.calculaCaratula(tablaAmtzIn, plantillaDocx);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return plantillaDocxOut;
	}
	
	
	/**
	 * Implementación de metodo abstracto de interfaz ObtenTablaPlanMagisterio
	 * 
	 * @author Luis Garcia
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
	public ByteArrayOutputStream obtenTablaPlanMagisterio(SccMxTablaMagisterioDTO tablaAmtzMagisterio, 
			                                               ByteArrayOutputStream plantillaDocx) {
		ByteArrayOutputStream plantillaDocxOut = null;
		try {
			plantillaDocxOut = calculaPlanMagisterio.calculaPlanMagisterio(tablaAmtzMagisterio, plantillaDocx);
		} catch (NumberFormatException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return plantillaDocxOut;
	}

}
