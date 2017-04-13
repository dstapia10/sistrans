package vos;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;

public class ConsultaCompañia {
	
	@JsonProperty(value="IDCOMPAÑIA")
	private int idCompañia;

	@JsonProperty(value="IDFUNCION")
	private int idFuncion;

	@JsonProperty(value="GANANCIAPOSIBLE")
	private int gananciaPosible;

	@JsonProperty(value="GANANCIAREAL")
	private int gananciaReal;

	@JsonProperty(value="TOTALBOLETAS")
	private int totalBoletas;
	
	@JsonProperty(value="TOTALBOLETASVENDIDAS")
	private int totalBoletasVendidas;
	
	public ConsultaCompañia(@JsonProperty(value="IDCOMPAÑIA")int idCompañia,
			@JsonProperty(value="IDFUNCION")int idFuncion,
			@JsonProperty(value="GANANCIAPOSIBLE")int gananciaPosible,
			@JsonProperty(value="GANANCIAREAL") int gananciaReal, 
			@JsonProperty(value="TOTALBOLETAS") int totalBoletas,
			@JsonProperty(value="TOTALBOLETASVENDIDAS") int totalBoletasVendidas) 
	{
		super();
		this.idCompañia = idCompañia;
		this.idFuncion = idFuncion;
		this.gananciaPosible = gananciaPosible;		
		this.gananciaReal = gananciaReal;
		this.totalBoletas = totalBoletas;
		this.totalBoletasVendidas = totalBoletasVendidas;
	}
	

	public int getIdCompañia() {
		return idCompañia;
	}
	
	public void setIdCompañia(int duration) {
		this.idCompañia = duration;
	}
	
	
	public int getIdFuncion() {
		return idFuncion;
	}
	
	public void setIdFuncion(int id) {
		this.idFuncion = id;
	}

	
	public int getGananciaPosiblea() {
		return gananciaPosible;
	}
		
	public void setGananciaPosible(int name) {
		this.gananciaPosible = name;
	}
	
		
	public int getGananciaReal() {
		return gananciaReal;
	}
		
	public void setGananciaReal(int name) {
		this.gananciaReal = name;
	}
	
	
	public int getTotalBoletas() {
		return totalBoletas;
	}
	
	public void setTotalBoletas(int name) {
		this.totalBoletas = name;
	}
	
	
	public int getTotalBoletasVendidas() {
		return totalBoletasVendidas;
	}
	
	public void setTotalBoletasVendidas(int name) {
		this.totalBoletasVendidas = name;
	}
	
}
