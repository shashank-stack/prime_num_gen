package com.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import org.junit.Test;

import com.exam.prime.common.PrimeNumAlgoExecutor;

public class PrimeNumberAlgoUnitTest {

	private PrimeNumAlgoExecutor primeNumAlgoExecutor = new PrimeNumAlgoExecutor();

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
