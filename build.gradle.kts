plugins {
  kotlin("jvm") version "2.2.21" apply false
  application
}

group = "io.lindhagen.aoc"
version = "1.0-SNAPSHOT"

allprojects {
  group = "io.lindhagen.aoc"

  tasks.withType<Test> {
    useJUnitPlatform()
    minHeapSize = "512m"
    maxHeapSize = "2048m"
    jvmArgs = emptyList()
  }
}

subprojects {
  apply(plugin = "org.jetbrains.kotlin.jvm")

  repositories {
    mavenCentral()
  }

  configure<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension> {
    jvmToolchain(21)
  }
}
