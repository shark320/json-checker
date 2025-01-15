plugins {
    kotlin("jvm") version "2.0.20"
}

group = "com.vpavlov"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(libs.jackson.databind)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}