val koin_version = "2.2.3"
val junit_version = "4.13.1"
val mockk_version = "1.10.0"

plugins {
    kotlin("jvm") version "1.5.0"
}

repositories{
    mavenLocal()
    mavenCentral()
    jcenter()
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs = freeCompilerArgs + "-Xopt-in=org.koin.core.component.KoinApiExtension"
    }
}

dependencies {
    implementation("io.insert-koin:koin-core:$koin_version")

    testImplementation("io.insert-koin:koin-test:$koin_version")
    testImplementation("junit:junit:$junit_version")
    testImplementation("io.mockk:mockk:$mockk_version")
}

tasks.withType<Jar> {
    manifest {
        attributes("Main-Class" to "Main")
    }
    from(configurations.compileClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
}
