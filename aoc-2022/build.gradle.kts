plugins {
  application
}

version = "1.0-SNAPSHOT"

dependencies {
  implementation(project(":common"))
  testImplementation(kotlin("test"))
  testImplementation("io.strikt:strikt-core:0.34.0")
}

application {
  mainClass.set("io.lindhagen.aoc.aoc2022.MainKt")
}
