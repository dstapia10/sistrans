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

	@JsonProperty(value="IDCLIENTE")
	private int idcliente;

	@JsonProperty(value="PRECIO")
	private int precio;

	@JsonProperty(value="IDFUNCION")
	private int idfuncion;

	
	public Boleta(@JsonProperty(value="ID")int id,@JsonProperty(value="LETRAFILA")String letrafila,
			@JsonProperty(value="NUMEROSILLA")int numerosilla,@JsonProperty(value="IDCLIENTE") int idcliente,
			@JsonProperty(value="PRECIO") int precio, @JsonProperty(value="IDFUNCION") int idfuncion) 
	{
		super();
		this.id = id;
		this.letrafila = letrafila;
		this.numeroSilla = numerosilla;
		this.idcliente = idcliente;
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

	public int getIdCliente() {
		return idcliente;
	}

	
	public void setIdCliente(int name) {
		this.idcliente = name;
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
	
}
