package io.lindhagen.aoc.utils

object InputUtils {
  fun String.asNewLines(delimiter: String = "\n") = this
    .trim()
    .split(delimiter)

  fun readDayInput(name: String): String {
    val fileName = "/days/$name.txt"
    return this::class.java
      .getResourceAsStream(fileName)
      ?.bufferedReader(Charsets.UTF_8)
      ?.readText()
      ?: throw IllegalArgumentException("Cannot find file with name: $fileName")
  }
}
