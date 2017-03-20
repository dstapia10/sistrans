
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;


public class ListaCiudad {
	
	
	@JsonProperty(value="ciudades")
	private List<Ciudad> ciudades;
	

	public ListaCiudad( @JsonProperty(value="ciudades")List<Ciudad> ciudades){
		this.ciudades = ciudades;
	}


	public List<Ciudad> getCiudad() {
		return ciudades;
	}

	public void setCiudad(List<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}
	
}
