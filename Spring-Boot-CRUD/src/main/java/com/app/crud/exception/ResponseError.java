package com.app.crud.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseError {
	private Integer statusCode;
	private String msg;
	private HttpStatus msgHttpStatus;
	private Date date;
	private String path;
}
