package com.huning.oembed.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse invalidRequestHandler(MethodArgumentNotValidException e) {
        ErrorResponse response = ErrorResponse.builder()
                .code("400")
                .message("잘못된 요청입니다.")
                .build();

        for (FieldError fieldError : e.getFieldErrors()) {
            response.addValidation(fieldError.getField(), fieldError.getDefaultMessage());
        }

        return response;
    }

    @ResponseBody
    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> appException(AppException e) {
	    HttpStatus httpStatus = e.getStatusCode();

	    ErrorResponse body = ErrorResponse.builder()
                .code(String.valueOf(httpStatus.value()))
                .message(e.getMessage())
                .validation(e.getValidation())
                .build();

        ResponseEntity<ErrorResponse> response = ResponseEntity.status(httpStatus)
                .body(body);

        return response;
    }
}










