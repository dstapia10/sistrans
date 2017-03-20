
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;


public class ListaCategoria {
	
	/**
	 * List con los videos
	 */
	@JsonProperty(value="categoria")
	private List<Categoria> categorias;
	

	public ListaCategoria( @JsonProperty(value="categorias")List<Categoria> categorias){
		this.categorias = categorias;
	}


	public List<Categoria> getCategoria() {
		return categorias;
	}

	public void setCategoria(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
}
