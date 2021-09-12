plugins {
  id ("java")
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.apache.commons:commons-lang3:3.12.0")

  testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.0")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.0")
}
