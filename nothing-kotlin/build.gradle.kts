import com.github.rahulsom.waena.WaenaPublished

plugins {
  id("org.jetbrains.kotlin.jvm") version "1.4.30"
}

apply {
  plugin<WaenaPublishedPlugin>()
}

repositories {
  mavenCentral()
  jcenter()
}

dependencies {
  implementation("org.apache.commons:commons-lang3:3.11")

  testImplementation("io.strikt:strikt-core:0.29.0")
}
