plugins {
  id("java-library")
  id("org.jetbrains.kotlin.jvm") version "2.0.10"
  id("com.github.rahulsom.waena.published")
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.apache.commons:commons-lang3:3.16.0")
  api("org.apache.commons:commons-math3:3.6.1")

  testImplementation("io.strikt:strikt-core:0.35.1")
}

project.description = "Kotlin Library for Nothing"
