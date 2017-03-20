
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaFestivales_Clientes {
	

	@JsonProperty(value="festivales_clientes")
	private List<Festival_Cliente> festivalClientes;
	

	public ListaFestivales_Clientes( @JsonProperty(value="festivales_clientes")List<Festival_Cliente> festivalClientes){
		this.festivalClientes = festivalClientes;
	}


	public List<Festival_Cliente> getFestivalesClientes() {
		return festivalClientes;
	}

	public void setFestivalClientes(List<Festival_Cliente> b) {
		this.festivalClientes = b;
	}
	
}
