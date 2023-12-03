package io.lindhagen.aoc.aoc2023.day3

import io.lindhagen.aoc.utils.BaseDay

data class Point(
  val x: Int,
  val y: Int,
)

data class Item<T>(val left: Point, val right: Point, val value: T)

internal object Day3 : BaseDay<Int> {
  override fun task1(input: String): Int {
    val partNumbers = input
      .trim()
      .lines()
      .let { findPartNumbers(it) }

    println(partNumbers)
    return partNumbers
      .sumOf { it.value.toInt() }
  }

  override fun task2(input: String): Int {
    input.lines()
    return 0
  }

  private fun findPartNumbers(lines: List<String>): List<Item<String>> {
    val symbols = "[^\\w\\d.]".toRegex()
      .findAll(lines.joinToString("\n"))
      .map { it.value }
      .filter { it.isNotEmpty() }
      .toSet()

    val numbers = lines
      .flatMapIndexed { index, line ->
        numberPosition(line)
          .map {
            Item(
              left = Point(x = it.first, y = index),
              right = Point(x = it.second, y = index),
              value = it.third,
            )
          }
      }

    val (adjacent, notAdjacent) = numbers
      .partition { isAdjacentToSymbols(lines, it, symbols) }

    println()
    println("Not Adjacent: $notAdjacent")
    println("Symbols: $symbols")
    return adjacent
  }

  private fun isAdjacentToSymbols(lines: List<String>, number: Item<*>, knownSymbols: Set<String>): Boolean {
    val currentY = number.left.y
    val topY = if (currentY - 1 >= 0) currentY - 1 else null
    val bottomY = if (currentY + 1 < lines.size) currentY + 1 else null

    val startX = if (number.left.x > 0) number.left.x - 1 else number.left.x
    val endX = if (number.right.x < (lines[0].length - 1)) number.right.x + 1 else number.right.x

    println("number=${number.value} ($startX, $endX)")

    return listOfNotNull(topY, currentY, bottomY)
      .map {
        val line = lines[it].toList()
        val adjacent = line.subList(startX, endX + 1)
        println("\t\t$adjacent")

        adjacent
          .any { knownSymbols.contains(it.toString()) }
      }
      .also { println("\t $it") }
      .any { it }
  }

  private fun numberPosition(line: String): List<Triple<Int, Int, String>> {
    return "\\d+"
      .toRegex()
      .findAll(line)
      .map {
        Triple(it.range.first, it.range.last, it.value)
      }.toList()
  }
}
