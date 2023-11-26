package io.lindhagen.aoc.aoc2022.day5

import io.lindhagen.aoc.sample.BaseDay

@JvmInline
value class Stack(val stack: MutableList<String>) {
  fun pop(): String {
    return stack.removeLast()
  }
  fun add(item: String) {
    stack.add(item)
  }

  fun peek(): String? = stack.lastOrNull()
}

@JvmInline
value class Stacks(val stacks: List<Stack>) {
  fun move(fromStack: Int, toStack: Int, count: Int) {
    println("Command: move $count from ${fromStack + 1} to ${toStack + 1}...")
    (0..<count).map {
      val item = stacks[fromStack].pop()
      println("\t${it + 1}) moving $item from ${stacks[fromStack]} to ${stacks[toStack]}")
      stacks[toStack].add(item)
    }
  }

  fun print() {
    println()
    stacks.forEachIndexed { index, stack ->
      println("${index + 1} : ${stack.stack.joinToString(" | ")} |")
    }
  }

  fun itemsAtTop(): List<String> {
    return stacks.mapNotNull { it.peek() }
  }
}

internal object Day5 : BaseDay<String> {
  override fun task1(input: String): String {
    val (stacksRaw, movesRaw) = input.split("\n\n")

    val stacks = createMatrix(stacksRaw)
      // Rotate so each row is equivalent to a stack
      .transpose()
      .also { println(it) }
      // Remove any placeholder whitespaces since we don't
      // need them anymore
      .map { it.filter { it.isNotEmpty() } }
      .map { Stack(it.reversed().toMutableList()) }
      .let { Stacks(it) }

    val moves = parseMoves(movesRaw.split("\n"))

    moves.forEach { (count, moveFrom, moveTo) ->
      stacks.move(fromStack = moveFrom - 1, toStack = moveTo - 1, count = count)
      stacks.print()
    }

    return stacks.itemsAtTop().joinToString("")
  }

  override fun task2(input: String): String {
    TODO("Not yet implemented")
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

  private fun List<List<String>>.transpose() : List<List<String>> {
    val rows = this.size
    val columns = this[0].size

    val transposedMatrix = Array(columns) { Array(rows) { "" } }

    for (row in 0..<rows) {
      for (column in 0..<columns) {
        transposedMatrix[column][row] = this[row][column]
      }
    }

    return transposedMatrix
      .toList()
      .map { it.toList() }
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
