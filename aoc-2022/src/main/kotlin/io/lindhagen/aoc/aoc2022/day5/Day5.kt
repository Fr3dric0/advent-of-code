package io.lindhagen.aoc.aoc2022.day5

import io.lindhagen.aoc.sample.BaseDay
import io.lindhagen.aoc.utils.ListUtils.transpose
import io.lindhagen.aoc.utils.SimpleStack
import io.lindhagen.aoc.utils.SimpleStackCollection

internal object Day5 : BaseDay<String> {
  override fun task1(input: String): String {
    val (stacksRaw, movesRaw) = input.split("\n\n")
    val stacks = stacksFromMatrix(createMatrix(stacksRaw))

    val moves = parseMoves(movesRaw.split("\n"))

    moves.forEach { (count, moveFrom, moveTo) ->
      stacks.move(fromStack = moveFrom - 1, toStack = moveTo - 1, count = count)
      stacks.print()
    }

    return stacks.itemsAtTop().joinToString("")
  }

  override fun task2(input: String): String {
    val (stacksRaw, movesRaw) = input.split("\n\n")

    val stacks = stacksFromMatrix(createMatrix(stacksRaw))
    val moves = parseMoves(movesRaw.split("\n"))

    moves.forEach { (count, moveFrom, moveTo) ->
      stacks.moveBatch(fromStack = moveFrom - 1, toStack = moveTo - 1, count = count)
      stacks.print()
    }

    return stacks.itemsAtTop().joinToString("")
  }

  private fun stacksFromMatrix(matrix: List<List<String>>): SimpleStackCollection {
    return matrix
      // Rotate so each row is equivalent to a stack
      .transpose()
      .also { println(it) }
      // Remove any placeholder whitespaces since we don't
      // need them anymore
      .map { it.filter { it.isNotEmpty() } }
      .map { SimpleStack(it.reversed().toMutableList()) }
      .let { SimpleStackCollection(it) }
  }

  private fun createMatrix(stacks: String): List<List<String>> {
    val rows = stacks.split("\n").toMutableList()

    val stackIds = rows
      .removeLast()
      .split(" ")
      .map(String::trim)
      .filter(String::isNotEmpty)
      .map(String::toInt)

    val columnCount = stackIds.size

    val matrix = rows
      .map { line ->
        line
          // Empty columns are delimited using 4 white-spaces
          .replace("    ", "_")
          .split("_")
          .flatMap { it.split(" ") }
          .map {
            it
              .trim()
              .replace("[", "")
              .replace("]", "")
          }
      }
      .map { it.padRight(columnCount) }

    // Print for our own help
    matrix.forEach { row ->
      row.forEach { element -> print("\t$element\t|") }
      println()
    }

    return matrix
  }

  private fun List<String>.padRight(size: Int, value: String = ""): List<String> {
    val sizeDiff = size - this.size
    if (sizeDiff <= 0) {
      return this
    }

    return this + (0..<sizeDiff).map { value }
  }

  private fun parseMoves(moves: List<String>): List<Triple<Int, Int, Int>> {
    return moves
      .map { "\\d+".toRegex().findAll(it).map { it.value }.toList() }
      .filter { it.isNotEmpty() }
      .map {
        val commands = it.map { it.toInt() }
        Triple(commands[0], commands[1], commands[2])
      }
  }
}
