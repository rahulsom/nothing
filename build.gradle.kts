import nebula.plugin.contacts.Contact
import nebula.plugin.contacts.ContactsExtension
import com.github.rahulsom.waena.WaenaExtension

plugins {
  id("com.github.rahulsom.waena.root") version "0.9.3"
}

//// Option 1
//allprojects {
//  group = "com.github.rahulsom"
//}
//waena {
//  repositoryConfig.set(WaenaExtension.PublishMode.OSS)
//}

// Option 2
allprojects {
  group = "io.github.rahulsom"
}
waena {
  publishMode.set(WaenaExtension.PublishMode.Central)
}

configure<ContactsExtension> {
  validateEmails = true
  addPerson("rahulsom@noreply.github.com", delegateClosureOf<Contact> {
    moniker("Rahul Somasunderam")
    roles("owner")
    github("https://github.com/rahulsom")
  })
}

