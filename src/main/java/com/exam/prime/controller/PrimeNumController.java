package com.exam.prime.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exam.prime.bean.PrimeNumReq;
import com.exam.prime.bean.PrimeNumResp;
import com.exam.prime.common.ApiResponse;
import com.exam.prime.helper.PrimeNumAlgoHelper;

import io.swagger.annotations.ApiOperation;
 

@RestController
@RequestMapping("/api")
public class PrimeNumController {
	@Autowired
	PrimeNumAlgoHelper primeNumAlgoHelper;
	
	@Autowired
	PrimeNumResp primeNumResp;
	private Logger logger = LoggerFactory.getLogger(PrimeNumController.class);
	
	public static final String HASH_KEY = "PrimeNumReq";
	
	@Autowired
	@Qualifier("MyTemplate")
	private RedisTemplate template ;
	
	@RequestMapping(value ="/primeNumGen", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE} , consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "all the prime numbers up to and including a number provided", notes= "Usage of appliedAlgorithm input : NA - Naive Alogithm, INA - Improvised Naive Algorithm, SSA - Simple Sieve Algorithm, SGSA, Segmented Sieve Algorithm " )
	public ApiResponse<PrimeNumResp> getPrimeNums(@RequestBody PrimeNumReq primeNumReq, HttpServletResponse response) {
		final String methodName = "PrimeNumberGen";
		logger.info(methodName);
		List<Integer> primeNums;
		int inputNum = primeNumReq.getInputNum();
		String appliedAlgorithm = primeNumReq.getAlgorithm();		 
		System.out.println("Number" + inputNum);
		String parsedInputNum = null;
		
		boolean isInputValid =primeNumAlgoHelper.isNumValidForPrimeNumGeneration(inputNum);
		
		if (isInputValid) {
			parsedInputNum=Integer.toString(inputNum);
			PrimeNumResp cacheData = (PrimeNumResp)template.opsForHash().get(HASH_KEY, parsedInputNum) ;
			if (null !=cacheData) {
				System.out.println("data from cache");
				return new ApiResponse<PrimeNumResp>(HttpStatus.OK, "Fetched Successfully", cacheData, null);				
			}else  {
				switch (appliedAlgorithm) {
				case "NA":
					primeNums=primeNumAlgoHelper.genPrimeNumsNaiveAlgo(inputNum);
					break;
				case "INA":
					primeNums=primeNumAlgoHelper.genPrimeNumImprovisedNaiveAlgo(inputNum);
					break;
				case "SSA":
					primeNums=primeNumAlgoHelper.genPrimeNumSimpleSieveAlgo(inputNum);
					break;
				case "SGSA":
					primeNums=primeNumAlgoHelper.genPrimeNumUsingSegSieveAlgo(inputNum);
					break;
				default:					
					primeNums=primeNumAlgoHelper.genPrimeNumUsingSegSieveAlgo(inputNum);
			}
			primeNumResp.setGeneratedPrimeNums(primeNums);
			 
			template.opsForHash().put(HASH_KEY,parsedInputNum, primeNumResp);			
			System.out.println("data put in cache");
			return new ApiResponse<PrimeNumResp>(HttpStatus.OK, "Fetched Successfully", primeNumResp, null);
			}
		}else {
			return new ApiResponse<PrimeNumResp>(HttpStatus.INTERNAL_SERVER_ERROR, "Failed", primeNumResp, null);
	}	
}
		
		 
	

}
