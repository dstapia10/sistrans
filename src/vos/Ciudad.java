package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Ciudad {
	
	/**
	 * Id de la ciudad
	 */
	@JsonProperty(value="id")
	private int id;

	/**
	 * Nombre de la ciudad
	 */
	@JsonProperty(value="name")
	private String name;

	public Ciudad(@JsonProperty(value="id")int id, @JsonProperty(value="name")String name) {
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
