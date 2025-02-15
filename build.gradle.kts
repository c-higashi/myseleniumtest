plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:4.28.1")
    implementation("org.seleniumhq.selenium:selenium-chrome-driver:4.28.1")
    implementation("org.testng:testng:7.11.0")
}

tasks.test {
    useTestNG()
}