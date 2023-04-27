package mx.isban.scc.model.dto;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase para representar los datos que corrresponden a los atributos de la
 * entidad de carga de archivos que en la base de datos
 * corresponde a la tabla de Notificaciones
 * extiende de clase Parent porque excede la cantidad de campos
 * permitida en las reglas
 * Sprint 3 Junio 2019
 * 
 * @author Hitss
 *
 */
public class SccMxCargaArchivoDTO extends SccMxCargaArchivoParentDTO implements Serializable {

	/**
	 * serializacion de la clase dto SccMxCargaArchivoDTO
	 */
	private static final long serialVersionUID = 828688325092604L;
	/**
	 * String para la carga de los datos
	 */
	private List<String[]> datos;
	/**
	 * Nombre del archivo cargado
	 */
	private String nombreArch;
	/**
	 * estado de carga del archivo cargado
	 */
	private String estadoCarga;
	/**
	 * tipo de carga del archivo cargado
	 */
	private Integer tipoCarga;
	/**
	 * codigo de carga del archivo cargado
	 */
	private String codigoCarga;
	/**
	 * fecha de carga del archivo cargado
	 */
	private Date fechaCarga;

	/**
	 * Serializa los oabjetos de esta clase Junio 2019 Sprint 3
	 * 
	 * @param stream el stream a escribir
	 * 
	 * @throws IOException en caso de error de lectura o escritura
	 */
	private void writeObject(java.io.ObjectOutputStream stream) throws IOException {

		stream.writeObject(new ArrayList<>(datos));
		stream.writeObject(nombreArch);
		stream.writeObject(estadoCarga);
		stream.writeObject(tipoCarga);
		stream.writeObject(codigoCarga);
		stream.writeObject(fechaCarga);
		stream.writeObject(numeroReg);
		stream.writeObject(numeroRegOk);
		stream.writeObject(numeroRegNok);
		stream.writeObject(new ArrayList<>(this.getErrores()));
		stream.writeObject(new ArrayList<>(this.getLtInsert()));
	}

	/**
	 * Desserializa los objetos de ésta clase Junio 2019 Sprint 3
	 * 
	 * @param stream el setream de donde leer
	 * @throws IOException            en caso de error de lectura o escritura
	 * @throws ClassNotFoundException si no se encuentra el objeto
	 */
	@SuppressWarnings("unchecked")
	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
		datos = (List<String[]>) stream.readObject();
		nombreArch = (String) stream.readObject();
		estadoCarga = (String) stream.readObject();
		tipoCarga = (Integer) stream.readObject();
		codigoCarga = (String) stream.readObject();
		fechaCarga = (Date) stream.readObject();
		numeroReg = (Integer) stream.readObject();
		numeroRegOk = (Integer) stream.readObject();
		numeroRegNok = (Integer) stream.readObject();
		this.setErrores((List<String>) stream.readObject());
		this.setLtInsert((List<Serializable>) stream.readObject());
	}

	/**
	 * Devuelve el arreglo de datos tipo cadena
	 * 
	 * @return ArrayList(datos)
	 */
	public List<String[]> getDatos() {
		return new ArrayList<>(datos);
	}

	/**
	 * inicializa el arreglo de datos tipo cadena
	 * 
	 * @param datos ArrayList of String
	 */
	public void setDatos(List<String[]> datos) {
		this.datos = new ArrayList<>(datos);
	}

	/**
	 * Devuelve el nombre del archivo
	 * 
	 * @return nombreArch nombre del archivo
	 */
	public String getNombreArch() {
		return nombreArch;
	}

	/**
	 * Inicializa el nombre del archivo
	 * 
	 * @param nombreArch nombre del archivo
	 */
	public void setNombreArch(String nombreArch) {
		this.nombreArch = nombreArch;
	}

	/**
	 * Devuelve el estado de carga
	 * 
	 * @return estadoCarga estado de carga
	 */
	public String getEstadoCarga() {
		return estadoCarga;
	}

	/**
	 * Inicializa el estado de carga
	 * 
	 * @param estadoCarga estado de carga
	 */
	public void setEstadoCarga(String estadoCarga) {
		this.estadoCarga = estadoCarga;
	}

	/**
	 * Devuelve el tipo carga
	 * 
	 * @return tipoCarga tipo de carga
	 */
	public Integer getTipoCarga() {
		return tipoCarga;
	}

	/**
	 * Inicializa el tipo carga
	 * 
	 * @param tipoCarga tipo de carga
	 */
	public void setTipoCarga(Integer tipoCarga) {
		this.tipoCarga = tipoCarga;
	}

	/**
	 * Devuelve el codigo de carga
	 * 
	 * @return codigoCarga codigo de carga
	 */
	public String getCodigoCarga() {
		return codigoCarga;
	}

	/**
	 * Inicializa el codigo de carga
	 * 
	 * @param codigoCarga codigo de carga
	 */
	public void setCodigoCarga(String codigoCarga) {
		this.codigoCarga = codigoCarga;
	}

	/**
	 * Devuelve la fecha de carga del archivo
	 * 
	 * @return new Date(fechaCarga.getTime()) fecha de carga del archivo
	 */
	public Date getFechaCarga() {
		return new Date(fechaCarga.getTime());
	}

	/**
	 * Inicializa la fecha de carga del archivo
	 * 
	 * @param fechaCarga fecha de carga del archivo. Se toma: new
	 *                   Date(fechaCarga.getTime())
	 */
	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = new Date(fechaCarga.getTime());
	}

}
