plugins {
  id("groovy")
  id("com.github.rahulsom.waena.published")
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.apache.commons:commons-lang3:3.12.0")

  testImplementation("org.spockframework:spock-core:1.3-groovy-2.5")
}

project.description = "Groovy Library for Nothing"
