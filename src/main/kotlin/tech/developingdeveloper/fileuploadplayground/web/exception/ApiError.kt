package tech.developingdeveloper.fileuploadplayground.web.exception

import org.springframework.http.HttpStatus
import java.time.LocalDateTime


/**
 * Created by Abhishek Saxena on 11-11-2021.
 */

data class ApiError(
    private val _message: String?,
    val httpStatus: HttpStatus = HttpStatus.BAD_REQUEST,
    val statusCode: Int = httpStatus.value(),
    val timestamp: LocalDateTime = LocalDateTime.now()
) {
    val message: String
        get() = _message ?: "Something went wrong"
}