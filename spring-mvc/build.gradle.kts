plugins {
    id("java")
    id("eclipse")
    id("org.gretty") version "4.0.3"
    id("war")
    id("idea")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("javax.servlet:javax.servlet-api:4.0.1")
    implementation("org.springframework:spring-webmvc:6.0.9")
    implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0")
    implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

gretty{
    httpPort = 8080
    contextPath = "/"
}

tasks.test {
    useJUnitPlatform()
}