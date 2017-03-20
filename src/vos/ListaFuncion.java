
package vos;

import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaFuncion {
	

	@JsonProperty(value="funciones")
	private List<Funcion> funciones;
	

	public ListaFuncion( @JsonProperty(value="funciones")List<Funcion> funciones){
		this.funciones = funciones;
	}


	public List<Funcion> getFunciones() {
		return funciones;
	}

	public void setFunciones(List<Funcion> b) {
		this.funciones = b;
	}
	
}
