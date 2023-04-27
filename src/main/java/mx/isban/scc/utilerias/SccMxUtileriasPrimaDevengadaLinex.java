package mx.isban.scc.utilerias;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

/**
 * 
 * Funciones de apoyo (Utilerías) para la generación de las tablas de prima
 * devengada linex y el calculo de la misma
 * 
 * Simulador de Credito al Consumo Global Hitss 
 * Mayo 2019
 * @author Christopher Espina
 * Sprint
 * 
 */
public class SccMxUtileriasPrimaDevengadaLinex {
	/**
	 * Constante de clase , con un solo espacio de memoria e inmutable con la
	 * finalidar de log
	 */
	private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SccMxUtileriasPrimaDevengada.class);

	/**
	 * Metodo para obtener anios de vigencia de seguro
	 * Regresa un entero (años de vigencia) 
	 * o null en caso de error
	 * 
	 * @param anioI entrada de anio inicio
	 * @param anioF entrada anio fin
	 * @return vigencia anios de vigencia
	 * @exception NullPointerException NumberFormatException
	 */
	public Integer obtenVigenciaLinex(String anioI, String anioF) {

		Integer vigencia = null;

		try {

			Integer anioInicio = Integer.parseInt(anioI);
			Integer anioFin = Integer.parseInt(anioF);
			//La vigencia es (fin - inicio) (en años) 
			vigencia = anioFin - anioInicio;

		} catch (NumberFormatException e) {
			//Registra el error en el log 
			LOGGER.error(e.getMessage(), e);
			vigencia = null;
		}
		return vigencia;
	}

	/**
	 * Metodo para obtener anio de cancelacion
	 * Regresa un entero (año de cancelacion) 
	 * o null en caso de error
	 *
	 * @param anioI entrada de anio inicio
	 * @param anioC anio de cancelacion
	 * @return vigencia anios de vigencia
	 * @exception NullPointerException NumberFormatException
	 */
	public Integer obtenAnioCancelacionLinex(String anioI, String anioC) {

		Integer vAux = null;

		try {

			Integer anioInicio = Integer.parseInt(anioI);
			Integer anioCancel = Integer.parseInt(anioC);

			//La vigencia es (fin - inicio) (en años) 
			vAux = anioCancel - anioInicio;

		} catch (NumberFormatException e) {
			//Registra el error en el log 
			LOGGER.error(e.getMessage(), e);
			vAux = null;
		}
		return vAux;
	}

	/**
	 * Metodo para obtener mes de cancelacion
	 * Regresa un entero (mes de cancelacion) 
	 * o null en caso de error
	 * 
	 * @param mesI entrada de mes inicio
	 * @param mesC mes cancelacion
	 * @return vigencia anios de vigencia
	 * @exception NullPointerException NumberFormatException
	 */
	public Integer obtenMesCancelacionLinex(String mesI, String mesC) {

		Integer mes = null;
		Integer mesInicio = null;
		Integer mesCancel = null;
		Integer inicio = 0;

		try {

			if (Integer.parseInt(mesI) + 1 > 12) {
				mesInicio = 1;
			} else {
				mesInicio = Integer.parseInt(mesI) + 1;
			}
			mesCancel = Integer.parseInt(mesC);

			List<Integer> periodos = new ArrayList<>();
			periodos.add(0, mesInicio);
			
			//Se añaden los meses restantes hasta fin de año
			for (int i = 1; i < 12; i++) {
				if (mesInicio + i <= 12) {
					periodos.add(i, mesInicio + i);
				}
			}
			
			//Se añaden los periodos restantes hasta fin de año
			for (int i = periodos.size(); i < 12; i++) {
				inicio = inicio + 1;
				periodos.add(i, inicio);
			}

			for (int i = 0; i < 12; i++) {
				if (mesCancel.equals(periodos.get(i))) {
					mes = i + 1;
				}
			}
		} catch (NumberFormatException e) {
			//Registra el error en el log 
			LOGGER.error(e.getMessage(), e);
			mes = null;
		}
		return mes;
	}

	/**
	 * Metodo para obtener factores de cancelacion
	 * Regresa un entero (factor de cancelacion) 
	 * o null en caso de error
	 * 
	 * @param mesCancelacion entrada de mes de cancelacion
	 * @return factor factor se meses restantes
	 * @exception NullPointerException NumberFormatException
	 */
	public Double obtenFactor(Integer mesCancelacion) {

		if (mesCancelacion > 12) {
			mesCancelacion = mesCancelacion - 12;
		}
		Double factor = 0.00;
		
		//El factor disminuye conforme avanza el mes de cancelación 
		try {
			switch (mesCancelacion) {
			case 1:
				factor = CalculoPrimaDef.UNO;
				break;
			case 2:
				factor = CalculoPrimaDef.DOS;
				break;
			case 3:
				factor = CalculoPrimaDef.TRES;
				break;
			case 4:
				factor = CalculoPrimaDef.CUATRO;
				break;
			case 5:
				factor = CalculoPrimaDef.CINCO;
				break;
			case 6:
				factor = CalculoPrimaDef.SEIS;
				break;
			case 7:
				factor = CalculoPrimaDef.SIETE;
				break;
			case 8:
				factor = CalculoPrimaDef.OCHO;
				break;
			case 9:
				factor = CalculoPrimaDef.NUEVE;
				break;
			case 10:
				factor = CalculoPrimaDef.DIEZ;
				break;
			case 11:
				factor = CalculoPrimaDef.ONCE;
				break;
			case 12:
				factor = CalculoPrimaDef.DOCE;
				break;
			default:
				break;
			}

		} catch (NumberFormatException e) {
			//Registra el error en el log 
			LOGGER.error(e.getMessage(), e);
			factor = null;
		}
		return factor;
	}

	/**
	 * Metodo para obtener meses por devengar
	 * Regresa un Double (prima por devengar) 
	 * o null en caso de error
	 * 
	 * @param vigencia        entrada de vigencia de seguro
	 * @param anioCancelacion entrada anioCancelacion de seguro
	 * @param primaNeta       primaNeta de seguro
	 * @param factor          factor devengacion
	 * @return vigencia anios de vigencia
	 * @exception NullPointerException NumberFormatException
	 */
	public Double obtenMesesPorDevengarLinex(Integer vigencia, Integer anioCancelacion, Double primaNeta,
			Double factor) {

		Double prima = null;
		//Construye los arreglos para la vigencia:
		//1, 2, 3, 4, 5
		List<Double> uno = new ArrayList<>();
		List<Double> dos = new ArrayList<>();
		List<Double> tres = new ArrayList<>();
		List<Double> cuatro = new ArrayList<>();
		List<Double> cinco = new ArrayList<>();

		//Arreglo para vigencia = 1
		uno.add(0, 1.00);
		//Arreglo para vigencia = 2
		dos.add(0, 0.75);
		dos.add(1, 0.25);
		//Arreglo para vigencia = 3
		tres.add(0, 0.54);
		tres.add(1, 0.34);
		tres.add(2, 0.12);
		//Arreglo para vigencia = 4
		cuatro.add(0, 0.41);
		cuatro.add(1, 0.30);
		cuatro.add(2, 0.21);
		cuatro.add(3, 0.08);
		//Arreglo para vigencia = 5
		cinco.add(0, 0.32);
		cinco.add(1, 0.26);
		cinco.add(2, 0.2);
		cinco.add(3, 0.15);
		cinco.add(4, 0.5);

		try {

			switch (vigencia) {
			case 1:
				prima = primaDevengadaLinex(uno, primaNeta, factor, anioCancelacion);
				break;

			case 2:
				prima = primaDevengadaLinex(dos, primaNeta, factor, anioCancelacion);
				break;

			case 3:
				prima = primaDevengadaLinex(tres, primaNeta, factor, anioCancelacion);
				break;

			case 4:
				prima = primaDevengadaLinex(cuatro, primaNeta, factor, anioCancelacion);
				break;

			case 5:
				prima = primaDevengadaLinex(cinco, primaNeta, factor, anioCancelacion);
				break;

			default:
				break;
			}

		} catch (NumberFormatException e) {
			//Registra el error en el log 
			LOGGER.error(e.getMessage(), e);
			prima = null;
		}
		return prima;
	}

	/**
	 * Metodo que obtiene la lista de primas devengadas
	 * Regresa un Double (prima devengada) 
	 * o null en caso de error
	 * 
	 * @param anios           anios a devengar
	 * @param primaNeta       porima neta
	 * @param factor          factor de prima
	 * @param anioCancelacion anio de cancelacion
	 * @return prima prima
	 */
	public Double primaDevengadaLinex(List<Double> anios, Double primaNeta, Double factor, Integer anioCancelacion) {

		Double prima = null;
		List<Double> primas = new ArrayList<>();

		try {
			//Añade la prima neta cada año
			for (int i = 0; i < anios.size(); i++) {
				primas.add(i, anios.get(i) * primaNeta);
			}
			
			//Calcula la prima hasta el año anterior al de cancelación
			prima = primas.get(anioCancelacion - 1) * factor;
			
			//Para las restantes, las deja igual
			for (int i = anioCancelacion; i < primas.size(); i++) {
				prima = prima + (primas.get(i) * 1);
			}
		} catch (NumberFormatException e) {
			//Registra el error en el log 
			LOGGER.error(e.getMessage(), e);
			prima = null;
		}
		return prima;
	}
}