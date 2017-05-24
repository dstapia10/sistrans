package vos;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class ListaBoletasFestival {

	/**
	 * List con las BoletasFestivales
	 */
	@JsonProperty(value="boletasFestivales")
	private List<BoletaFestival> boletasFestivales;
	
	/**
	 * Constructor de la clase ListaBoletasFestivales
	 * @param BoletasFestivales - BoletasFestivales para agregar al arreglo de la clase
	 */
	public ListaBoletasFestival( @JsonProperty(value="boletasFestivales")List<BoletaFestival> BoletasFestivales){
		this.boletasFestivales = BoletasFestivales;
	}

	/**
	 * Método que retorna la lista de BoletasFestivales
	 * @return  List - List con las BoletasFestivales
	 */
	public List<BoletaFestival> getBoletasFestivales() {
		return boletasFestivales;
	}

	/**
	 * Método que asigna la lista de BoletasFestivales que entra como parametro
	 * @param  BoletasFestivales - List con las BoletasFestivales a agregar
	 */
	public void setVideo(List<BoletaFestival> BoletasFestivales) {
		this.boletasFestivales = BoletasFestivales;
	}
}
