plugins {
  id("java-library")
  id("groovy")
  id("com.github.rahulsom.waena.published")
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.apache.commons:commons-lang3:3.17.0")
  api("org.apache.commons:commons-math3:3.6.1")

  testImplementation("org.spockframework:spock-core:2.3-groovy-4.0")
}

project.description = "Groovy Library for Nothing"
