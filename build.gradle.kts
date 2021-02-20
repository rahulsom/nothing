plugins {
  id("signing")
  id("nebula.release") version "15.3.1"
  id("io.codearte.nexus-staging") version "0.22.0"
  id("de.marcphilipp.nexus-publish") version "0.4.0"
}

allprojects {
  group = "com.github.rahulsom"
}
