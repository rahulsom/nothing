plugins {
  id("java-library")
  id("groovy")
  alias(libs.plugins.waena.published)
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(libs.commons.lang3)
  api(libs.commons.math3)

  testImplementation(libs.spock.core)
}

project.description = "Groovy Library for Nothing"
