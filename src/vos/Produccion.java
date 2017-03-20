package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Produccion 
{
	@JsonProperty(value="ID_COMPAÑIA")
	private int idCompañia;

	@JsonProperty(value="ID_OBRA")
	private int idObra;




	

	
	public Produccion(@JsonProperty(value="ID_OBRA")int idObra,@JsonProperty(value="ID_COMPAÑIA")int idCompañia)
			
	{
		super();
		this.idObra = idObra;
		this.idCompañia = idCompañia;
		
	}
	

	public int getIdObra() {
		return idObra;
	}


	public void setIdCliente(int duration) {
		this.idObra = duration;
	}


	public int getIdCompañia() {
		return idCompañia;
	}

	
	public void setIdCompañia(int id) {
		this.idCompañia = id;
	}

	
	
}
