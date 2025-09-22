package com.yagmurbeyru.handler;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.yagmurbeyru.exception.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value= {BaseException.class})
	public ResponseEntity<ApiError> handleBaseException(BaseException exception, WebRequest request) {
		return ResponseEntity.badRequest().body(createApiError(exception.getMessage(), request));
		 
	}
	
	private String getHostName() {
		try {
			return Inet4Address.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			System.out.println("hata oluştu"+e.getMessage());
		}
		return null;
	}
	public<E> ApiError<E>createApiError(E message, WebRequest request){
		ApiError<E> apiError=new ApiError<>();
		apiError.setStatus(HttpStatus.BAD_REQUEST.value());
		
		Exception<E> exception=new Exception<>();
		exception.setCreatetTime(new Date());
		exception.setHostname(getHostName());
		exception.setPath(request.getDescription(false).substring(4));
		exception.setMessage(message);
		
		apiError.setException(exception);
		
		
		
		
		return apiError;
		
	}

}
