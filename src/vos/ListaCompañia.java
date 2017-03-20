
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaCompañia {
	

	@JsonProperty(value="compañias")
	private List<Compañia> companias;
	

	public ListaCompañia( @JsonProperty(value="compañias")List<Compañia> compañias){
		this.companias = compañias;
	}


	public List<Compañia> getCompañias() {
		return companias;
	}

	public void setCompañias(List<Compañia> b) {
		this.companias = b;
	}
	
}
