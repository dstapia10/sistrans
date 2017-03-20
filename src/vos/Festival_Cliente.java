package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Festival_Cliente 
{

	@JsonProperty(value="ID_CLIENTE")
	private int idCliente;


	@JsonProperty(value="ID_FESTIVAL")
	private int idFestival;


	

	
	public Festival_Cliente(@JsonProperty(value="ID_CLIENTE")int idCliente,@JsonProperty(value="ID_FESTIVAL")int idFestival)
			
	{
		super();
		this.idCliente = idCliente;
		this.idFestival = idFestival;
		
	}
	

	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int duration) {
		this.idCliente = duration;
	}


	public int getIdFestival() {
		return idFestival;
	}

	
	public void setIdFestival(int id) {
		this.idFestival = id;
	}

	
	
}
