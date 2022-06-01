package com.boa.prime.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.boa.prime.helper.PrimeNumAlgoHelper;
import com.boa.prime.bean.PrimeNumReq;
import com.boa.prime.bean.PrimeNumResp;
import com.boa.prime.common.ApiResponse;
 

@RestController
@RequestMapping("/primeNumGen")
public class PrimeNumController {
	@Autowired
	PrimeNumAlgoHelper primeNumAlgoHelper;
	
	@Autowired
	PrimeNumResp primeNumResp;
	private Logger logger = LoggerFactory.getLogger(PrimeNumController.class);
	
	@RequestMapping(method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ApiResponse<PrimeNumResp> PrimeNumberGen(@RequestBody PrimeNumReq primeNumReq, HttpServletResponse response) {
		final String methodName = "PrimeNumberGen";
		logger.info(methodName);
		List<Integer> primeNums;
		int inputNum = primeNumReq.getInputNum();
		String appliedAlgorithm = primeNumReq.getAlgorithm();
		String returnContentType = primeNumReq.getContentType();
		System.out.println("Number" + inputNum);
		
	 
		boolean isInputValid =primeNumAlgoHelper.isNumValidForPrimeNumGeneration(inputNum);
		
		if (isInputValid) {
			
			switch (appliedAlgorithm) {
				case "A":
					primeNums=primeNumAlgoHelper.generatePrimeNumbersUsingAlgoA(inputNum);
					break;
				case "B":
					primeNums=primeNumAlgoHelper.generatePrimeNumbersUsingAlgoB(inputNum);
					break;
				default:					
					primeNums = null;
			}
			primeNumResp.setGeneratedPrimeNums(primeNums);
			return new ApiResponse<PrimeNumResp>(HttpStatus.OK, "Fetched Successfully", primeNumResp, null);
			
		}else {
			return new ApiResponse<PrimeNumResp>(HttpStatus.INTERNAL_SERVER_ERROR, "Failed", primeNumResp, null);
		}		
	 
	}

}
