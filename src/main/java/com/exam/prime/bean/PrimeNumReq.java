package com.exam.prime.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Component;

@Component
@RedisHash("PrimeNumReq")
public class PrimeNumReq implements Serializable{
	
	@Id
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
