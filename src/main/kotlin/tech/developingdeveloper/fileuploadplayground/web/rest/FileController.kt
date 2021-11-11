package tech.developingdeveloper.fileuploadplayground.web.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import tech.developingdeveloper.fileuploadplayground.service.FileService
import javax.servlet.http.HttpServletRequest


/**
 * Created by Abhishek Saxena on 11-11-2021.
 */

@RestController
@RequestMapping("images")
class FileController(
    private val fileService: FileService
) {

    @PostMapping
    fun uploadImage(
        @RequestParam("imageFile") imageFile: MultipartFile,
        request: HttpServletRequest
    ): ResponseEntity<String> {
        val fileName = fileService.saveImage(imageFile)
        val body = getFileAccessUrl(request.requestURL, fileName)
        return ResponseEntity(body, HttpStatus.CREATED)
    }

    private fun getFileAccessUrl(requestURL: StringBuffer?, fileName: String): String {
        val baseUrl = requestURL ?: Exception("Invalid requestURL")
        return "${baseUrl}/$fileName"
    }
}