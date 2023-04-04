@file:Suppress("UnstableApiUsage")

rootProject.name = "spring-boot-file-upload"

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}
