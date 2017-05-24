/**-------------------------------------------------------------------
 * $Id$
 * Universidad de los Andes (Bogotá - Colombia)
 * Departamento de Ingeniería de Sistemas y Computación
 *
 * Materia: Sistemas Transaccionales
 * Ejercicio: FestivAndes
 * -------------------------------------------------------------------
 */
package vos;

import org.codehaus.jackson.annotate.*;

/**
 * Clase que representa una Boleta
 */
public class BoletaFestival 
{

	// Atributos
	/**
	 * Id de la boleta
	 */
	@JsonProperty(value="app")
	private int app;

	/**
	 * Id de la boleta
	 */
	@JsonProperty(value="idBoleta")
	private int idBoleta;

	/**
	 * Identificador del abono del usuario
	 */	
	@JsonProperty(value="abono")
	private int abono;

	/**
	 * Id de la localidad
	 */		
	@JsonProperty(value="idLocalidad")
	private int idLocalidad;

	/**
	 * Id de la funci�n
	 */
	@JsonProperty(value="idFuncion")
	private int idFuncion;

	/**
	 * M�todo constructor de la clase Boleta
	 */
	public BoletaFestival(@JsonProperty(value="app")int app,@JsonProperty(value="idBoleta")int idBoleta, @JsonProperty(value="abono") int abono, 
			@JsonProperty(value="idLocalidad") int idLocalidad,@JsonProperty(value="idFuncion")int idFuncion) 
	{
		super();
		this.app = app;	
		this.idBoleta = idBoleta;		
		this.abono = abono;
		this.idLocalidad = idLocalidad;
		this.idFuncion = idFuncion;
	}
	
	public BoletaFestival()
	{
		super();
	}	
	
	//Getters y Setters

	public int getIdBoleta() {
		return idBoleta;
	}

	public void setIdBoleta(int idBoleta) {
		this.idBoleta = idBoleta;
	}

	public int getAbono() {
		return abono;
	}

	public void setAbono(int abono) {
		this.abono = abono;
	}

	public int getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(int idLocalidad) {
		this.idLocalidad = idLocalidad;
	}

	public int getIdFuncion() {
		return idFuncion;
	}

	public void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}	
	
	public int getApp() {
		return app;
	}

	public void setApp(int app) {
		this.app = app;
	}	
}