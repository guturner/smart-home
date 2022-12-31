import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
}

group = "home.dev.wiki"
version = "0.0.1"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":wiki-domain"))

    // KMongo
    api("org.litote.kmongo:kmongo:4.3.0")

    // Logging
    api("ch.qos.logback:logback-classic:1.2.10")
    api("org.slf4j:slf4j-api:1.7.30")

    // JUnit 5
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.1")

    // TestContainers
    testImplementation("org.testcontainers:testcontainers:1.17.6")
    testImplementation("org.testcontainers:mongodb:1.17.6")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "1.8"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}