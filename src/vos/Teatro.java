package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Teatro {
	
	/**
	 * Id del teatro
	 */
	@JsonProperty(value="id")
	private int id;

	/**
	 * Nombre del teatro
	 */
	@JsonProperty(value="name")
	private String name;
	
	/**
	 * Capacidad del teatro
	 */
	@JsonProperty(value="capacidad")
	private int capacidad;
	
	
	public Teatro(@JsonProperty(value="id")int id, @JsonProperty(value="name")String name, @JsonProperty(value="capacidad")int capacidad) {
		super();
		this.id = id;
		this.name = name;
		this.capacidad = capacidad;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

}
