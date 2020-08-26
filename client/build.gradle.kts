plugins {
    kotlin("jvm")
    application
    id("org.openjfx.javafxplugin")
//    id("org.beryx.jlink")
}

//val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
//val compileJava: JavaCompile by tasks
//compileJava.destinationDir = compileKotlin.destinationDir

dependencies {
    implementation(project(":library"))
}

javafx {
    version = "14"
    modules("javafx.controls", "javafx.fxml")
//    configuration = "compileOnly"
}

//jlink {
//    launcher {
//        name = "java-client"
//    }
//    imageZip.set(project.file("${project.buildDir}/image-zip/hello-image.zip"))
//}

application {
    mainClassName = "com.jfx.client.App"
}
