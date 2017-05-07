package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaConsultaBoletasFuncion {
	
	@JsonProperty(value="consultaBoletasFuncion")
	private List<ConsultaBoletasFuncion> consultaBoletasFuncion;
	

	public ListaConsultaBoletasFuncion( @JsonProperty(value="consultaBoletasFuncion")List<ConsultaBoletasFuncion> consultaBoletasFuncion){
		this.consultaBoletasFuncion = consultaBoletasFuncion;
	}
	
	public List<ConsultaBoletasFuncion> getConsultaBoletasFuncion() {
		return consultaBoletasFuncion;
	}

	public void setConsultaBoletasFuncion(List<ConsultaBoletasFuncion> consultaBoletasFuncion) {
		this.consultaBoletasFuncion = consultaBoletasFuncion;
	}
	
}
