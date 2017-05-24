package vos;

import org.codehaus.jackson.annotate.JsonProperty;

public class ExchangeMsg2 
{
	@JsonProperty(value="routingkey")
	private String routingKey;
	
	@JsonProperty(value="sender")
	private String sender;
	
	@JsonProperty(value="payload")
	private String payload;
	
	@JsonProperty(value="status")
	private String status;
	
	@JsonProperty(value="msgId")
	private String msgId;
	
	@JsonProperty(value="idCompa�ia")
	private int idCompa�ia;
	
	
	public ExchangeMsg2(@JsonProperty(value="routingkey") String queue, @JsonProperty(value="sender") String sender, @JsonProperty(value="payload") String payload, 
						@JsonProperty(value="status") String status, @JsonProperty(value="msgId") String msgId, @JsonProperty(value="idCompa�ia") int idCompa�ia) 
	{
		this.routingKey = queue;
		this.sender = sender;
		this.payload = payload;
		this.status = status;
		this.msgId = msgId;
		this.idCompa�ia = idCompa�ia;
		
	}
	

	public String getPayload() {
		return payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	public String getRoutingKey() {
		return routingKey;
	}

	public void setRoutingKey(String queue) {
		this.routingKey = queue;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getSender() {
		return sender;
	}


	public void setSender(String sender) {
		this.sender = sender;
	}


	public String getMsgId() {
		return msgId;
	}


	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}
	
	public int getIdCompa�ia() {
		return idCompa�ia;
	}


	public void setIdCompa�ia(int usuario) {
		this.idCompa�ia = usuario;
	}


}
