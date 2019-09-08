package jp.co.sunarch.fraudjudge.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonResponse implements Serializable{

	@JsonProperty("result_code")
	private int resultCode = -1;

	@JsonProperty("message")
	private String message = null;

	@JsonProperty("proccess")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS+9:00", timezone = "Asia/Tokyo")
	private Date proccess = null;

	@JsonProperty("token")
	private String token = null;

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getProccess() {
		return proccess;
	}

	public void setProccess(Date proccess) {
		this.proccess = proccess;
	}

	public int getResultCode() {
		return resultCode;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
