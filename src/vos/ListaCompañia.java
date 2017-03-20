
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaCompa�ia {
	

	@JsonProperty(value="compa�ias")
	private List<Compa�ia> companias;
	

	public ListaCompa�ia( @JsonProperty(value="compa�ias")List<Compa�ia> compa�ias){
		this.companias = compa�ias;
	}


	public List<Compa�ia> getCompa�ias() {
		return companias;
	}

	public void setCompa�ias(List<Compa�ia> b) {
		this.companias = b;
	}
	
}
