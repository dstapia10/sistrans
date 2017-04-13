package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaBoletasVendidas {
	
	/**
	 * List con los videos
	 */
	@JsonProperty(value="boletasVendidas")
	private BoletasVendidas []  boletasVendidas ;
	

	public ListaBoletasVendidas ( @JsonProperty(value="boletasVendidas ")BoletasVendidas[] boletasVendidas ){
		this.boletasVendidas  = boletasVendidas ;
	}


	public BoletasVendidas[] getBoletasVendidas () {
		return boletasVendidas ;
	}

	public void setBoletasVendidas (BoletasVendidas[] b) {
		this.boletasVendidas  = b;
	}
	
}
