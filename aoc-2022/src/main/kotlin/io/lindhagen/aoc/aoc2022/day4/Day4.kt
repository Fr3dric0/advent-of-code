package io.lindhagen.aoc.aoc2022.day4

import io.lindhagen.aoc.sample.BaseDay

object Day4 : BaseDay<Int> {
  override fun task1(input: String): Int {
    val pairs = input.trim()
      .split("\n")
      .map { it.split(",") }
      .map {
        it.map {
          val sections = it.split("-")
          (sections[0].toInt()..sections[1].toInt())
        }
      }
      .map { it[0] to it[1] }

    return pairs
      .filter { isFullyContained(it.first, it.second) || isFullyContained(it.second, it.first) }
      .size
  }

  override fun task2(input: String): Int {
    val pairs = input.trim()
      .split("\n")
      .map { it.split(",") }
      .map {
        it.map {
          val sections = it.split("-")
          (sections[0].toInt()..sections[1].toInt())
        }
      }
      .map { it[0] to it[1] }

    return pairs
      .map { (first, second) ->
        first.toSet().intersect(second.toSet())
      }
      .filter { it.isNotEmpty() }
      .size
  }

  private fun isFullyContained(comparing: IntRange, comparedTo: IntRange): Boolean {
    return comparing.first >= comparedTo.first && comparing.last <= comparedTo.last
  }
}
