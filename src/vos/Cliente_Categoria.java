package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Cliente_Categoria 
{

	@JsonProperty(value="ID_CLIENTE")
	private int idCliente;


	@JsonProperty(value="ID_CATEGORIA")
	private String idCategoria;


	

	
	public Cliente_Categoria(@JsonProperty(value="ID_CLIENTE")int idCliente,@JsonProperty(value="ID_CATEGORIA")String idCategoria)
			
	{
		super();
		this.idCliente = idCliente;
		this.idCategoria = idCategoria;
		
	}
	

	public int getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(int duration) {
		this.idCliente = duration;
	}


	public String getIdCategoria() {
		return idCategoria;
	}

	
	public void setIdCategoria(String id) {
		this.idCategoria = id;
	}

	
	
}
