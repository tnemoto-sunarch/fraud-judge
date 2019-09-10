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

	@JsonProperty("fj_token")
	private String fjToken = null;

	@JsonProperty("fj_level")
	private int fjLevel = -1;

	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}

	public String getFjToken() {
		return fjToken;
	}

	public void setFjToken(String fjToken) {
		this.fjToken = fjToken;
	}

	public int getFjLevel() {
		return fjLevel;
	}

	public void setFjLevel(int fjLevel) {
		this.fjLevel = fjLevel;
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
}
