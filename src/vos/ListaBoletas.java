
package vos;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaBoletas {
	
	/**
	 * List con los videos
	 */
	@JsonProperty(value="boletas")
	private List<BoletaGet> boletas;
	

	public ListaBoletas( @JsonProperty(value="boletas")ArrayList<BoletaGet> boleta){
		this.boletas = boleta;
	}


	public List<BoletaGet> getBoleta() {
		return boletas;
	}

	public void setBoletas(List<BoletaGet> b) {
		this.boletas = b;
	}
	
}
