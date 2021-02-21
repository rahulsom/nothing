package com.github.rahulsom.waena

import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.property

open class WaenaExtension(project: Project) {
  var githubUserOrOrg: Property<String> = project.objects.property<String>().apply {
    set("rahulsom")
  }
  var githubRepository: Property<String> = project.objects.property<String>().apply {
    set(project.name)
  }
}
