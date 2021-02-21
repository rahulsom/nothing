import com.github.rahulsom.waena.WaenaExtension
import com.github.rahulsom.waena.WaenaRootPlugin

apply {
  plugin<WaenaRootPlugin>()
}

allprojects {
  group = "com.github.rahulsom"
}

configure<WaenaExtension> {
  githubUserOrOrg.set("rahulsom")
  githubRepository.set("nothing")
}
