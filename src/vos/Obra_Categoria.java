package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Obra_Categoria 
{

	@JsonProperty(value="ID_OBRA")
	private int idObra;


	@JsonProperty(value="ID_CATEGORIA")
	private String idCategoria;


	

	
	public Obra_Categoria(@JsonProperty(value="ID_OBRA")int idObra,@JsonProperty(value="ID_CATEGORIA")String idCategoria)
			
	{
		super();
		this.idObra = idObra;
		this.idCategoria = idCategoria;
		
	}
	

	public int getIdObra() {
		return idObra;
	}


	public void setIdCliente(int duration) {
		this.idObra = duration;
	}


	public String getIdCategoria() {
		return idCategoria;
	}

	
	public void setIdCategoria(String id) {
		this.idCategoria = id;
	}

	
	
}
