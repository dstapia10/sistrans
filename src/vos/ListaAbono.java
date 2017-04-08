package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaAbono {
	
	/**
	 * List con los abonos
	 */
	@JsonProperty(value="abonos")
	private List<Abono> abonos;
	

	public ListaAbono( @JsonProperty(value="abono")List<Abono> abonos){
		this.abonos = abonos;
	}


	public List<Abono> getAbonos() {
		return abonos;
	}

	public void setAabonos(List<Abono> abonos) {
		this.abonos = abonos;
	}
	
}
