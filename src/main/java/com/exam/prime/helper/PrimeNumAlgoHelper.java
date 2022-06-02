package com.exam.prime.helper;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.exam.prime.controller.PrimeNumController;
import static java.lang.Math.sqrt;
import static java.lang.Math.floor;

@Component
public class PrimeNumAlgoHelper {	
	 
	private Logger logger = LoggerFactory.getLogger(PrimeNumController.class);
	List<Integer> primeNums = new ArrayList<>();
	
	public boolean isNumValidForPrimeNumGeneration(int inputNum) {
		
		if (inputNum ==1 || inputNum <=0) {
			return false;
		}		
		return true;
	}
	
	//Naive Algorithm(NA)
	public List<Integer> genPrimeNumsNaiveAlgo(int inputNum){
		
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
	
	
	//Improvised Naive Algorithm(INA)
	public List<Integer> genPrimeNumImprovisedNaiveAlgo(int inputNum){
		
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
	
	
	//Simple Sieve Algorithm(SSA)
	public synchronized List<Integer>  genPrimeNumSimpleSieveAlgo (int inputNum){
		
		boolean[] isPrime = new boolean[inputNum];
		isPrime[0]= false;
		for (int m=1 ; m<inputNum ; m++) {
			isPrime[m]= true;
		}		
		for (int i = 2 ; i<=inputNum ; i ++) {
			if (isPrime[i-1]) {				
				primeNums.add(i);
				for (int j= i*i ; j <=inputNum; j +=i) {
					isPrime[j-1] = false;
				}				
			}
		}		
		return primeNums;
	}
	
	//Segmented Sieve Algorithm(SGSA)
	public List<Integer> genPrimeNumUsingSegSieveAlgo (int inputNum){
		
		int limit = (int) (floor(sqrt(inputNum))+1);		 
		genPrimeNumSimpleSieveAlgo(limit);
		int low = limit;
		int high = 2* limit;
		while (low< inputNum) {
			if(high>=inputNum) {
				high = inputNum ;
			}
			boolean isPrime[] = new boolean[limit+1];
			for (int i = 0; i < isPrime.length; i++) {
				isPrime[i] = true;
			}
			
			for (int i = 0; i < primeNums.size(); i++) {
				int loLim = (int) (floor(low/primeNums.get(i)) * primeNums.get(i));
                if (loLim < low)
                    loLim += primeNums.get(i);
                
                for (int j=loLim; j<high; j+=primeNums.get(i)) {
                	isPrime[j-low] = false;
                }
			}
                for (int i = low; i<high; i++) {
                	 if (isPrime[i - low] == true)
                		 primeNums.add(i);
                }
                low  = low + limit;
                high = high + limit;                     
		}
		return primeNums;
	}
}
