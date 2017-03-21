package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Usuario_Categoria 
{

	@JsonProperty(value="ID_USUARIO")
	private int idUsuario;


	@JsonProperty(value="ID_CATEGORIA")
	private String idCategoria;


	

	
	public Usuario_Categoria(@JsonProperty(value="ID_USUARIO")int idUsuario,@JsonProperty(value="ID_CATEGORIA")String idCategoria)
			
	{
		super();
		this.idUsuario = idUsuario;
		this.idCategoria = idCategoria;
		
	}
	

	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int duration) {
		this.idUsuario = duration;
	}


	public String getIdCategoria() {
		return idCategoria;
	}

	
	public void setIdCategoria(String id) {
		this.idCategoria = id;
	}

	
	
}
