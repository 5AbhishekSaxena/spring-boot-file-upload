package tech.developingdeveloper.fileuploadplayground.web.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


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
}