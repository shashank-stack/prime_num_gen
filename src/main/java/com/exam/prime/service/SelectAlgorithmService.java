package com.exam.prime.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.prime.common.PrimeNumAlgoExecutor;

@Service
public class SelectAlgorithmService {
	
	@Autowired
	private PrimeNumAlgoExecutor primeNumAlgoExecutor;
	
	
	
	public List<Integer> selectAlgo(String appliedAlgorithm, int inputNum) {
		// TODO Auto-generated method stub
		List<Integer> primeNums = new ArrayList<>();
		switch (appliedAlgorithm) {
		case "NA":
			primeNums=primeNumAlgoExecutor.genPrimeNumsNaiveAlgo(inputNum);
			break;
		case "INA":
			primeNums=primeNumAlgoExecutor.genPrimeNumImprovisedNaiveAlgo(inputNum);
			break;
		case "SSA":
			primeNums=primeNumAlgoExecutor.genPrimeNumSimpleSieveAlgo(inputNum);
			break; 
		default:					
			primeNums=primeNumAlgoExecutor.genPrimeNumSimpleSieveAlgo(inputNum);
		}
		return primeNums;
	}
	
	public boolean isNumValidForPrimeNumGeneration(int inputNum) {
		
		if (inputNum ==1 || inputNum <=0) {
			return false;
		}		
		return true;
	}
	
}
