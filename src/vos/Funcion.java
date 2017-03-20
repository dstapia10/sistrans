package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Funcion {
	
	/**
	 * Id de la funcion
	 */
	@JsonProperty(value="id")
	private int id;

	/**
	 * Fecha de inicio de la funcion
	 */
	@JsonProperty(value="fechaInicio")
	private Date fechaInicio;

	public Funcion(@JsonProperty(value="id")int id, @JsonProperty(value="fechaInicio")Date fechaInicio) {
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

}
