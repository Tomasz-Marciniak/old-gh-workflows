import java.util.Properties

val version: String by project

group = "com.upfera"

plugins {
    `java`
    `maven-publish`
}

repositories {
    mavenCentral()
    mavenLocal()
}

java {
    withJavadocJar()
    withSourcesJar()
    sourceCompatibility = JavaVersion.VERSION_20
    targetCompatibility = JavaVersion.VERSION_20
}

tasks {
    jar {
        enabled = true
        archiveClassifier.set("")
    }
}


publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/upfera/gh-workflows")
            credentials {
                username = System.getenv("MAVEN_REPOSITORY_USERNAME")
                password = System.getenv("MAVEN_REPOSITORY_TOKEN")
            }
        }
    }
}
