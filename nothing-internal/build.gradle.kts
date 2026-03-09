plugins {
  id ("java")
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(libs.commons.lang3)

  testImplementation(libs.junit.jupiter.api)
  testRuntimeOnly(libs.junit.jupiter.engine)
}
