package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaConsultaCompaņia {
	
	@JsonProperty(value="consultaCompaņia")
	private List<ConsultaCompaņia> consultaCompaņia;
	

	public ListaConsultaCompaņia( @JsonProperty(value="consultaCompaņia")List<ConsultaCompaņia> consultaCompaņia){
		this.consultaCompaņia = consultaCompaņia;
	}
	
	public List<ConsultaCompaņia> getConsultaCompaņia() {
		return consultaCompaņia;
	}

	public void setConsultaCompaņia(List<ConsultaCompaņia> consultaCompaņia) {
		this.consultaCompaņia = consultaCompaņia;
	}
	
}
