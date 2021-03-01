import com.github.rahulsom.waena.WaenaPublishedPlugin

plugins {
  id("org.jetbrains.kotlin.jvm") version "1.4.31"
}

apply {
  plugin<WaenaPublishedPlugin>()
}

repositories {
  mavenCentral()
  jcenter()
}

dependencies {
  implementation("org.apache.commons:commons-lang3:3.12.0")

  testImplementation("io.strikt:strikt-core:0.29.0")
}

project.description = "Kotlin Library for Nothing"
