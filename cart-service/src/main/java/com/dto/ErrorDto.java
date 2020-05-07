package com.dto;
public class ErrorDto {
    private String code;
    private String message;
    private String field;
    
    
	public ErrorDto(String code, String message, String field) {
		super();
		this.code = code;
		this.message = message;
		this.field = field;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}

}