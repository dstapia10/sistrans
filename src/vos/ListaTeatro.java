
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaTeatro {
	

	@JsonProperty(value="teatros")
	private List<Teatro> teatros;
	

	public ListaTeatro( @JsonProperty(value="teatro")List<Teatro> teatros){
		this.teatros = teatros;
	}


	public List<Teatro> getTeatros() {
		return teatros;
	}

	public void setTeatros(List<Teatro> b) {
		this.teatros = b;
	}
	
}
