plugins {
  id("com.github.rahulsom.waena.root") version "0.2.1"
}

import com.github.rahulsom.waena.WaenaExtension
import com.github.rahulsom.waena.WaenaRootPlugin
import nebula.plugin.contacts.ContactsExtension
import nebula.plugin.contacts.Contact

allprojects {
  group = "com.github.rahulsom"
}

configure<ContactsExtension> {
  validateEmails = true
  addPerson("rahulsom@noreply.github.com", delegateClosureOf<Contact>({
    moniker("Rahul Somasunderam")
    roles("owner")
    github("https://github.com/rahulsom")
  }))
}

gradleEnterprise {
  buildScan {
    termsOfServiceUrl = "https://gradle.com/terms-of-service"
    termsOfServiceAgree = "yes"
    publishAlwaysIf(!System.getenv("CI").isNullOrEmpty())
  }
}
