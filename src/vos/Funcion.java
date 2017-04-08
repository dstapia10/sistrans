
package vos;

import java.sql.Date;

import org.codehaus.jackson.annotate.*;


public class Funcion {

	//// Atributos

	@JsonProperty(value="ID")
	private int id;

	@JsonProperty(value="FECHAINICIO")
	private Date fechaInicio;

	@JsonProperty(value="IDTEATRO")
	private int idTeatro;

	@JsonProperty(value="IDOBRA")
	private int idObra;
	
	@JsonProperty(value="TRADUCCION")
	private String traduccion;
	
	@JsonProperty(value="ESTADO")
	private String estado;



	
	public Funcion(@JsonProperty(value="ID")int id,
			@JsonProperty(value="FECHAINICIO")Date fechaInicio,
			@JsonProperty(value="IDTEATRO")int idTeatro,
			@JsonProperty(value="IDOBRA") int idObra,
			@JsonProperty(value="ESTADO") String estado) 
	{
		super();
		this.id = id;
		this.fechaInicio = fechaInicio;
		this.idTeatro = idTeatro;
		this.idObra = idObra;
		this.traduccion = traduccion;
		this.estado = estado;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int duration) {
		this.id = duration;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}

	
	public void setFechaInicio(Date id) {
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

	public String getTraduccion() {
		return traduccion;
	}

	
	public void setTraduccion(String name) {
		this.traduccion = name;
	}


	public String getEstado() {
		// TODO Auto-generated method stub
		return estado;
	}
	
	
	public void setEstado(String name) {
		this.estado = name;
	}

}
