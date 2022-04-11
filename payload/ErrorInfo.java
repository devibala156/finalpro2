package com.abc.CabBookingApplication.payload;

public class ErrorInfo {
	public String url;
	public String message;
	public ErrorInfo(String url, String message) {
		super();
		this.url = url;
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
