plugins {
  id("java-library")
  id("org.jetbrains.kotlin.jvm") version "1.5.30"
  id("com.github.rahulsom.waena.published")
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.apache.commons:commons-lang3:3.12.0")
  api("org.apache.commons:commons-math3:3.6.1")

  testImplementation("io.strikt:strikt-core:0.31.0")
}

project.description = "Kotlin Library for Nothing"
