import com.github.rahulsom.waena.WaenaExtension

plugins {
  id("com.github.rahulsom.waena.root") version "0.17.0"
}

allprojects {
  group = "io.github.rahulsom"
}

waena {
  license.set(WaenaExtension.License.Apache2)
  publishMode.set(WaenaExtension.PublishMode.Central)
}
