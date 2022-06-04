package com.exam.prime.common;

import java.util.Map;

import org.springframework.http.HttpStatus;

public class ApiResponse<T> {

	private HttpStatus status;
	private String message;
	private T response;
	private Map<String, Object> additionalResponse;

	public ApiResponse(HttpStatus status, String message, T response, Map<String, Object> additionalResponse) {

		this.status = status;
		this.message = message;
		this.response = response;
		this.additionalResponse = additionalResponse;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getResponse() {
		return response;
	}

	public void setResponse(T response) {
		this.response = response;
	}

	public Map<String, Object> getAdditionalResponse() {
		return additionalResponse;
	}

	public void setAdditionalResponse(Map<String, Object> additionalResponse) {
		this.additionalResponse = additionalResponse;
	}

}
