import com.github.rahulsom.waena.WaenaPublished

plugins {
  id("groovy")
}

apply {
  plugin<WaenaPublishedPlugin>()
}

repositories {
  mavenCentral()
}

dependencies {
  implementation("org.apache.commons:commons-lang3:3.11")

  testImplementation("org.spockframework:spock-core:1.3-groovy-2.5")
}
