plugins {
  id ("java")
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.apache.commons:commons-lang3:3.19.0")

  testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.1")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:6.0.1")
}
