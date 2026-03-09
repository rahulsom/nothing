plugins {
  id("java-library")
  alias(libs.plugins.kotlin.jvm)
  id("com.github.rahulsom.waena.published")
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(libs.commons.lang3)
  api(libs.commons.math3)

  testImplementation(libs.strikt.core)
}

project.description = "Kotlin Library for Nothing"
