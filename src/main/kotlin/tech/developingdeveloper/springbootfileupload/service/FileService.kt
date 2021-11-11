package tech.developingdeveloper.springbootfileupload.service

import org.springframework.core.io.FileSystemResource
import org.springframework.web.multipart.MultipartFile


/**
 * Created by Abhishek Saxena on 11-11-2021.
 */

interface FileService {

    val rootFolder: String

    fun saveImage(imageFile: MultipartFile): String
    fun getImage(fileName: String): FileSystemResource
}