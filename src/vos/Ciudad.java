package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Ciudad 
{

	@JsonProperty(value="ID")
	private int id;


	@JsonProperty(value="NOMBRE")
	private String nombre;


	

	
	public Ciudad(@JsonProperty(value="ID")int id,@JsonProperty(value="LETRAFILA")String nombre)
			
	{
		super();
		this.id = id;
		this.nombre = nombre;
		
	}
	

	public int getId() {
		return id;
	}


	public void setId(int duration) {
		this.id = duration;
	}


	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String id) {
		this.nombre = id;
	}

	
	
}
