plugins {
    id("com.gradle.develocity") version "3.18.1"
}

develocity {
    buildScan {
        termsOfUseUrl.set("https://gradle.com/terms-of-service")
        termsOfUseAgree.set("yes")
        buildScanPublished {
            file("build").mkdirs()
            file("build/gradle-scan.md").writeText(
                """Gradle Build Scan - [`${this.buildScanId}`](${this.buildScanUri})"""
            )
        }
    }
}

rootProject.name = "nothing"

include("nothing-java", "nothing-groovy", "nothing-kotlin", "nothing-internal")
