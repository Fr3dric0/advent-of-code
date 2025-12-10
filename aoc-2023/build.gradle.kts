plugins {
  kotlin("jvm") version "2.1.0"
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

  testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.1")
}

application {
  mainClass.set("io.lindhagen.aoc.aoc2022.MainKt")
}

kotlin {
  jvmToolchain(21)
}
