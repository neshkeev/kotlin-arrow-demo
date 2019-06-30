plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin on the JVM.
    id("org.jetbrains.kotlin.jvm").version("1.3.20")
    id("org.jetbrains.kotlin.kapt").version("1.3.30")

}


val arrow_version = "0.9.1-SNAPSHOT"

dependencies {
    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("io.arrow-kt:arrow-core-data:$arrow_version")
    implementation("io.arrow-kt:arrow-core-extensions:$arrow_version")
    implementation("io.arrow-kt:arrow-syntax:$arrow_version")
    implementation("io.arrow-kt:arrow-typeclasses:$arrow_version")
    implementation("io.arrow-kt:arrow-extras-data:$arrow_version")
    implementation("io.arrow-kt:arrow-extras-extensions:$arrow_version")
    kapt("io.arrow-kt:arrow-meta:$arrow_version")

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")
}
