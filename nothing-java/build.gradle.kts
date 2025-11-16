plugins {
  id("java-library")
  id("com.github.rahulsom.waena.published")
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.apache.commons:commons-lang3:3.20.0")
  api("org.apache.commons:commons-math3:3.6.1")

  testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.1")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:6.0.1")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher:6.0.1")
}

project.description = "Java Library for Nothing"

tasks.withType<Test> {
	useJUnitPlatform()
}
