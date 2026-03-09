plugins {
  id("java-library")
  alias(libs.plugins.waena.published)
}

repositories {
  mavenCentral()
}

dependencies {
  implementation(libs.commons.lang3)
  api(libs.commons.math3)

  testImplementation(libs.junit.jupiter.api)
  testRuntimeOnly(libs.junit.jupiter.engine)
  testRuntimeOnly(libs.junit.platform.launcher)
}

project.description = "Java Library for Nothing"

tasks.withType<Test> {
	useJUnitPlatform()
}
