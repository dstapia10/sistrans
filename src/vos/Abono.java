package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Abono {
	
	@JsonProperty(value="IDABONO")
	private int idAbono;


	@JsonProperty(value="IDCLIENTE")
	private int idCliente;
	
	@JsonProperty(value="IDBOLETAS")
	private String idBoletas;

	
	public Abono(@JsonProperty(value="IDABONO")int idAbono,
			@JsonProperty(value="IDCLIENTE")int idCliente,
			@JsonProperty(value="IDBOLETAS")String idBoletas)
			
	{
		super();
		this.idAbono = idAbono;
		this.idCliente = idCliente;	
		this.idBoletas = idBoletas;	
	}
	

	public int getIdAbono() {
		return idAbono;
	}
	
	public void setIdAbono(int id) {
		this.idAbono = id;
	}
	
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int duration) {
		this.idCliente = duration;
	}
	
	public String getIdBoletas() {
		return idBoletas;
	}
	
	public void setIdBoletas(String nBoletas) {
		this.idBoletas = nBoletas;
	}
	
}
