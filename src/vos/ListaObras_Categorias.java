
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaObras_Categorias {
	

	@JsonProperty(value="obras_categorias")
	private List<Obra_Categoria> obrasCategorias;
	

	public ListaObras_Categorias( @JsonProperty(value="obras_categorias")List<Obra_Categoria> obrasCategorias){
		this.obrasCategorias = obrasCategorias;
	}


	public List<Obra_Categoria> getObrasCategorias() {
		return obrasCategorias;
	}

	public void setObrasCategorias(List<Obra_Categoria> b) {
		this.obrasCategorias = b;
	}
	
}
