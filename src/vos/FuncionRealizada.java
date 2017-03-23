package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class FuncionRealizada {
	
	@JsonProperty(value="IDFUNCION")
	private int idFuncion;
	
	public FuncionRealizada(@JsonProperty(value="IDFUNCION")int idFuncion) 
	{
		super();
		this.idFuncion = idFuncion;
	}
	
	public int getIdFuncion() {
		return idFuncion;
	}
	
	public void setName(int idFuncion) {
		this.idFuncion = idFuncion;
	}
		
}
