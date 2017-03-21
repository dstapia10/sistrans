
package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.*;


public class Funcion {

	//// Atributos

	@JsonProperty(value="ID")
	private int id;

	@JsonProperty(value="FECHAINICIO")
	private java.sql.Date fechaInicio;

	@JsonProperty(value="IDTEATRO")
	private int idTeatro;

	@JsonProperty(value="IDOBRA")
	private int idObra;
	
	@JsonProperty(value="TRADUCCION")
	private String traduccion;


	
	public Funcion(@JsonProperty(value="ID")int id,@JsonProperty(value="FECHAINICIO")java.sql.Date fechaInicio, 
			@JsonProperty(value="IDTEATRO")int idTeatro,@JsonProperty(value="IDOBRA") int idObra, @JsonProperty(value="TRADUCCION") String traduccion) 
	{
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.idTeatro = idTeatro;
		this.idObra = idObra;
		this.traduccion = traduccion;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int duration) {
		this.id = duration;
	}


	public java.sql.Date getFechaInicio() {
		return fechaInicio;
	}

	
	public void setFechaInicio(java.sql.Date id) {
		this.fechaInicio = id;
	}

	
	public int getIdTeatro() {
		return idTeatro;
	}

	
	public void setIdTeatro(int name) {
		this.idTeatro = name;
	}

	public int getIdObra() {
		return idObra;
	}

	
	public void setIdObra(int name) {
		this.idObra = name;
	}
	
	public String getTraduccion ()
	{
		return traduccion;
	}
	

	public void setTraduccion (String trad)
	{
		this.traduccion = trad;
	}

}
