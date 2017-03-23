package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class TeatroGet 
{

	@JsonProperty(value="IDTEATRO")
	private int idTeatro;


	@JsonProperty(value="CIUDAD")
	private String ciudad;


	@JsonProperty(value="CAPACIDAD")
	private int capacidad;

	@JsonProperty(value="TEATRO")
	private String teatro;

	@JsonProperty(value="DIRECCION")
	private String direccion;

	@JsonProperty(value="OBRA")
	private String obra;
	
	@JsonProperty(value="TRADUCCION")
	private String traduccion;
	
	@JsonProperty(value="LETRAFILA")
	private String letrafila;
	
	@JsonProperty(value="NUMEROSILLA")
	private int numeroSilla;
	
	@JsonProperty(value="PRECIO")
	private int precio;

	
	public TeatroGet(@JsonProperty(value="IDTEATRO")int idTeatro,@JsonProperty(value="CIUDAD")String idCiudad,
			@JsonProperty(value="CAPACIDAD")int capacidad, @JsonProperty(value="TEATRO") String teatro,
			@JsonProperty(value="DIRECCION") String direccion, @JsonProperty(value="OBRA") String obra, 
			@JsonProperty(value="TRADUCCION") String traduccion, @JsonProperty(value="LETRAFILA") String letra,
			@JsonProperty(value="NUMEROSILLA") int numeroSilla, @JsonProperty(value="PRECIO") int precio)
	{
		super();
		this.idTeatro = idTeatro;
		this.ciudad = idCiudad;
		this.capacidad = capacidad;
		this.teatro = teatro;
		this.direccion = direccion;
		this.obra = obra;
		this.traduccion = traduccion;
		this.letrafila = letra;
		this.numeroSilla = numeroSilla;
		this.precio = precio;
	}
	

	public int getIdTeatro() {
		return idTeatro;
	}


	public void setIdTeatro(int duration) {
		this.idTeatro = duration;
	}

	public String getCiudad() {
		return ciudad;
	}


	public void setCiudad(String duration) {
		this.ciudad = duration;
	}

	public int getCapacidad() {
		return capacidad;
	}
	
	
	public void setCapacidad(int name) {
		this.capacidad = name;
	}
	
	public String getTeatro() {
		return teatro;
	}

	
	public void setTeatro(String id) {
		this.teatro = id;
	}

	public String getDireccion() {
		return direccion;
	}
	
	
	public void setDireccion(String name) {
		this.direccion = name;
	}
	
	public String getObra() {
		return obra;
	}

	
	public void setIdCiudad(String name) {
		this.obra = name;
	}
	
	public String getTraduccion() {
		return traduccion;
	}


	public void setTraduccion(String duration) {
		this.traduccion = duration;
	}
	
	public String getLetra() {
		return letrafila;
	}


	public void setLetra(String duration) {
		this.letrafila = duration;
	}
	
	public int getNumeroSilla() {
		return numeroSilla;
	}


	public void setNumeroSilla(int duration) {
		this.numeroSilla = duration;
	}
	
	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int duration) {
		this.precio = duration;
	}

	
	
	
	
}
