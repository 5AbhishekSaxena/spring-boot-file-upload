package tech.developingdeveloper.fileuploadplayground.config.jackson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class LocalDateTimeDeserializer : JsonDeserializer<LocalDateTime>(), JsonDateTimePattern {
    override fun deserialize(
        jsonParser: JsonParser?,
        deserializationContext: DeserializationContext?
    ): LocalDateTime {
        val dateTimeFormatter = DateTimeFormatter.ofPattern(pattern)
        val value = jsonParser?.valueAsString

        return LocalDateTime.parse(value, dateTimeFormatter)
    }
}