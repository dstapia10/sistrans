
package vos;

import java.util.ArrayList;
import java.util.List;
import org.codehaus.jackson.annotate.JsonProperty;

	
public class ListaFuncion {
	
	@JsonProperty(value="funciones")
	private List<ParametrosGetFunciones> funciones;
	
	public ListaFuncion( @JsonProperty(value="funciones")ArrayList<ParametrosGetFunciones> funciones2){
		this.funciones = funciones2;
	}
	
	public List<ParametrosGetFunciones> getFunciones() {
		return funciones;
	}
	
	public void setFunciones(List<ParametrosGetFunciones> b) {
		this.funciones = b;
	}
	
}
