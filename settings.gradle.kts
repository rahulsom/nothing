import com.gradle.scan.plugin.PublishedBuildScan

plugins {
    id("com.gradle.enterprise").version("3.17")
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
        publishAlways()
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
