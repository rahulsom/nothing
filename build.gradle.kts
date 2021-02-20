import java.time.Duration

plugins {
  id("signing")
  id("nebula.release") version "15.3.1"
  id("io.codearte.nexus-staging") version "0.22.0"
  id("de.marcphilipp.nexus-publish") version "0.4.0"
}

allprojects {
  group = "com.github.rahulsom"
  apply(plugin = "de.marcphilipp.nexus-publish")
}

nexusStaging {
  username = project.findProperty("sonatypeUsername") as String
  password = project.findProperty("sonatypePassword") as String
  repositoryDescription = "Release ${project.group} ${project.version}"
}

allprojects {
  nexusPublishing {
    repositories {
      sonatype()
    }
    connectTimeout.set(Duration.ofMinutes(3))
    clientTimeout.set(Duration.ofMinutes(3))
  }
}
