plugins {
    java
    kotlin("jvm") version "1.4.0"
    id("org.openjfx.javafxplugin") version "0.0.8"
//    id("org.beryx.jlink") version "2.9.4"
}

val slf4jVersion by extra("1.7.30")
val log4j2Version by extra("2.13.3")
val junitVersion by extra("5.6.2")

group = "com.jfx"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        mavenCentral()
        jcenter()
    }

    apply(plugin = "org.jetbrains.kotlin.jvm")
}

subprojects {
    dependencies {
        // Align versions of all Kotlin components
        implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
        implementation(kotlin("stdlib"))

        // Use SLF4J with log4j2
        implementation("org.slf4j:slf4j-api:$slf4jVersion")
        implementation("org.apache.logging.log4j:log4j-core:$log4j2Version")
        implementation("org.apache.logging.log4j:log4j-slf4j-impl:$log4j2Version")

        // Use JUnit Jupiter for testing.
        testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")

        // Use the Kotlin test library.
        testImplementation("org.jetbrains.kotlin:kotlin-test")
        // Use the Kotlin JUnit integration.
        testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = "13"
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        showStandardStreams = true
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}
