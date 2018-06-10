package kr.ac.hansung.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import kr.ac.hansung.exception.ErrorResponse;
import kr.ac.hansung.exception.UserDuplicateException;
import kr.ac.hansung.exception.UserNotFoundException;


@ControllerAdvice//전역적으로 다음 exception을 처리
public class GlobalExceptionController {

	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> 
	handleUserNotFoundException(HttpServletRequest req, UserNotFoundException ex){
		//request를 할때  url을 받기 위해서
		//error내용을 responsebody에 담아서 사용자에게 보여주기 위해서
		String requestURL = req.getRequestURL().toString();
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setRequestURL(requestURL);
		errorResponse.setErrorCode("user.notfound.exception");
		errorResponse.setErrorMsg("User with id " +ex.getUserId() +"Not Found");
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(UserDuplicateException.class)
	public ResponseEntity<ErrorResponse> 
	handleUserDuplicatedException(HttpServletRequest req, UserDuplicateException ex){
		
		String requestURL = req.getRequestURL().toString();
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setRequestURL(requestURL);
		errorResponse.setErrorCode("user.duplicated.exception");
		errorResponse.setErrorMsg("Unable to create. A user with name " +ex.getUserName() +"already exist");
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.CONFLICT);
	}
	
}
