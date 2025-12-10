plugins {
  kotlin("jvm") version "2.1.0"
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
  jvmToolchain(21)
}
