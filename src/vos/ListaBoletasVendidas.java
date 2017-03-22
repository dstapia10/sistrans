package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaBoletasVendidas {
	
	/**
	 * List con los videos
	 */
	@JsonProperty(value="boletasVendidas")
	private List<BoletasVendidas > boletasVendidas ;
	

	public ListaBoletasVendidas ( @JsonProperty(value="boletasVendidas ")List<BoletasVendidas > boletasVendidas ){
		this.boletasVendidas  = boletasVendidas ;
	}


	public List<BoletasVendidas> getBoletasVendidas () {
		return boletasVendidas ;
	}

	public void setBoletasVendidas (List<BoletasVendidas > b) {
		this.boletasVendidas  = b;
	}
	
}
