
package vos;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaTeatro {
	

	@JsonProperty(value="teatros")
	private List<TeatroGet> teatros;
	

	public ListaTeatro( @JsonProperty(value="teatro")ArrayList<TeatroGet> teatros2){
		this.teatros = teatros2;
	}


	public List<TeatroGet> getTeatros() {
		return teatros;
	}

	public void setTeatros(List<TeatroGet> b) {
		this.teatros = b;
	}
	
}
