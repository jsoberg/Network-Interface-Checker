import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
    id("com.github.johnrengelman.shadow") version "7.1.0"
}

val appVersion = "1.0"

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.assertj:assertj-core:3.21.0")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "com.soberg.netchecker.Main"
    }
}

tasks.shadowJar {
    archiveBaseName.set("NetworkInterfaceChecker")
    archiveVersion.set(appVersion)
    archiveClassifier.set("")
    destinationDirectory.set(file("build/jar/"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("com.soberg.netchecker.MainKt")
}