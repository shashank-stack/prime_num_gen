package com.exam.prime.bean;

 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

 

@Component
public class PrimeNumResp implements Serializable  {
	
	private List<Integer> generatedPrimeNums = new ArrayList<Integer>() ;

	public List<Integer> getGeneratedPrimeNums() {
		return generatedPrimeNums;
	}

	public void setGeneratedPrimeNums(List<Integer> generatedPrimeNums) {
		this.generatedPrimeNums = generatedPrimeNums;
	}
 
	 

}
