package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Festival 
{

	@JsonProperty(value="ID")
	private int id;


	@JsonProperty(value="ID_CIUDAD")
	private int idCiudad;


	@JsonProperty(value="FECHAINICIO")
	private Date fechaInicio;

	@JsonProperty(value="FECHAFINAL")
	private Date fechaFinal;
	

	
	public Festival(@JsonProperty(value="ID")int id,@JsonProperty(value="ID_CIUDAD")int idCiudad,
			@JsonProperty(value="FECHAINICIO") Date fechaInicio,
			@JsonProperty(value="FECHAFINAL") Date fechaFinal) 
	{
		super();
		this.id = id;
		this.idCiudad = idCiudad;
		this.fechaFinal = fechaFinal;
		this.fechaInicio = fechaInicio;
		
	}
	

	public int getId() {
		return id;
	}


	public void setId(int duration) {
		this.id = duration;
	}


	public int getIdCiudad() {
		return idCiudad;
	}

	
	public void setIdCiudad(int id) {
		this.idCiudad = id;
	}

	
	
	
	
	public Date getFechaInicio() {
		return fechaInicio;
	}

	
	public void setFechaInicio(Date name) {
		this.fechaInicio = name;
	}
	
	public Date getFechaFinal() {
		return fechaFinal;
	}

	
	public void setFechaFinal(Date name) {
		this.fechaFinal = name;
	}
	
	
}
