package com.exam.prime.helper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.exam.prime.controller.PrimeNumController;

@Component
public class PrimeNumAlgoHelper {
		 
	
	//Algorithm A 
	private Logger logger = LoggerFactory.getLogger(PrimeNumController.class);
	List<Integer> primeNums = new ArrayList<>();
	
	public boolean isNumValidForPrimeNumGeneration(int inputNum) {
		
		if (inputNum ==1 || inputNum <=0) {
			return false;
		}
		
		return true;
	}
	
	public List<Integer> generatePrimeNumbersUsingAlgoA(int inputNum){
		
		for (int i = 2 ; i <=inputNum ; i++) {
			if (isInputNumPrimeAlgoA(i)) {
				primeNums.add(i);
			}			
		}		
		return primeNums;
	}
	
	public boolean isInputNumPrimeAlgoA(int num) {
		
		for (int j =2 ; j <num ; j++) {
			if (num  % j ==0 ) {
				return false;
			}
		}
		return true;
	}
	
	
	//Algorithm B 
 	
	public List<Integer> generatePrimeNumbersUsingAlgoB(int inputNum){
		
		if(inputNum >=2) {
			primeNums.add(2);
		}	
		
		for (int i = 3 ; i <=inputNum ; i=i+2) {
			if (isInputNumPrimeAlgoB(i)) {
				primeNums.add(i);
			}			
		}		
		return primeNums;
	}
	
	public boolean isInputNumPrimeAlgoB(int num) {
		
		for (int j =2 ; j*j <num ; j++) {
			if (num  % j ==0 ) {
				return false;
			}
		}
		return true;
	}

	public List<Integer> getPrimeNums() {
		return primeNums;
	}

	public void setPrimeNums(List<Integer> primeNums) {
		this.primeNums = primeNums;
	}
	
}
