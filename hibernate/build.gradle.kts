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
    // implementation("mysql:mysql-connector-java:8.0.27")
    implementation("org.mariadb.jdbc:mariadb-java-client:3.1.4")

}

tasks.test {
    useJUnitPlatform()
}