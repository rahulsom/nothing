package com.github.rahulsom.waena

import de.marcphilipp.gradle.nexus.NexusPublishExtension
import de.marcphilipp.gradle.nexus.NexusPublishPlugin
import io.codearte.gradle.nexus.NexusStagingExtension
import io.codearte.gradle.nexus.NexusStagingPlugin
import nebula.plugin.release.ReleasePlugin
import org.gradle.api.GradleException
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import java.time.Duration
import nebula.plugin.contacts.ContactsPlugin

class WaenaRootPlugin : Plugin<Project> {
  override fun apply(target: Project) {
    if (target.rootProject != target) {
      throw GradleException("WaenaRoot can only be applied to a root project")
    }
    configureRootProject(target)
  }

  private fun configureRootProject(rootProject: Project) {
    rootProject.plugins.apply("signing")
    rootProject.plugins.apply(ReleasePlugin::class.java)
    rootProject.plugins.apply(NexusStagingPlugin::class.java)

    val waenaExtension = rootProject.extensions.create("waena", WaenaExtension::class.java, rootProject)

    rootProject.allprojects.forEach { target ->
      target.plugins.apply<NexusPublishPlugin>(NexusPublishPlugin::class.java)
      target.plugins.apply(ContactsPlugin::class.java)

      target.configure<NexusPublishExtension> {
        repositories {
          sonatype()
        }
        connectTimeout.set(Duration.ofMinutes(3))
        clientTimeout.set(Duration.ofMinutes(3))
      }

    }

    rootProject.configure<NexusStagingExtension>() {
      username = rootProject.findProperty("sonatypeUsername") as String
      password = rootProject.findProperty("sonatypePassword") as String
      repositoryDescription = "Release ${rootProject.group} ${rootProject.version}"
    }

    listOf("candidate", "final").forEach {
      rootProject.tasks.getByPath(it).dependsOn("closeAndReleaseRepository")
    }
  }

}
