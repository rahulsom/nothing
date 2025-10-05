import com.github.rahulsom.waena.WaenaExtension
import nebula.plugin.contacts.Contact

plugins {
  id("com.github.rahulsom.waena.root") version "0.19.0"
}

allprojects {
  group = "io.github.rahulsom"
}

contacts {
  validateEmails = true
  addPerson("rahulsom@noreply.github.com", delegateClosureOf<Contact> {
    moniker("Rahul Somasunderam")
    roles("owner")
    github("https://github.com/rahulsom")
  })
}

waena {
  license.set(WaenaExtension.License.Apache2)
  publishMode.set(WaenaExtension.PublishMode.Central)
}
