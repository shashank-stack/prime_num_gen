package com.exam;

 
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.Test;

import com.exam.prime.common.PrimeNumAlgoExecutor;
 
public class PrimeNumberAlgoTests { 
	
 
	//PrimeNumAlgoExecutor primeNumAlgoExecutor = new PrimeNumAlgoExecutor() ;
 
	private PrimeNumAlgoExecutor primeNumAlgoExecutor = new PrimeNumAlgoExecutor();
	
//	@Test
//	public void contextLoads() {
//		
//	}
	
//	@Test
//	public void genPrimeNumsNaiveAlgoTest() {
//		
//		when(primeNumAlgoExecutor.genPrimeNumsNaiveAlgo(5)).thenReturn((List<Integer>) Stream
//				.of(new Integer(2), new Integer(2),new Integer(5)).collect(Collectors.toList()));
//		
//		assertEquals(3, selectAlgorithmService.selectAlgo("NA", 5).size());
//		 		
//	}
 
	@Test
	public void genPrimeNumsNaiveAlgoTest() {
		
		List<Integer> primeNums = primeNumAlgoExecutor.genPrimeNumsNaiveAlgo(5);
		int actualResult = primeNums.size();
		int expectedResult = 3;
		
		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void genPrimeNumsImprovisedNaiveAlgoTest() {
		
		List<Integer> primeNums = primeNumAlgoExecutor.genPrimeNumImprovisedNaiveAlgo(5);
		int actualResult = primeNums.size();
		int expectedResult = 3;
		
		assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void genPrimeNumSimpleSieveAlgoTest() {
		
		List<Integer> primeNums = primeNumAlgoExecutor.genPrimeNumSimpleSieveAlgo(5);
		int actualResult = primeNums.size();
		int expectedResult = 3;
		
		assertEquals(actualResult, expectedResult);
	}
 


}
