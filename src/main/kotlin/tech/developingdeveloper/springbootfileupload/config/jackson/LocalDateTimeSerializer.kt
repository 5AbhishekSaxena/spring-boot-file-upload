package tech.developingdeveloper.springbootfileupload.config.jackson

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
class LocalDateTimeSerializer : JsonSerializer<LocalDateTime>(), JsonDateTimePattern {
    override fun serialize(
        localDateTime: LocalDateTime?,
        jsonGenerator: JsonGenerator?,
        serializerProvider: SerializerProvider?
    ) {
        val dateTimeFormatter = DateTimeFormatter.ofPattern(pattern)
        val formattedDateTime = dateTimeFormatter.format(localDateTime)

        jsonGenerator?.writeString(formattedDateTime)
    }
}