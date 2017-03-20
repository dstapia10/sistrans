
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaObra {
	

	@JsonProperty(value="obras")
	private List<Obra> obras;
	

	public ListaObra( @JsonProperty(value="obras")List<Obra> obras){
		this.obras = obras;
	}


	public List<Obra> getObras() {
		return obras;
	}

	public void setObras(List<Obra> b) {
		this.obras = b;
	}
	
}
