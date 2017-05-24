package vos;

import java.util.ArrayList;

import org.codehaus.jackson.annotate.JsonProperty;

public class Abonos {

	@JsonProperty(value="tipo_localidad")
	
	 private ArrayList<String> tipo_localidad;
	 
	@JsonProperty(value="num_loc")
	 private ArrayList<String> num_loc;
	
	@JsonProperty(value="fila")
	 private ArrayList<Integer> fila;
	
	@JsonProperty(value="silla")
	 private ArrayList<Integer> silla;
	
	@JsonProperty(value="num_boleta")
	 private ArrayList<Integer> num_boleta;

	
	public Abonos (@JsonProperty(value="tipo_localidad") ArrayList<String> tipo_localidad, @JsonProperty(value="num_loc") ArrayList<String> num_loc,@JsonProperty(value="fila")ArrayList<Integer> fila, @JsonProperty(value="silla")ArrayList<Integer> silla,@JsonProperty(value="num_boleta")ArrayList<Integer> num_boleta) throws Exception{
		
		if (fila.size()!= silla.size()) throw new Exception("Infomacion de filas y sillas incompleta");
		if (tipo_localidad.size()!= num_loc.size()) throw new Exception("Infomacion de filas y sillas incompleta");
		
		this.num_loc = num_loc;
		this.tipo_localidad = tipo_localidad;
		this.fila = fila;
		this.silla = silla;
		this.num_boleta= num_boleta;
	}

	public ArrayList<String> getTipo_localidad(){ return tipo_localidad;}
	public ArrayList<String> getNum_loc(){ return num_loc;}
	public ArrayList<Integer> getFilas(){ return fila;}
	public ArrayList<Integer> getSillas(){ return silla;}
	public ArrayList<Integer> getNum_boleta(){ return num_boleta;}
}
