package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaConsultaCompa�ia {
	
	@JsonProperty(value="consultaCompa�ia")
	private List<ConsultaCompa�ia> consultaCompa�ia;
	

	public ListaConsultaCompa�ia( @JsonProperty(value="consultaCompa�ia")List<ConsultaCompa�ia> consultaCompa�ia){
		this.consultaCompa�ia = consultaCompa�ia;
	}
	
	public List<ConsultaCompa�ia> getConsultaCompa�ia() {
		return consultaCompa�ia;
	}

	public void setConsultaCompa�ia(List<ConsultaCompa�ia> consultaCompa�ia) {
		this.consultaCompa�ia = consultaCompa�ia;
	}
	
}
