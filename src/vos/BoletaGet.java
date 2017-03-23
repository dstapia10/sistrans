package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class BoletaGet 
{

	@JsonProperty(value="IDFUNCION")
	private int id;


	@JsonProperty(value="GANANCIA")
	private int ganancia;


	
	
	public BoletaGet(@JsonProperty(value="IDFUNCION")int id,@JsonProperty(value="GANANCIA")int letrafila) 
	{
		super();
		this.id = id;
		this.ganancia = letrafila;
		
	}
	

	public int getId() {
		return id;
	}


	public void setId(int duration) {
		this.id = duration;
	}


	public int getGanancia() {
		return ganancia;
	}

	
	public void setLetraFila(int id) {
		this.ganancia = id;
	}

	
	
}
