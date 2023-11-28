plugins {
  kotlin("jvm") version "1.9.20"
  application
}

group = "io.lindhagen.aoc"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
}

allprojects {
  group = "io.lindhagen.aoc"

  tasks.withType<Test> {
    useJUnitPlatform()
  }
}
