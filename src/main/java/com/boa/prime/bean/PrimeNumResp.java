package com.boa.prime.bean;

 
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

 

@Component
public class PrimeNumResp   {
	
	private List<Integer> generatedPrimeNums = new ArrayList<Integer>() ;

	public List<Integer> getGeneratedPrimeNums() {
		return generatedPrimeNums;
	}

	public void setGeneratedPrimeNums(List<Integer> generatedPrimeNums) {
		this.generatedPrimeNums = generatedPrimeNums;
	}
 
	 

}
