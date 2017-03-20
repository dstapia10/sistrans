package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Categoria 
{

	@JsonProperty(value="NOMBRE")
	private String nombre;




	
	public Categoria(@JsonProperty(value="NOMBRE")String nombre)
	{
		super();
		this.nombre = nombre;
	
	}
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String duration) {
		this.nombre = duration;
	}


}
