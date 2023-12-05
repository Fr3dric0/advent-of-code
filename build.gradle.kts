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
    minHeapSize = "512m"
    maxHeapSize = "2048m"
    jvmArgs = listOf("-XX:MaxPermSize=1024m")
  }
}
