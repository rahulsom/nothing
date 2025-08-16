plugins {
  id("java-library")
  id("com.github.rahulsom.waena.published")
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.apache.commons:commons-lang3:3.18.0")
  api("org.apache.commons:commons-math3:3.6.1")

  testImplementation("org.junit.jupiter:junit-jupiter-api:5.13.4")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.13.4")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.13.4")
}

project.description = "Java Library for Nothing"

tasks.withType<Test> {
	useJUnitPlatform()
}
