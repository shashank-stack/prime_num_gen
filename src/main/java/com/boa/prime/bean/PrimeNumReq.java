package com.boa.prime.bean;

import org.springframework.stereotype.Component;

@Component
public class PrimeNumReq {
	

	private int inputNum;
	private String algorithm;
	private String contentType;
	
	public PrimeNumReq() {
	 
	 
	}
	
	public PrimeNumReq(int inputNum, String algorithm, String contentType) {
		this.inputNum = inputNum;
		this.algorithm = algorithm;
		this.contentType = contentType;
	}
	public int getInputNum() {
		return inputNum;
	}
	public void setInputNum(int inputNum) {
		this.inputNum = inputNum;
	}
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
  

}
