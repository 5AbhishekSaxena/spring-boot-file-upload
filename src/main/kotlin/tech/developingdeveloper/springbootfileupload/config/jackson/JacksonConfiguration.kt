package tech.developingdeveloper.springbootfileupload.config.jackson

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime

/**
 * Created by Abhishek Saxena on 20-09-2021.
 */

@Configuration
class JacksonConfiguration {

    @Bean
    fun javaTimeModule(
        localDateTimeSerializer: LocalDateTimeSerializer,
        localDateTimeDeserializer: LocalDateTimeDeserializer
    ): JavaTimeModule = JavaTimeModule().apply {
        addSerializer(LocalDateTime::class.java, localDateTimeSerializer)
        addDeserializer(LocalDateTime::class.java, localDateTimeDeserializer)
    }
}
