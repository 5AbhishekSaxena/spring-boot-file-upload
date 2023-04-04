import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.plugin.SpringBootPlugin

@Suppress("DSL_SCOPE_VIOLATION", "UnstableApiUsage")
plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.kotlin.lang)
    alias(libs.plugins.kotlin.spring)

    alias(libs.plugins.ktlint)
}

group = "tech.developingdeveloper"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform(SpringBootPlugin.BOM_COORDINATES))
    implementation(libs.spring.boot.starter.web)
    implementation(libs.jackson.kotlin)
    implementation(libs.kotlin.reflect)
    implementation(libs.kotlin.stdlib)

    implementation(libs.guava)

    testImplementation(libs.spring.boot.starter.test)
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

subprojects {
    apply("../buildscripts/ktlint.gradle")
}
