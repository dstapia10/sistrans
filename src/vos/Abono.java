package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class Abono {
	
	@JsonProperty(value="IDABONO")
	private int idAbono;


	@JsonProperty(value="IDCLIENTE")
	private int idCliente;

	
	public Abono(@JsonProperty(value="IDABONO")int idAbono,@JsonProperty(value="IDCLIENTE")int idCliente)
			
	{
		super();
		this.idAbono = idAbono;
		this.idCliente = idCliente;		
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
	
}
