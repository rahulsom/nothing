package com.github.rahulsom.waena

import de.marcphilipp.gradle.nexus.NexusPublishPlugin
import nebula.plugin.release.ReleasePlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.api.publish.maven.plugins.MavenPublishPlugin
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType
import org.gradle.plugins.signing.SigningExtension

class WaenaPublishedPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    target.plugins.apply(NexusPublishPlugin::class.java)
    target.plugins.apply("signing")
    target.plugins.apply(ReleasePlugin::class.java)

    target.configure<PublishingExtension> {
      publications {
        create("maven", MavenPublication::class.java) {
          from(target.components.getByName("java"))
        }
      }
    }

    target.configure<JavaPluginExtension> {
      withJavadocJar()
      withSourcesJar()
    }

    val hasSigningKey = target.hasProperty("signing.keyId") || target.findProperty("signingKey") != null

    if (hasSigningKey) {
      signProject(target)
    }


    target.configure<PublishingExtension> {
      repositories {
        maven {
          name = "local"
          val releasesRepoUrl = "${target.rootProject.buildDir}/repos/releases"
          val snapshotsRepoUrl = "${target.rootProject.buildDir}/repos/snapshots"
          url = target.file(if (target.version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl).toURI()
        }
      }
    }

    val waenaExtension = target.rootProject.extensions.getByType(WaenaExtension::class.java)
    configurePom(target, waenaExtension)

    target.rootProject.tasks.getByPath("release").dependsOn(":${target.name}:publish")
    target.rootProject.tasks.getByPath("closeRepository").mustRunAfter(":${target.name}:publish")

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

  private fun configurePom(project: Project, waenaExtension: WaenaExtension) {
    val repoKey = "${waenaExtension.githubUserOrOrg.get()}/${waenaExtension.githubRepository.get()}"
    project.plugins.withType(MavenPublishPlugin::class.java).forEach {
      val publishing = project.extensions.getByType<PublishingExtension>()
      publishing.publications.withType(MavenPublication::class.java).forEach { mavenPublication ->
        mavenPublication.pom {
          name.set("${project.group}:${project.name}")
          description.set(name)
          url.set("https://github.com/$repoKey")
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
            connection.set("scm:git:https://github.com/$repoKey")
            developerConnection.set("scm:git:ssh://github.com/$repoKey.git")
            url.set("https://github.com/$repoKey")
          }
          issueManagement {
            this.system.set("github")
            this.url.set("https://github.com/$repoKey/issues")
          }
        }
      }
    }
  }

}
