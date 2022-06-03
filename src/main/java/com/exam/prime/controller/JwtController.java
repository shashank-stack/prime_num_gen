package com.exam.prime.controller;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.exam.prime.bean.JwtRequest;
import com.exam.prime.bean.JwtResponse;
import com.exam.prime.common.JwtTokenUtil;
import com.exam.prime.exception.InvalidCredentialsException;
import com.exam.prime.exception.InvalidInputException;
import com.exam.prime.service.CustomUserDetailsService;

 
@RestController
public class JwtController {
	
	private Logger logger = LoggerFactory.getLogger(JwtController.class);
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtTokenUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	@RequestMapping(value="/token", method = RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		try {
			
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
			
		} catch (UsernameNotFoundException e) {
			logger.error("Bad Credentials");		
			throw new InvalidCredentialsException("2000", "UserId not registered");
		}catch (BadCredentialsException e ) {			
			logger.error("Bad Credentials");
			throw new InvalidInputException("3000", "UserId or password is invalid");
		}
		
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUserName());
		String generatedToken = this.jwtUtil.generateToken(userDetails);			
		return ResponseEntity.ok(new JwtResponse(generatedToken));
		
	}

}
