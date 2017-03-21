package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Usuario 
{

	@JsonProperty(value="CEDULA")
	private int cedula;


	@JsonProperty(value="NOMBRE")
	private String nombre;


	@JsonProperty(value="APELLIDO")
	private String apellido;

	@JsonProperty(value="EDAD")
	private int edad;
	
	@JsonProperty(value="ROL")
	private String rol;
		
	public Usuario(@JsonProperty(value="CEDULA")int cedula,@JsonProperty(value="NOMBRE")String nombre,
			@JsonProperty(value="APELLIDO")String apellido,@JsonProperty(value="EDAD") int edad,
			@JsonProperty(value="ROL") String rol) 
	{
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.rol = rol;	
	}
	

	public int getCedula() {
		return cedula;
	}


	public void setCedula(int duration) {
		this.cedula = duration;
	}


	public String getNombre() {
		return nombre;
	}

	
	public void setNombre(String id) {
		this.nombre = id;
	}

	
	public String getApellido() {
		return apellido;
	}

	
	public void setApellido(String name) {
		this.apellido = name;
	}

	public int getEdad() {
		return edad;
	}

	
	public void setEdad(int name) {
		this.edad = name;
	}
		
}
