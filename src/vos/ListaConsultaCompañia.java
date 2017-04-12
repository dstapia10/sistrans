package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaConsultaCompañia {
	
	@JsonProperty(value="consultaCompañia")
	private List<ConsultaCompañia> consultaCompañia;
	

	public ListaConsultaCompañia( @JsonProperty(value="consultaCompañia")List<ConsultaCompañia> consultaCompañia){
		this.consultaCompañia = consultaCompañia;
	}
	
	public List<ConsultaCompañia> getConsultaCompañia() {
		return consultaCompañia;
	}

	public void setConsultaCompañia(List<ConsultaCompañia> consultaCompañia) {
		this.consultaCompañia = consultaCompañia;
	}
	
}
