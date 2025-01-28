import nebula.plugin.contacts.Contact
import nebula.plugin.contacts.ContactsExtension

plugins {
  id("com.github.rahulsom.waena.root") version "0.9.2"
}

allprojects {
  group = "io.github.rahulsom"
}

configure<ContactsExtension> {
  validateEmails = true
  addPerson("rahulsom@noreply.github.com", delegateClosureOf<Contact> {
    moniker("Rahul Somasunderam")
    roles("owner")
    github("https://github.com/rahulsom")
  })
}

waena {
  useCentralPortal.set(true)
}
