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


    val allInvalidIds = invalidIds.sumOf { it.second.sum() }
    return allInvalidIds
  }

  override fun task2(input: String): Long {
    val idRanges = input.trim()
      .split(",")
      .map { it.trim().split("-") }
      // None of the IDs has leading zeroes, meaning we can directly convert it to ints
      .map { it[0].toLong() to it[1].toLong() }

    val invalidIds = idRanges
      .map { (start, end) -> start..end }
      .map { it to it.flatMap { id -> isInvalidDetailed(id) } }

    println("All repeatedIds:\n$invalidIds")

    val answer = invalidIds.sumOf { it.second.sum() }


    return answer
  }

  private fun isInvalidDetailed(id: Long): Set<Long> {
    println("ID: $id")
    val idString = id.toString()

    if (idString.length < 2) {
      return emptySet()
    }

    val halfSize = ceil(idString.length.toDouble() / 2).toInt() + 1

    // Only need to check up to half the id,
    // because a sub-string cannot repeat when the first half is larger than the second half.
    val repeatedIds = (1..halfSize)
      .map { end -> idString.take(end) }
      .mapNotNull { subId ->
        println(subId)

        if (subId.length == idString.length && !isInvalid(subId.toLong())) {
          return@mapNotNull null
        }

        val possibleRepeats = ceil(idString.length.toDouble() / subId.length).toInt()
        val repeatedSubId = subId.repeat(possibleRepeats)

        println("\tID: $id == ${subId.repeat(possibleRepeats)}")
        repeatedSubId == idString

        if (repeatedSubId == idString) {
          repeatedSubId
        } else {
          null
        }
      }
      .map { it.toLong() }

    println("\tRepeated: $repeatedIds")
    return repeatedIds.toSet()
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
