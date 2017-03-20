
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;


public class ListaActores {
	
	/**
	 * List con los videos
	 */
	@JsonProperty(value="actores")
	private List<Actor> actores;
	

	public ListaActores( @JsonProperty(value="actores")List<Actor> actores){
		this.actores = actores;
	}


	public List<Actor> getActores() {
		return actores;
	}

	public void setActores(List<Actor> actores) {
		this.actores = actores;
	}
	
}
