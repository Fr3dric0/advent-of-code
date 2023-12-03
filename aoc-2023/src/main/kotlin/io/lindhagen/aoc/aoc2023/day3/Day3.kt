package io.lindhagen.aoc.aoc2023.day3

import io.lindhagen.aoc.utils.BaseDay
import io.lindhagen.aoc.utils.ListUtils.multiply

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
    return input
      .lines()
      .let { lines -> findGears(lines) }
      .sum()
  }

  private fun findGears(lines: List<String>): List<Int> {
    val positions = lines
      .flatMapIndexed { index: Int, line: String -> gearPositions(line, index) }

    println(positions)

    return positions
      .map { findAdjacentNumbers(lines, it) }
      .filter { it.size >= 2 }
      .map { it.map { it.toInt() }.multiply() }
  }

  private fun findAdjacentNumbers(lines: List<String>, item: Item<*>): List<String> {
    val currentY = item.left.y
    val topY = if (currentY - 1 >= 0) currentY - 1 else null
    val bottomY = if (currentY + 1 < lines.size) currentY + 1 else null

    val startX = if (item.left.x > 0) item.left.x - 1 else item.left.x
    val endX = if (item.right.x < (lines[0].length - 1)) item.right.x + 1 else item.right.x

    return listOfNotNull(topY, currentY, bottomY)
      .flatMap {
        val line = lines[it]

        val numbers = "\\d+".toRegex()
          .findAll(line)
          .map { it.range to it.value }
          .toList()

        numbers
          .filter {
            val range = it.first
            val outsideRange = (range.last < startX) || (range.first > endX)
            !outsideRange
          }
      }
      .map { it.second }
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
    return adjacent
  }

  private fun isAdjacentToSymbols(lines: List<String>, number: Item<*>, knownSymbols: Set<String>): Boolean {
    val currentY = number.left.y
    val topY = if (currentY - 1 >= 0) currentY - 1 else null
    val bottomY = if (currentY + 1 < lines.size) currentY + 1 else null

    val startX = if (number.left.x > 0) number.left.x - 1 else number.left.x
    val endX = if (number.right.x < (lines[0].length - 1)) number.right.x + 1 else number.right.x

    return listOfNotNull(topY, currentY, bottomY)
      .map {
        val line = lines[it].toList()
        val adjacent = line.subList(startX, endX + 1)

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
      .map { Triple(it.range.first, it.range.last, it.value) }
      .toList()
  }

  private fun gearPositions(line: String, lineNumber: Int): List<Item<String>> {
    return "\\*"
      .toRegex()
      .findAll(line)
      .map { Item(
        left = Point(x = it.range.first, y = lineNumber),
        right = Point(x = it.range.last, y = lineNumber),
        value = it.value,
      ) }
      .toList()
  }
}
