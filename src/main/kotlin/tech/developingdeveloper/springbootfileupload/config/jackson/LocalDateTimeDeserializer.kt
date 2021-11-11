package tech.developingdeveloper.springbootfileupload.config.jackson

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Component
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