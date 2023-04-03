package tech.developingdeveloper.springbootfileupload.web.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import java.io.FileNotFoundException

/**
 * Created by Abhishek Saxena on 12-11-2021.
 */

@RestControllerAdvice
class RestExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleGeneralExceptions(exception: Exception): ResponseEntity<ApiError> {
        val apiError = ApiError(exception.message)
        return ResponseEntity(apiError, apiError.httpStatus)
    }

    @ExceptionHandler(FileNotFoundException::class)
    fun handleFileNotFoundException(exception: FileNotFoundException): ResponseEntity<ApiError> {
        val apiError = ApiError(exception.message, httpStatus = HttpStatus.NOT_FOUND)
        return ResponseEntity(apiError, apiError.httpStatus)
    }
}
