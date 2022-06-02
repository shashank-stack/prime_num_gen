package com.exam.prime.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.exam.prime.common.PrimeNumAlgoExecutor;
import com.exam.prime.service.SelectAlgorithmService;

import io.swagger.annotations.ApiOperation;
 

@RestController
@RequestMapping("/api")
public class PrimeNumController {
	@Autowired
	SelectAlgorithmService selectAlgorithmService;
	
	@Autowired
	PrimeNumResp primeNumResp;
	private Logger logger = LoggerFactory.getLogger(PrimeNumController.class);
	
	public static final String HASH_KEY = "PrimeNumReq";
	
	@Autowired
	@Qualifier("MyTemplate")
	private RedisTemplate template ;
	
	@RequestMapping(value ="/primeNumGen", method=RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE} , consumes=MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "all the prime numbers up to and including a number provided", notes= "Usage of appliedAlgorithm input : NA - Naive Alogithm, INA - Improvised Naive Algorithm, SSA - Simple Sieve Algorithm, SGSA, Segmented Sieve Algorithm " )
	public ApiResponse<PrimeNumResp> getPrimeNums(@RequestBody PrimeNumReq primeNumReq) {
		final String methodName = "getPrimeNums";
		logger.info(methodName);
		List<Integer> primeNums;
		int inputNum = primeNumReq.getInputNum();
		String appliedAlgorithm = primeNumReq.getAlgorithm();		 
		System.out.println("Number" + inputNum);
		String parsedInputNum = null;
		
		boolean isInputValid =selectAlgorithmService.isNumValidForPrimeNumGeneration(inputNum);		
		if (isInputValid) {
			parsedInputNum=Integer.toString(inputNum);
			PrimeNumResp cacheData = (PrimeNumResp)template.opsForHash().get(HASH_KEY, parsedInputNum) ;
			if (null !=cacheData) {
				logger.info("data Fetched from cache " + inputNum);
				return new ApiResponse<PrimeNumResp>(HttpStatus.OK, "Fetched Successfully", cacheData, null);				
			}else  {
				primeNums = selectAlgorithmService.selectAlgo(appliedAlgorithm,inputNum );
				
			primeNumResp.setGeneratedPrimeNums(primeNums);			 
			template.opsForHash().put(HASH_KEY,parsedInputNum, primeNumResp);			
			logger.info("data put in cache " + inputNum);
			return new ApiResponse<PrimeNumResp>(HttpStatus.OK, "Fetched Successfully", primeNumResp, null);
			}
		}else {
			logger.error("Supplied number in input is Invalid " + inputNum);
			Map<String,Object> additionalResponse  = new HashMap<String, Object>();
			additionalResponse.put("InputNum", "Supplied input number in input is Invalid ");
			return new ApiResponse<PrimeNumResp>(HttpStatus.INTERNAL_SERVER_ERROR, "Failed", primeNumResp, additionalResponse);
		}	
	}
}
