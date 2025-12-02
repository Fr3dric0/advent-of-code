package io.lindhagen.aoc.aoc2025.day2

import io.lindhagen.aoc.utils.BaseDay
import kotlin.math.abs
import kotlin.math.ceil

/**
 * https://adventofcode.com/2025/day/2
 * */
internal object Day2 : BaseDay<Long> {
  override fun task1(input: String): Long {
    val idRanges = input.trim()
      .split(",")
      .map { it.trim().split("-") }
      // None of the IDs has leading zeroes, meaning we can directly convert it to ints
      .map { it[0].toLong() to it[1].toLong() }

    val invalidIds = idRanges
      .map { (start, end) -> start..end }
      .map { it to it.filter { id -> isInvalid(id) } }

    println(invalidIds)
    val allInvalidIds = invalidIds.sumOf { it.second.sum() }
    return allInvalidIds
  }

  override fun task2(input: String): Long {
    return 0
  }

  private fun isInvalid(id: Long): Boolean {
    val idString = id.toString()
    if (idString.length % 2 == 1) {
      // The number has length of odd number: 1, 3, 6, ...
      // Therefore, it cannot contain a number repeated twice, and hence cannot be invalid
      return false
    }

    val halfSize = idString.length / 2
    val firstComponent = idString.take(halfSize)
    val secondComponent = idString.substring(halfSize)
//    println("ID ($id) becomes $firstComponent = $secondComponent")

    if (firstComponent == secondComponent) {
      println("ID ($id) is invalid $firstComponent = $secondComponent")
    }
    return firstComponent == secondComponent
  }
}
