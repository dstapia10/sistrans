package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Obra 
{

	@JsonProperty(value="ID")
	private int id;


	@JsonProperty(value="NOMBRE")
	private String nombre;


	@JsonProperty(value="REQUERIMIENTOS")
	private String requerimientos;

	@JsonProperty(value="IDIOMA")
	private String idioma;

	@JsonProperty(value="DESCRIPCION")
	private String descripcion;

	@JsonProperty(value="COSTO")
	private int costo;

	
	public Obra(@JsonProperty(value="ID")int id,@JsonProperty(value="NOMBRE")String nombre,
			@JsonProperty(value="REQUERIMIENTOS")String requerimientos,@JsonProperty(value="IDIOMA") String idioma,
			@JsonProperty(value="DESCRIPCION") String descripcion, @JsonProperty(value="COSTO") int costo) 
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.requerimientos = requerimientos;
		this.idioma = idioma;
		this.descripcion = descripcion;
		this.costo = costo;
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

	
	public String getRequerimientos() {
		return requerimientos;
	}

	
	public void setRequerimientos(String name) {
		this.requerimientos = name;
	}

	public String getIdioma() {
		return idioma;
	}

	
	public void setIdioma(String name) {
		this.idioma = name;
	}
	
	
	public String getDescripcion() {
		return descripcion;
	}

	
	public void setDescripcion(String name) {
		this.descripcion = name;
	}
	
	public int getCosto() {
		return costo;
	}

	
	public void setCosto(int name) {
		this.costo = name;
	}
	
}
