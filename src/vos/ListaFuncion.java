
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaFuncion {
	

	@JsonProperty(value="festivales")
	private List<Festival> festivales;
	

	public ListaFuncion( @JsonProperty(value="compañias")List<Festival> festivales){
		this.festivales = festivales;
	}


	public List<Festival> getFestivales() {
		return festivales;
	}

	public void setFestivales(List<Festival> b) {
		this.festivales = b;
	}
	
}
