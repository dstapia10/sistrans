
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaUsuario {
	

	@JsonProperty(value="clientes")
	private List<Usuario> clientes;
	

	public ListaUsuario( @JsonProperty(value="clientes")List<Usuario> clientes){
		this.clientes = clientes;
	}


	public List<Usuario> getClientes() {
		return clientes;
	}

	public void setBoletas(List<Usuario> b) {
		this.clientes = b;
	}
	
}
