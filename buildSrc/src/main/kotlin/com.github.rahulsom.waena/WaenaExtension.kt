package com.github.rahulsom.waena

import org.gradle.api.Project
import org.gradle.api.provider.Property
import org.gradle.kotlin.dsl.property

open class WaenaExtension(project: Project) {
  enum class License(val license: String, val url: String) {
    Apache2("The Apache License, Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0")
  }
  var license: Property<License> = project.objects.property<License>().apply {
    set(License.Apache2)
  }
}
