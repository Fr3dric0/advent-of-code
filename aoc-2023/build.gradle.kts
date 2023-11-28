plugins {
  kotlin("jvm") version "1.9.20"
  application
}

version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  implementation(project(":common"))
  testImplementation(kotlin("test"))
  testImplementation("io.strikt:strikt-core:0.34.0")
}

application {
  mainClass.set("io.lindhagen.aoc.aoc2022.MainKt")
}

kotlin {
  jvmToolchain(8)
}
