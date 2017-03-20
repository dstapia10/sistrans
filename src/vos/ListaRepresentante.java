
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaRepresentante {
	

	@JsonProperty(value="representantes")
	private List<Representante> representantes;
	

	public ListaRepresentante( @JsonProperty(value="representantes")List<Representante> representantes){
		this.representantes = representantes;
	}


	public List<Representante> getRepresentantes() {
		return representantes;
	}

	public void setRepresentantes(List<Representante> b) {
		this.representantes = b;
	}
	
}
