package mx.isban.scc.service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.isban.scc.dao.ISccMxMaeAppCarteraDAO;
import mx.isban.scc.dao.ISccMxMaePampaDAO;
import mx.isban.scc.model.SccMxMaeAppCartera;
import mx.isban.scc.model.SccMxMaePampa;
import mx.isban.scc.model.dto.SccMxBonificacionConsumoDTO;
import mx.isban.scc.model.dto.SccMxMaePampaDTO;
import mx.isban.scc.model.dto.SccMxPrimaLinexDTO;
import mx.isban.scc.utilerias.CalculaPrimaConsumo;
import mx.isban.scc.utilerias.CalculaPrimaLinex;

/**
 * Implementacion de interfaz para calculo
 * de prima devengada
 * @author Christopher Espina Riveros
 *
 * Global Hitss
 * Mayo 2019
 */
@Service
public class CalculoPrimaDevengadaService implements ICalculoPrimaDevengadaService {
	/**
	 *  instancia para la implemantacion de la interfaz ISccMxMaeAppCartera
	 */
	@Autowired 
	private ISccMxMaeAppCarteraDAO daoPrima;
	/**
	 *  instancia para la implemantacion de la interfaz ISccMxMaePampa
	 */
	@Autowired 
	private ISccMxMaePampaDAO daoPrimaLinex;

	/**
	 * Implementacion de metodo de interfaz
	 * para calculo de prima devengada
	 * @author Christopher Espina Riveros
	 * @param idCliente
	 * id de cliente
	 * @param credito
	 * credito a sustituir
	 * @param idProducto
	 * producto
	 * return primaDevengada
	 * prima devengada
	 */
	@Override
	public Double primaDevengada(long idCliente, long credito, long idProducto) {
		
		SccMxMaeAppCartera cartera = null;
		SccMxBonificacionConsumoDTO objetoPrima = new SccMxBonificacionConsumoDTO();
		CalculaPrimaConsumo prima = new CalculaPrimaConsumo();
		
		cartera = daoPrima.obtenDtoCartera(idCliente, credito, idProducto);
		objetoPrima.setFchCancelacion(new Date());
		objetoPrima.setFchFormal(cartera.getFchFormal());
		objetoPrima.setNumDeutaTotal(cartera.getNumMontoSeg());
		objetoPrima.setNumPlazo(cartera.getNumPlazo());
		objetoPrima.setNumPrdoPagos(cartera.getNumPrdoPagos());
		objetoPrima.setNumTasaInt(cartera.getNumTasaInt());
		objetoPrima.setNumMontoSeg(cartera.getNumMontoSeg());
		
		return prima.calculaPrimaC(objetoPrima);
	}

	/**
	 * Metodo para obtener prima devengada linex
	 * @param credito
	 * credito a sustituir, numero de contrato
	 * @param suc
	 * para conocer la sucursal de origen
	 * @return primaDevengada
	 * primaDevengada
	 */
	@Override
	public SccMxMaePampaDTO primaDevengadaLinex(long credito, long suc) {
		DecimalFormat df = new DecimalFormat("#.00");
		Double sumaPrimaDevengada = 0.0;
		List<SccMxMaePampa> pampaLista = null;
		SccMxPrimaLinexDTO objetoPrima = new SccMxPrimaLinexDTO();
		SccMxMaePampaDTO datosPampa = new SccMxMaePampaDTO();
		CalculaPrimaLinex prima = new CalculaPrimaLinex();
		pampaLista = daoPrimaLinex.obtenPampa(credito, suc);
		
		if(!pampaLista.isEmpty()) {
			for(SccMxMaePampa pampa : pampaLista) {
				objetoPrima = new SccMxPrimaLinexDTO();
				objetoPrima.setPc(pampa.getImpPrimaSeg());
				objetoPrima.setFechaI(pampa.getFchIniDispn());
				objetoPrima.setFechaF(pampa.getFchFinDispn());
				objetoPrima.setFechaC(new Date());

				if ((pampa.getImpPrimaSeg() > 0) && !(pampa.getFchFinDispn().before(objetoPrima.getFechaC()))) {
					sumaPrimaDevengada += prima.calculaPrimaLinex(objetoPrima);
				}
			}
			datosPampa.setNumTDC(pampaLista.get(0).getNumTdc());
			datosPampa.setSaldoCredito(pampaLista.get(0).getImpSaldoLinex());
			datosPampa.setPrimaDevengada(new Double (df.format(sumaPrimaDevengada)));
		}
		return datosPampa ;
				
	}
	


}
