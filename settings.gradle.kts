plugins {
    id("com.gradle.develocity") version "4.6.0"
}

develocity {
    buildScan {
        termsOfUseUrl.set("https://gradle.com/terms-of-service")
        termsOfUseAgree.set("yes")
    }
}

rootProject.name = "nothing"

include("nothing-java", "nothing-groovy", "nothing-kotlin", "nothing-internal")
