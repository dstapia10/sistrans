package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Produccion 
{
	@JsonProperty(value="ID_COMPA�IA")
	private int idCompa�ia;

	@JsonProperty(value="ID_OBRA")
	private int idObra;




	

	
	public Produccion(@JsonProperty(value="ID_OBRA")int idObra,@JsonProperty(value="ID_COMPA�IA")int idCompa�ia)
			
	{
		super();
		this.idObra = idObra;
		this.idCompa�ia = idCompa�ia;
		
	}
	

	public int getIdObra() {
		return idObra;
	}


	public void setIdCliente(int duration) {
		this.idObra = duration;
	}


	public int getIdCompa�ia() {
		return idCompa�ia;
	}

	
	public void setIdCompa�ia(int id) {
		this.idCompa�ia = id;
	}

	
	
}
