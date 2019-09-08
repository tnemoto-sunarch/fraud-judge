package jp.co.sunarch.fraudjudge.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonRequestCardInfo implements Serializable{

	@JsonProperty("card_no")
	private String cardNo = null;

	@JsonProperty("exp_date")
	private String expDate = null;

	@JsonProperty("sec_code")
	private String secCode = null;

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getSecCode() {
		return secCode;
	}

	public void setSecCode(String secCode) {
		this.secCode = secCode;
	}
}
