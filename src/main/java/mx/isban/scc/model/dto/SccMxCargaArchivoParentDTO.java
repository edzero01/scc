package mx.isban.scc.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para representar los datos que corrreponden a los atributos de la
 * entidad de carga de archivos 
 * que en la base de datos corresponde a notificaciones. 
 * Esta es la clase Parent que junto con la hija se comnplementan
 * ya que excedia el numero de campos permitidos
 * en las reglas de sonar
 * 
 * Sprint 3 Junio 2019
 * 
 * @author Hitss
 *
 */
public class SccMxCargaArchivoParentDTO implements Serializable {

	/**
	 * serializacion de la clase dto SccMxCargaArchivoDTO
	 */

	private static final long serialVersionUID = -5461179364437321802L;
	/**
	 * numero de carga del archivo cargado
	 */
	protected Integer numeroReg;
	/**
	 * numero de regOk de carga del archivo cargado
	 */
	protected Integer numeroRegOk;
	/**
	 * numero de regNOk de carga del archivo cargado
	 */
	protected Integer numeroRegNok;
	/**
	 * errores de carga del archivo cargado
	 */
	private List<String> errores;
	/**
	 * lista de insersiones de carga del archivo cargado
	 */
	private List<Serializable> ltInsert;

	/**
	 * Devuelve la lista
	 * 
	 * @return ArrayList(ltInsert)
	 */
	public List<Serializable> getLtInsert() {
		return new ArrayList<>(ltInsert);
	}

	/**
	 * inicializa la lista
	 * 
	 * @param ltInsert ArrayList of Objects
	 */
	public void setLtInsert(List<Serializable> ltInsert) {
		this.ltInsert = new ArrayList<Serializable>(ltInsert);
	}

	/**
	 * Devuelve el numero de registros cargados
	 * 
	 * @return numeroReg numero de registros cargados
	 */
	public Integer getNumeroReg() {
		return numeroReg;
	}

	/**
	 * Inicializa el numero de registros cargados
	 * 
	 * @param numeroReg numero de registros cargados
	 */
	public void setNumeroReg(Integer numeroReg) {
		this.numeroReg = numeroReg;
	}

	/**
	 * Devuelve el numero de registros cargados correctamente
	 * 
	 * @return numeroRegOk numero de registros cargados correctamente
	 */
	public Integer getNumeroRegOk() {
		return numeroRegOk;
	}

	/**
	 * Inicializa el numero de registros cargados correctamente
	 * 
	 * @param numeroRegOk numero de registros cargados correctamente
	 */
	public void setNumeroRegOk(Integer numeroRegOk) {
		this.numeroRegOk = numeroRegOk;
	}

	/**
	 * Devuelve el numero de registros que no se cargaron
	 * 
	 * @return numeroRegNok numero de registros que no se cargaron
	 */
	public Integer getNumeroRegNok() {
		return numeroRegNok;
	}

	/**
	 * Inicializa el numero de registros que no se cargaron
	 * 
	 * @param numeroRegNok numero de registros que no se cargaron
	 */
	public void setNumeroRegNok(Integer numeroRegNok) {
		this.numeroRegNok = numeroRegNok;
	}

	/**
	 * Devuelve la lista de errores
	 * 
	 * @return new ArrayList(errores) lista de errores
	 */
	public List<String> getErrores() {
		return new ArrayList<>(errores);
	}

	/**
	 * Inicializa la lista de errores
	 * 
	 * @param errores Lista de errores: new ArrayList(errores)
	 */
	public void setErrores(List<String> errores) {
		this.errores = new ArrayList<>(errores);
	}

}
