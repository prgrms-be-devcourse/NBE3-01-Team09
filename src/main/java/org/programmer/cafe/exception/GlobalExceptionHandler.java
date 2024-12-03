package org.programmer.cafe.exception;

import lombok.extern.slf4j.Slf4j;
import org.programmer.cafe.global.response.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * 공통 예외처리 클래스
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    // 잘못된 경로 에러 404
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleNoHandlerFoundException(NoHandlerFoundException e) {
        log.error("[NoHandlerFoundException] message: {}", e.getMessage());
        ErrorCode errorCode = ErrorCode.NOT_FOUND;
        return ResponseEntity.status(errorCode.getStatus())
                .body(ApiResponse.createError(errorCode.getMessage()));
    }

    // Http Method 에러
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiResponse<Object>> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("[HttpRequestMethodNotSupportedException] message: {}", e.getMessage());
        ErrorCode errorCode = ErrorCode.METHOD_NOT_ALLOWED;
        return ResponseEntity.status(errorCode.getStatus())
                .body(ApiResponse.createError(errorCode.getMessage()));
    }

    // IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Object>> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("[IllegalArgumentException] message: {}", e.getMessage());
        ErrorCode errorCode = ErrorCode.BAD_REQUEST;
        return ResponseEntity.status(errorCode.getStatus())
                .body(ApiResponse.createErrorWithMsg(e.getMessage()));
    }

    // 각종 400 에러
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiResponse<Object>> handleBadRequestException(BadRequestException e) {
        log.error("[BadRequestException] message: {}", e.getMessage());
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(ApiResponse.createError(e.getErrorCode().getMessage()));
    }

    // 각종 404 에러
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleNotFoundException(NotFoundException e) {
        log.error("[NotFoundException] message: {}", e.getMessage());
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(ApiResponse.createError(e.getErrorCode().getMessage()));
    }

    // 위의 경우를 제외한 모든 에러 500
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleException(Exception e) {
        log.error("[Exception] message: {},{}", e.getMessage(), e.getClass(), e.getCause());
        ErrorCode errorCode = ErrorCode.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(errorCode.getStatus())
                .body(ApiResponse.createError(errorCode.getMessage()));
    }
}