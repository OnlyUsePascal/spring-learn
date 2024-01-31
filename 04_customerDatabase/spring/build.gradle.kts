plugins {
  id("java")
  id("org.gretty") version "4.0.3"
  // id("war")
  // id("idea")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(platform("org.junit:junit-bom:5.9.1"))
  testImplementation("org.junit.jupiter:junit-jupiter")
  
  // spring
  implementation("org.springframework:spring-webmvc:6.1.2")
  implementation("org.springframework:spring-context:6.1.2")
  implementation("org.springframework:spring-jdbc:6.1.2")
  implementation("org.springframework:spring-tx:6.1.2")
  implementation("org.springframework:spring-orm:6.1.2")
  implementation("org.springframework:spring-core:6.1.3")
  
  // servlet
  implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0")
  implementation("jakarta.servlet.jsp:jakarta.servlet.jsp-api:3.0.0")
  // implementation("javax.servlet:javax.servlet-api:4.0.1")
  // implementation("org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1")

  // hibernate
  implementation("org.hibernate.orm:hibernate-core:6.3.0.Final")
  implementation("org.mariadb.jdbc:mariadb-java-client:3.1.4")
  
  // other
  implementation("org.reflections:reflections:0.10.2")
  implementation("com.fasterxml.jackson.core:jackson-core:2.15.2")
  implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
}

gretty {
  httpPort = 8080
  contextPath = "/"
}

tasks.test {
  useJUnitPlatform()
}