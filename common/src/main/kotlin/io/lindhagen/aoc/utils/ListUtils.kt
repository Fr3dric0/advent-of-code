package io.lindhagen.aoc.utils

object ListUtils {

  fun List<String>.padRight(size: Int, value: String = ""): List<String> {
    val sizeDiff = size - this.size
    if (sizeDiff <= 0) {
      return this
    }

    return this + (0..<sizeDiff).map { value }
  }

  inline fun <reified T> List<List<T>>.transpose() : List<List<T>> {
    val rows = this.size
    val columns = this[0].size

    val transposedMatrix = Array(columns) { Array(rows) { this[0][0] } }

    for (row in 0..<rows) {
      for (column in 0..<columns) {
        transposedMatrix[column][row] = this[row][column]
      }
    }

    return transposedMatrix
      .toList()
      .map { it.toList() }
  }
}
