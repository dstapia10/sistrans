package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaConsultarAsistenciaCliente {
	
	@JsonProperty(value="consultarAsistenciaCliente")
	private List<ConsultarAsistenciaCliente> consultarAsistenciaCliente;
	
	public ListaConsultarAsistenciaCliente( @JsonProperty(value="consultarAsistenciaCliente")List<ConsultarAsistenciaCliente> consultarAsistenciaCliente){
		this.consultarAsistenciaCliente = consultarAsistenciaCliente;
	}
	
	public List<ConsultarAsistenciaCliente> getConsultarAsistenciaCliente() {
		return consultarAsistenciaCliente;
	}
	
	public void setConsultarAsistenciaCliente(List<ConsultarAsistenciaCliente> b) {
		this.consultarAsistenciaCliente = b;
	}

}
