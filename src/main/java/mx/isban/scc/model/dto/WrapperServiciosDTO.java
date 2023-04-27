package mx.isban.scc.model.dto;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Wrapper para los servicios de DTO de productos, periodicidades y condiciones
 * financieras para mostrar en la pantalla.
 * 
 * Se encapsulan para no hacer multiples viajes al servidor
 * 
 * @author GlobalHitss
 * 
 *
 */

public class WrapperServiciosDTO implements Serializable {

	/**
	 * Serial version id de la clase
	 */
	private static final long serialVersionUID = 6761150943194638209L;

	/**
	 * Lista de subproductos
	 */
	private List<SccMxMaeProductoSubProductDTO> subProds = null;
	/**
	 * Lista de periodicidades
	 */
	private List<SccMxPeriodoPorIdProdDTO> periodicidades = null;
	/**
	 * lista de condiciones financieras
	 */
	private List<SccMxMaeCondFinanDTO> datosCondFin = null;
	/**
	 * lista de condiciones financieras linex
	 */
	private List<SccMxMaeCondFinanLinexDTO> datosCondFinLinex = null;
	/**
	 * DTO Conversion Auto Linex
	 */
	private SccMxConvAutoLinexDTO convAutoLinex = null;

	/**
	 * Regresa las condiciones financieras
	 * 
	 * @return List(SccMxMaeCondFinanDTO) Lista de condiciones financieras
	 */
	public List<SccMxMaeCondFinanDTO> getDatosCondFin() {
		if (datosCondFin == null) {
			return new ArrayList<>();
		}
		return new ArrayList<>(datosCondFin);
	}
	
	/**
	 * Regresa las condiciones financieras
	 * 
	 * @return List(SccMxMaeCondFinanLinexDTO) Lista de condiciones financieras LINEX
	 */
	public List<SccMxMaeCondFinanLinexDTO> getDatosCondFinLinex() {
		if (datosCondFinLinex == null) {
			return new ArrayList<>();
		}
		return new ArrayList<>(datosCondFinLinex);
	}


	/**
	 * Serializa los oabjetos de esta clase
	 * @param stream java.io.ObjectOutputStream
	 * @throws IOException en caso de error de lectura o escritura
	 */
	private void writeObject(java.io.ObjectOutputStream stream) throws IOException {

		stream.writeObject(new ArrayList<>(subProds));
		stream.writeObject(new ArrayList<>(periodicidades));
		stream.writeObject( new ArrayList<>(datosCondFin));
	}

	/**
	 * Desserializa los objetos de ésta clase
	 * @param stream java.io.ObjectInputStream
	 * @throws IOException en caso de error de lectura o escritura
	 * @throws ClassNotFoundException si no se encuentra el objeto 
	 */
	@SuppressWarnings("unchecked")
	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
		subProds = (List<SccMxMaeProductoSubProductDTO>) stream.readObject();
		periodicidades = (List<SccMxPeriodoPorIdProdDTO>) stream.readObject();
		datosCondFin = (List<SccMxMaeCondFinanDTO>) stream.readObject();
	}

	/**
	 * Almacena las condiciones financieras
	 * 
	 * @param datosCondFin List(SccMxMaeCondFinanDTO) Datos de condiciones financieras
	 */
	public void setDatosCondFin(List<SccMxMaeCondFinanDTO> datosCondFin) {
		if (datosCondFin == null) {
			this.datosCondFin = new ArrayList<>();
		}
		this.datosCondFin = new ArrayList<>(datosCondFin);
	}
	
	/**
	 * Almacena las condiciones financieras
	 * 
	 * @param datosCondFin List(SccMxMaeCondFinanLinexDTO) Datos de condiciones financieras LINEX
	 */
	public void setDatosCondFinLinex(List<SccMxMaeCondFinanLinexDTO> datosCondFin) {
		if (datosCondFin == null) {
			this.datosCondFinLinex = new ArrayList<>();
		}
		this.datosCondFinLinex = new ArrayList<>(datosCondFin);
	}

	/**
	 * Regresa los subproductos
	 * 
	 * @return List(SccMxMaeProductoSubProductDTO) Lista de subproductos
	 */
	public List<SccMxMaeProductoSubProductDTO> getSubProds() {
		if (subProds == null) {
			return new ArrayList<>();
		}
		return new ArrayList<>(subProds);
	}

	/**
	 * Almacena los subproductos
	 * 
	 * @param subProds List(SccMxMaeProductoSubProductDTO) Lista de subproductos
	 */
	public void setSubProds(List<SccMxMaeProductoSubProductDTO> subProds) {
		if (subProds == null) {
			this.subProds = new ArrayList<>();
		}
		this.subProds = new ArrayList<>(subProds);
	}

	/**
	 * Regresa las periodicidades
	 * 
	 * @return periodicidades List(SccMxPeriodoPorIdProdDTO) Lista de periodicidades
	 */
	public List<SccMxPeriodoPorIdProdDTO> getPeriodicidades() {
		if (periodicidades == null) {
			return new ArrayList<>();
		}
		return new ArrayList<>(periodicidades);
	}

	/**
	 * Almacena las periodicidades
	 * 
	 * @param periodicidades List(SccMxPeriodoPorIdProdDTO) Lista de periodicidades
	 */
	public void setPeriodicidades(List<SccMxPeriodoPorIdProdDTO> periodicidades) {
		if (periodicidades == null) {
			this.periodicidades = new ArrayList<>();
		}
		this.periodicidades = new ArrayList<>(periodicidades);
	}

	/**
	 * Obtiene el DTO de convAutoLinex
	 * @return convAutoLinex SccMxConvAutoLinexDTO
	 */
	public SccMxConvAutoLinexDTO getConvAutoLinex() {
		return convAutoLinex;
	}

	/**
	 * Coloca El dto de datos de Conversion Auto
	 * @param convAutoLinex SccMxConvAutoLinexDTO
	 */
	public void setConvAutoLinex(SccMxConvAutoLinexDTO convAutoLinex) {
		this.convAutoLinex = convAutoLinex;
	}
	
}
