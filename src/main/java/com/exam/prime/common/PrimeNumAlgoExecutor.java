package com.exam.prime.common;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class PrimeNumAlgoExecutor {

	private Logger logger = LoggerFactory.getLogger(PrimeNumAlgoExecutor.class);

	// Naive Algorithm(NA)
	public List<Integer> genPrimeNumsNaiveAlgo(int inputNum) {
		final String methodName = "genPrimeNumsNaiveAlgo";
		logger.debug(methodName);
		List<Integer> primeNums = new ArrayList<>();
		for (int i = 2; i <= inputNum; i++) {
			if (isInputNumPrimeAlgoA(i)) {
				primeNums.add(i);
			}
		}
		return primeNums;
	}

	public boolean isInputNumPrimeAlgoA(int num) {
		final String methodName = "isInputNumPrimeAlgoA";
		logger.debug(methodName);

		for (int j = 2; j < num; j++) {
			if (num % j == 0) {
				return false;
			}
		}
		return true;
	}

	// Improvised Naive Algorithm(INA)
	public List<Integer> genPrimeNumImprovisedNaiveAlgo(int inputNum) {
		final String methodName = "genPrimeNumImprovisedNaiveAlgo";
		logger.debug(methodName);
		List<Integer> primeNums = new ArrayList<>();
		if (inputNum >= 2) {
			primeNums.add(2);
		}

		for (int i = 3; i <= inputNum; i += 2) {
			if (isInputNumPrimeAlgoB(i)) {
				primeNums.add(i);
			}
		}
		return primeNums;
	}

	public boolean isInputNumPrimeAlgoB(int num) {
		final String methodName = "isInputNumPrimeAlgoB";
		logger.debug(methodName);
		for (int j = 2; j * j <= num; j++) {
			if (num % j == 0) {
				return false;
			}
		}
		return true;
	}

	// Simple Sieve Algorithm(SSA)
	public synchronized List<Integer> genPrimeNumSimpleSieveAlgo(int inputNum) {
		final String methodName = "genPrimeNumSimpleSieveAlgo";
		logger.debug(methodName);
		List<Integer> primeNumsSSA = new ArrayList<>();
		boolean[] isPrime = new boolean[inputNum];
		isPrime[0] = false;
		for (int m = 1; m < inputNum; m++) {
			isPrime[m] = true;
		}
		for (int i = 2; i <= inputNum; i++) {
			if (isPrime[i - 1]) {
				primeNumsSSA.add(i);
				for (int j = i * i; j <= inputNum; j += i) {
					isPrime[j - 1] = false;
				}
			}
		}
		return primeNumsSSA;
	}
}
