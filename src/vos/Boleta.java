package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Boleta 
{

	@JsonProperty(value="ID")
	private int id;

	@JsonProperty(value="LETRAFILA")
	private String letrafila;

	@JsonProperty(value="NUMEROSILLA")
	private int numeroSilla;

	@JsonProperty(value="PRECIO")
	private int precio;

	@JsonProperty(value="IDFUNCION")
	private int idfuncion;
	
	@JsonProperty(value="ID_USUARIO")
	private int idUsuario;
	
	public Boleta(@JsonProperty(value="ID")int id,@JsonProperty(value="LETRAFILA")String letrafila,
			@JsonProperty(value="NUMEROSILLA")int numerosilla,
			@JsonProperty(value="PRECIO") int precio, 
			@JsonProperty(value="IDFUNCION") int idfuncion,
			@JsonProperty(value="ID_USUARIO") int idUsuario) 
	{
		super();
		this.id = id;
		this.letrafila = letrafila;
		this.numeroSilla = numerosilla;
		
		this.precio = precio;
		this.idfuncion = idfuncion;
	}
	

	public int getId() {
		return id;
	}


	public void setId(int duration) {
		this.id = duration;
	}


	public String getLetraFila() {
		return letrafila;
	}

	
	public void setLetraFila(String id) {
		this.letrafila = id;
	}

	
	public int getNumeroSilla() {
		return numeroSilla;
	}

	
	public void setNumeroSilla(int name) {
		this.numeroSilla = name;
	}

	
	
	public int getPrecio() {
		return precio;
	}

	
	public void setPrecio(int name) {
		this.precio = name;
	}
	
	public int getIdFuncion() {
		return id;
	}

	
	public void setIdfuncion(int name) {
		this.idfuncion = name;
	}
	
	public int getIdUsuario() {
		return id;
	}

	
	public void setIdUsuario(int name) {
		this.idUsuario = name;
	}
}
