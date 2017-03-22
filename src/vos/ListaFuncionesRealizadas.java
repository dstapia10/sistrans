package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaFuncionesRealizadas {
	
	@JsonProperty(value="funcionesRealizadas")
	private List<FuncionRealizada> funcionesRealizadas;
	
	public ListaFuncionesRealizadas( @JsonProperty(value="funciones")List<FuncionRealizada> funcionesRealizadas){
		this.funcionesRealizadas = funcionesRealizadas;
	}
	
	public List<FuncionRealizada> getFunciones() {
		return funcionesRealizadas;
	}
	
	public void setFunciones(List<FuncionRealizada> b) {
		this.funcionesRealizadas = b;
	}
	
}
