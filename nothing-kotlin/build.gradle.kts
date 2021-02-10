plugins {
  id("org.jetbrains.kotlin.jvm") version "1.4.30"
}

apply(from = "../gradle/publishModule.gradle.kts")

repositories {
  mavenCentral()
  jcenter()
}

dependencies {
  implementation("org.apache.commons:commons-lang3:3.11")

  testImplementation("io.strikt:strikt-core:0.29.0")
}
