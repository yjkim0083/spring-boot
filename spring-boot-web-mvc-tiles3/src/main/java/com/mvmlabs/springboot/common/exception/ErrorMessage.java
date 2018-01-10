package com.mvmlabs.springboot.common.exception;

public class ErrorMessage {

	public ErrorMessage(String request) {
		request = request.replace("ServletWebRequest:", "").trim();
		String[] values = request.split("\\;");
		
		for(String value : values) {
			
			if(value.startsWith("uri")) {
				this.uri = value.split("\\=")[1];
			} else if(value.startsWith("client")) {
				this.client = value.split("\\=")[1];
			} else if(value.startsWith("session")) {
				this.sessionId = value.split("\\=")[1];
			} else if(value.startsWith("user")) {
				this.user = value.split("\\=")[1];
			} else {
				this.etc = value;
			}
		}
	}
	
	private String status;
	private String message;
	private String uri;
	private String client;
	private String sessionId;
	private String user;
	private String etc;
	
	public String getStatus() {
		return status;
	}
	public String getUri() {
		return uri;
	}
	
	public String getClient() {
		return client;
	}
	
	public String getSessionId() {
		return sessionId;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getEtc() {
		return etc;
	}
	@Override
	public String toString() {
		return "123ErrorMessage [status=" + status + ", message=" + message + ", uri=" + uri + ", client=" + client
				+ ", sessionId=" + sessionId + ", user=" + user + ", etc=" + etc + "]";
	}
}
