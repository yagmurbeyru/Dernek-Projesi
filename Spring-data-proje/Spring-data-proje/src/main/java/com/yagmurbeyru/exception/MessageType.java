package com.yagmurbeyru.exception;

import lombok.Getter;

@Getter
public enum MessageType {
	
	NO_RECORD_EXIST("No record found"), 
	GENERAL_EXCEPTION("A general error occurred"), 
	ENTITY_NOT_FOUND("The related entity was not found in the system"), 
	VALIDATION_ERROR("Invalid data entered"), 
	UNAUTHORIZED("Unauthorized access"), 
	FORBIDDEN("You do not have permission to perform this operation"), 
	BAD_REQUEST("Invalid request"), 
	INTERNAL_ERROR("An unexpected error occurred on the server side"), 
	DATA_INTEGRITY_VIOLATION("Data integrity violation"), 
	FILE_NOT_FOUND("File not found"), 
	FILE_UPLOAD_ERROR("An error occurred while uploading the file"), 
	JSON_PARSE_ERROR("An error occurred while parsing JSON"), 
	DUPLICATE_RECORD("This record already exists"), 
	SERVICE_UNAVAILABLE("The service is temporarily unavailable");
	
	private String message;
	
	private MessageType(String message) {
		this.message=message;
	}

}
