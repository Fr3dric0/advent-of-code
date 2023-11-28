plugins {
  kotlin("jvm") version "1.9.20"
  application
}

version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(kotlin("test"))
  testImplementation("io.strikt:strikt-core:0.34.0")
}

kotlin {
  jvmToolchain(8)
}
