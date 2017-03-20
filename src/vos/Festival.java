package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Festival {
	
	/**
	 * Id del festival
	 */
	@JsonProperty(value="id")
	private int id;

	/**
	 * Nombre del festival
	 */
	@JsonProperty(value="name")
	private String name;
	
	/**
	 * Fecha de inicio del festival
	 */
	@JsonProperty(value="fechaInicio")
	private Date fechaInicio;
	
	/**
	 * Fecha de inicio del festival
	 */
	@JsonProperty(value="fechaFin")
	private Date fechaFin;
	
	
	public Festival(@JsonProperty(value="id")int id, @JsonProperty(value="name")String name, @JsonProperty(value="fechaInicio")Date fechaInicio,
			@JsonProperty(value="fechaFin")Date fechaFin) {
		super();
		this.id = id;
		this.name = name;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	
	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

}
