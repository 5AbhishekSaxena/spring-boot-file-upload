package tech.developingdeveloper.fileuploadplayground.config.jackson

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


/**
 * Created by Abhishek Saxena on 20-09-2021.
 */

@Configuration
class JacksonConfiguration {

    @Bean
    fun localDateTimeSerializer() = LocalDateTimeSerializer()

    @Bean
    fun localDateTimeDeserializer() = LocalDateTimeDeserializer()

    @Bean
    fun javaTimeModule(
        localDateTimeSerializer: LocalDateTimeSerializer,
        localDateTimeDeserializer: LocalDateTimeDeserializer
    ): JavaTimeModule = JavaTimeModule().apply {
        addSerializer(LocalDateTime::class.java, localDateTimeSerializer)
        addDeserializer(LocalDateTime::class.java, localDateTimeDeserializer)
    }
}