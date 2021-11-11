package tech.developingdeveloper.springbootfileupload.config.jackson


/**
 * Created by Abhishek Saxena on 20-09-2021.
 */

interface JsonDateTimePattern {
    val pattern: String
        get() = "MMMM dd, yyyy HH:mm:ss"
}