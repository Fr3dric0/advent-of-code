plugins {
  application
}

version = "1.0-SNAPSHOT"

dependencies {
  implementation(project(":common"))
  testImplementation(kotlin("test"))
  testImplementation("io.strikt:strikt-core:0.34.0")
  testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.1")
}

application {
  mainClass.set("io.lindhagen.aoc.aoc2023.MainKt")
}
