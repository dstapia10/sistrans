
package vos;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaFuncion2 {
	
	@JsonProperty(value="funciones")
	private List<Funcion> funciones;
	
	public ListaFuncion2( @JsonProperty(value="funciones")ArrayList<Funcion> funciones2){
		this.funciones = funciones2;
	}
	
	public List<Funcion> getFunciones() {
		return funciones;
	}
	
	public void setFunciones(List<Funcion> b) {
		this.funciones = b;
	}
	
}
