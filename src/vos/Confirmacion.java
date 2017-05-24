package vos;
import org.codehaus.jackson.annotate.JsonProperty;

public class Confirmacion {


	@JsonProperty(value="confirmacion")
	private int confirmacion;

	@JsonProperty(value="estado")
	private String estado;

	public Confirmacion(@JsonProperty(value="confirmacion")int confirmacion, @JsonProperty(value="estado")String estado){
		this.confirmacion = confirmacion;
		this.estado = estado;

	}
	public int getconfirmacion(){ return confirmacion;}
	public void  setconfirmacion(int confirmacion){ this.confirmacion = confirmacion;}
	
	public String getestado(){ return estado;}
	public void  setestado(String estado){ this.estado = estado;}


}
