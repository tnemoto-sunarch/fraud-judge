package jp.co.sunarch.fraudjudge.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonRequest implements Serializable{

	@JsonProperty("user_id")
	private String userId = null;

	@JsonProperty("request_id")
	private String requestId = null;

	@JsonProperty("card_info")
	private JsonRequestCardInfo cardInfo = null;

	public JsonRequestCardInfo getCardInfo() {
		return cardInfo;
	}

	public void setCardInfo(JsonRequestCardInfo cardInfo) {
		this.cardInfo = cardInfo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
}
