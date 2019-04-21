allprojects {

    repositories {
        mavenCentral()
        jcenter()
        maven(url = "https://dl.bintray.com/arrow-kt/arrow-kt/")
        maven(url = "https://oss.jfrog.org/artifactory/oss-snapshot-local/")
    }

}

subprojects {
    version = "0.0.0-SNAPSHOT"
}
