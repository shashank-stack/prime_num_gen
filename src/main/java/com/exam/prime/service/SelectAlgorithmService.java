package com.exam.prime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.prime.common.PrimeNumAlgoExecutor;

@Service
public class SelectAlgorithmService {
	
	@Autowired
	private PrimeNumAlgoExecutor primeNumAlgoService;
	
	List<Integer> primeNums;
	
	public List<Integer> selectAlgo(String appliedAlgorithm, int inputNum) {
		// TODO Auto-generated method stub
		switch (appliedAlgorithm) {
		case "NA":
			primeNums=primeNumAlgoService.genPrimeNumsNaiveAlgo(inputNum);
			break;
		case "INA":
			primeNums=primeNumAlgoService.genPrimeNumImprovisedNaiveAlgo(inputNum);
			break;
		case "SSA":
			primeNums=primeNumAlgoService.genPrimeNumSimpleSieveAlgo(inputNum);
			break;
		case "SGSA":
			primeNums=primeNumAlgoService.genPrimeNumUsingSegSieveAlgo(inputNum);
			break;
		default:					
			primeNums=primeNumAlgoService.genPrimeNumUsingSegSieveAlgo(inputNum);
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
