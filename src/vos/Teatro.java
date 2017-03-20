package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class Teatro 
{

	@JsonProperty(value="ID")
	private int id;


	@JsonProperty(value="IDCIUDAD")
	private int idCiudad;


	@JsonProperty(value="CAPACIDAD")
	private int capacidad;

	@JsonProperty(value="NOMBRE")
	private String nombre;

	@JsonProperty(value="DIRECCION")
	private String direccion;


	
	public Teatro(@JsonProperty(value="ID")int id,@JsonProperty(value="IDCIUDAD")int idCiudad,
			@JsonProperty(value="CAPACIDAD")int capacidad,@JsonProperty(value="NOMBRE") String nombre,
			@JsonProperty(value="DIRECCION") String direccion)
	{
		super();
		this.id = id;
		this.idCiudad = idCiudad;
		this.capacidad = capacidad;
		this.nombre = nombre;
		this.direccion = direccion;
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

	
	public int getIdCiudad() {
		return idCiudad;
	}

	
	public void setIdCiudad(int name) {
		this.idCiudad = name;
	}

	public int getCapacidad() {
		return capacidad;
	}

	
	public void setCapacidad(int name) {
		this.capacidad = name;
	}
	
	
	public String getDireccion() {
		return direccion;
	}

	
	public void setDireccion(String name) {
		this.direccion = name;
	}
	
	
}
