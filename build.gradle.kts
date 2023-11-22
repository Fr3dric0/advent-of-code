plugins {
  kotlin("jvm") version "1.9.20"
  application
}

group = "io.lindhagen.aoc"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

dependencies {
  testImplementation(kotlin("test"))
  testImplementation("io.strikt:strikt-core:0.34.0")
}

tasks.test {
  useJUnitPlatform()
}

kotlin {
  jvmToolchain(8)
}

application {
  mainClass.set("io.lindhagen.aoc.aoc2022.MainKt")
}
