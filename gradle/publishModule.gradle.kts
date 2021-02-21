import java.net.URI

buildscript {
  repositories {
    gradlePluginPortal()
  }
  dependencies {
    classpath("de.marcphilipp.gradle:nexus-publish-plugin:0.4.0")
    classpath("com.netflix.nebula:nebula-release-plugin:15.3.1")
  }
}

apply(plugin = "de.marcphilipp.nexus-publish")
apply(plugin = "signing")
apply(plugin = "nebula.release")


configure<PublishingExtension> {
  publications {
    create<MavenPublication>("maven") {
      from(components.getByName("java"))
    }
  }
}

configure<JavaPluginExtension> {
  withJavadocJar()
  withSourcesJar()
}

val hasSigningKey = project.hasProperty("signing.keyId") || project.findProperty("signingKey") != null

if (hasSigningKey) {
  signProject(project)
}

fun signProject(project: Project) {
  project.configure<SigningExtension> {
    val signingKeyId = project.findProperty("signingKeyId") as String?
    val signingKey = project.findProperty("signingKey") as String?
    val signingPassword = project.findProperty("signingPassword") as String?
    if (signingKeyId != null) {
      useInMemoryPgpKeys(signingKeyId, signingKey, signingPassword)
    } else if (signingKey != null) {
      useInMemoryPgpKeys(signingKey, signingPassword!!)
    }
    sign(project.extensions.getByType<PublishingExtension>().publications.getByName("maven"))
  }
}

project.plugins.withType<MavenPublishPlugin>().all {
  val publishing = project.extensions.getByType<PublishingExtension>()
  publishing.publications.withType<MavenPublication>().forEach { mavenPublication ->
    mavenPublication.pom {
      name.set("${project.group}:${project.name}")
      description.set(name)
      url.set("https://github.com/rahulsom/${rootProject.name}")
      licenses {
        license {
          name.set("The Apache License, Version 2.0")
          url.set("https://www.apache.org/licenses/LICENSE-2.0")
        }
      }
      developers {
        developer {
          id.set("rahulsom")
          name.set("Rahul Somasunderam")
          email.set("rahulsom@noreply.github.com")
        }
      }
      scm {
        connection.set("scm:git:https://github.com/rahulsom/${rootProject.name}")
        developerConnection.set("scm:git:ssh://github.com/rahulsom/${rootProject.name}.git")
        url.set("https://github.com/rahulsom/${rootProject.name}")
      }
    }
  }
}

configure<PublishingExtension> {
  repositories {
    maven {
      name = "local"
      val releasesRepoUrl = "${rootProject.buildDir}/repos/releases"
      val snapshotsRepoUrl = "${rootProject.buildDir}/repos/snapshots"
      url = file(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl).toURI()
    }
  }
}

rootProject.tasks.getByPath("release").dependsOn(":${project.name}:publish")
rootProject.tasks.getByPath("closeAndReleaseRepository").mustRunAfter(":${project.name}:publish")
