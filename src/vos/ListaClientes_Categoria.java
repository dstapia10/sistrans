
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaClientes_Categoria {
	

	@JsonProperty(value="clientes_categoria")
	private List<Cliente_Categoria> clientesCategoria;
	

	public ListaClientes_Categoria( @JsonProperty(value="clientes_categoria")List<Cliente_Categoria> clientesCategoria){
		this.clientesCategoria = clientesCategoria;
	}


	public List<Cliente_Categoria> getClientesCategorias() {
		return clientesCategoria;
	}

	public void setClientesCategorias(List<Cliente_Categoria> b) {
		this.clientesCategoria = b;
	}
	
}
