package com.github.rahulsom.waena

import de.marcphilipp.gradle.nexus.NexusPublishExtension
import nebula.plugin.release.ReleasePlugin
import io.codearte.gradle.nexus.NexusStagingPlugin
import io.codearte.gradle.nexus.NexusStagingExtension
import de.marcphilipp.gradle.nexus.NexusPublishPlugin
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import java.time.Duration

open class WaenaRootPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    if (target.rootProject != target) {
      throw GradleException("WaenaRoot can only be applied to a root project")
    }
    target.plugins.apply("signing")
    target.plugins.apply(ReleasePlugin::class.java)
    target.plugins.apply(NexusStagingPlugin::class.java)

    target.allprojects {
      this.plugins.apply(NexusPublishPlugin::class.java)

      this.configure<NexusPublishExtension> {
        repositories {
          sonatype()
        }
        connectTimeout.set(Duration.ofMinutes(3))
        clientTimeout.set(Duration.ofMinutes(3))
      }
    }

    target.configure<NexusStagingExtension>() {
      username = target.findProperty("sonatypeUsername") as String
      password = target.findProperty("sonatypePassword") as String
      repositoryDescription = "Release ${target.group} ${target.version}"
    }

    listOf("candidate", "final").forEach {
      target.tasks.getByPath(it).dependsOn("closeAndReleaseRepository")
    }

  }
}
