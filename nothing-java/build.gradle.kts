import com.github.rahulsom.waena.WaenaPublishedPlugin

plugins {
  id("java")
}

apply {
  plugin<WaenaPublishedPlugin>()
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.apache.commons:commons-lang3:3.11")

  testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.1")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.1")
}

project.description = "Java Library for Nothing"

tasks.withType<Test> {
	useJUnitPlatform()
}
