plugins {
  id("java-library")
  alias(libs.plugins.kotlin.jvm)
  alias(libs.plugins.waena.published)
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
