package com.exam.prime;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

import java.util.ArrayList;
import java.util.List;

public class Test {
	
	List<Integer> primeNums = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test test = new Test ();
		
		List<Integer>  list = test.genPrimeNumUsingSegSieveAlgo(1000); 
		
		for (int i = 0 ; i <list.size() ; i ++) {
			System.out.println(list.get(i));
		}
		
	}
	
	//SimpleSieveAlgo
			public List<Integer> genPrimeNumUsingSimpleSieveAlgo (int inputNum){
				
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
			
			public List<Integer> genPrimeNumUsingSegSieveAlgo (int inputNum){
				
				int limit = (int) (floor(sqrt(inputNum))+1);		 
				genPrimeNumUsingSimpleSieveAlgo(limit);
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
