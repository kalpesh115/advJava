package com.AppDevelopement.Dev.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;

@ControllerAdvice
public class GlobalException {
	@ExceptionHandler(value=ArithmeticException.class , produces = {"application/json"})
	@ResponseBody
	public String arithmeticHandler() {
		JsonObject response=new JsonObject();
		response.addProperty("msg", "Arithmetic exception in class");
		return response.toString();
	}
	@ExceptionHandler(value=UserNotFoundCustomException.class , produces = {"application/json"})
	@ResponseBody
	public String customException(UserNotFoundCustomException e) {
		
		JsonObject response=new JsonObject();
		response.addProperty("msg",e.getMessage());
		response.addProperty("status","FAILURE");
		return response.toString();
		
	}
	
	

}
