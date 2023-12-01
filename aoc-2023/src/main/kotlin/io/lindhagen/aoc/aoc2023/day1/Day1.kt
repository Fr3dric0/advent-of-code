package io.lindhagen.aoc.aoc2023.day1

import io.lindhagen.aoc.utils.BaseDay

/**
 * https://adventofcode.com/2023/day/1
 * */
internal object Day1 : BaseDay<Int> {
  override fun task1(input: String): Int {
    return input
      .trim()
      .lines()
      .mapNotNull {
        val digits = it.toList().filter(Char::isDigit)
        println("$it $digits")

        if (digits.isEmpty()) {
          null
        } else {
          "${digits.first()}${digits.last()}"
        }
      }
      .also { println(it) }
      .sumOf { it.toInt() }
  }

  override fun task2(input: String): Int {
    return input
      .trim()
      .lines()
      .map(::parseDigits)
      .sum()
  }

  private fun parseDigits(line: String): Int {
    val digitsInLine = LineParser.parseDigits(line)

    val firstDigit = digitsInLine.first().second
    val lastDigit = digitsInLine.last().second

    return "$firstDigit$lastDigit".toInt()
  }
}
