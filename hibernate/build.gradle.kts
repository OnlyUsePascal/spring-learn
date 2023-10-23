plugins {
    id("java")
    id("eclipse")
    id("war")
    id("idea")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://repo.spring.io/release")
    }
    maven {
        url = uri("https://repository.jboss.org/maven2")
    }
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // hibernate
    implementation("org.hibernate.orm:hibernate-core:6.3.0.Final")
    // mysql / mariadb
    implementation("org.mariadb.jdbc:mariadb-java-client:3.1.4")
    
    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core
    implementation("org.apache.logging.log4j:log4j-core:2.20.0")
    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-slf4j-impl
    implementation("org.apache.logging.log4j:log4j-slf4j-impl:2.20.0")
    // https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api
    implementation("org.apache.logging.log4j:log4j-api:2.20.0")
    
    // class scanner
    implementation("org.reflections:reflections:0.10.2")
    
}

tasks.test {
    useJUnitPlatform()
}