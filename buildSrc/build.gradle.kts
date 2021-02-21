plugins {
  `kotlin-dsl`
}

repositories {
  mavenCentral()
  gradlePluginPortal()
}

dependencies {
  implementation("com.netflix.nebula:nebula-release-plugin:15.3.1")
  implementation("com.netflix.nebula:nebula-publishing-plugin:17.3.2")
  implementation("com.netflix.nebula:gradle-contacts-plugin:5.1.0")
  implementation("com.netflix.nebula:gradle-info-plugin:9.3.0")

  implementation("io.codearte.gradle.nexus:gradle-nexus-staging-plugin:0.22.0")
  implementation("de.marcphilipp.gradle:nexus-publish-plugin:0.4.0")
}
