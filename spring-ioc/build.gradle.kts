plugins {
    id("java")
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")

    implementation("org.springframework:spring-webmvc")
    implementation("javax.servlet:javax.servlet-api:3.0.1")
    implementation("org.apache.tomcat:tomcat-jasper:10.1.10")

//    testImplementation("org.springframework.boot:spring-boot-starter-test")
//    testImplementation(platform("org.junit:junit-bom:5.9.1"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}