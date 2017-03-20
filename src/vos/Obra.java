package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Obra {
	
	/**
	 * Id de la obra
	 */
	@JsonProperty(value="id")
	private int id;

	/**
	 * Nombre de la obra
	 */
	@JsonProperty(value="name")
	private String name;
		
	public Obra(@JsonProperty(value="id")int id, @JsonProperty(value="name")String name) {
		super();
		this.id = id;
		this.name = name;
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
		
}
