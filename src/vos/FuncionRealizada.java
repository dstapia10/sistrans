package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class FuncionRealizada {
	
	@JsonProperty(value="ID_FUNCION")
	private int idFuncion;
	
	public FuncionRealizada(@JsonProperty(value="ID_FUNCION")int idFuncion) 
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
