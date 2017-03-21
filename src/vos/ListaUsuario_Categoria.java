
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaUsuario_Categoria {
	

	@JsonProperty(value="clientes_categoria")
	private List<Usuario_Categoria> clientesCategoria;
	

	public ListaUsuario_Categoria( @JsonProperty(value="clientes_categoria")List<Usuario_Categoria> clientesCategoria){
		this.clientesCategoria = clientesCategoria;
	}


	public List<Usuario_Categoria> getClientesCategorias() {
		return clientesCategoria;
	}

	public void setClientesCategorias(List<Usuario_Categoria> b) {
		this.clientesCategoria = b;
	}
	
}
