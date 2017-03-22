package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaReporteFuncion {
	
	@JsonProperty(value="reporteFuncion")
	private List<ReporteFuncion> reporteFuncion;
	

	public ListaReporteFuncion( @JsonProperty(value="reporteFuncion")List<ReporteFuncion> reporteFuncion){
		this.reporteFuncion = reporteFuncion;
	}
		
	public List<ReporteFuncion> getReporteFuncion() {
		return reporteFuncion;
	}
	
	public void setReporteFuncion(List<ReporteFuncion> b) {
		this.reporteFuncion = b;
	}
	
}
