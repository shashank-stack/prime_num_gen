package com.exam.prime.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
//import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Component;

@Component
@RedisHash("PrimeNumReq")
public class PrimeNumReq implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1028137706573309428L;
	@Id
	private int inputNum;
	private String algorithm;

	public PrimeNumReq() {

	}

	public PrimeNumReq(int inputNum, String algorithm) {
		this.inputNum = inputNum;
		this.algorithm = algorithm;
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

}
