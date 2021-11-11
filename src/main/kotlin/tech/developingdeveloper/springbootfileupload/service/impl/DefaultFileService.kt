package tech.developingdeveloper.springbootfileupload.service.impl

import org.springframework.core.io.FileSystemResource
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import tech.developingdeveloper.springbootfileupload.service.FileService
import tech.developingdeveloper.springbootfileupload.utils.formatFileName
import tech.developingdeveloper.springbootfileupload.utils.getCurrentTimestamp
import tech.developingdeveloper.springbootfileupload.utils.getFileNameAndExtension
import java.io.File
import java.io.FileNotFoundException
import java.nio.file.Files
import java.nio.file.Paths

@Service
class DefaultFileService : FileService {

    override val rootFolder: String
        get() = "D:/photos/"

    override fun saveImage(imageFile: MultipartFile): String {
        val bytes = imageFile.bytes

        val formattedTimestamp = getCurrentTimestamp(pattern = "dd_MM_yyyy_hh_mm_ss")
        val fileName = getGeneratedFileName(imageFile, prefix = "IMG", postFix = formattedTimestamp)
        val destination = getDestination(fileName)
        writeFileAtDestination(destination, bytes)
        return fileName
    }

    private fun getDestination(fileName: String): String {
        return "$rootFolder${fileName.trim()}"
    }

    private fun getGeneratedFileName(
        imageFile: MultipartFile,
        prefix: String,
        postFix: String,
        prefixSep: String = "_",
        postfixSep: String = "_"
    ): String {
        val (fileName, fileExtension) = getFileNameAndExtension(imageFile)
        val formattedFileName = formatFileName(fileName)
        return "${prefix}${prefixSep}${formattedFileName}${postfixSep}${postFix}.${fileExtension}"
            .replace("(_{2,})".toRegex(), "_")
    }

    private fun writeFileAtDestination(destination: String, bytes: ByteArray) {
        val path = Paths.get(destination)
        Files.write(path, bytes)
    }

    override fun getImage(fileName: String): FileSystemResource {
        val destination = getDestination(fileName)
        val file = File(destination)
        if (!file.isFile) throw FileNotFoundException("File with $fileName not found.")

        return FileSystemResource(file)
    }
}