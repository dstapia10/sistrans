
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaProduccion {
	

	@JsonProperty(value="producciones")
	private List<Produccion> producciones;
	

	public ListaProduccion( @JsonProperty(value="producciones")List<Produccion> producciones){
		this.producciones = producciones;
	}


	public List<Produccion> getProducciones() {
		return producciones;
	}

	public void setProducciones(List<Produccion> b) {
		this.producciones = b;
	}
	
}
