package io.lindhagen.aoc.aoc2023.day4

import io.lindhagen.aoc.utils.BaseDay

internal object Day4 : BaseDay<Int> {
  override fun task1(input: String): Int {
    return input
      .trim()
      .lines()
      .map {
        val (name, numbers) = it.split(":")

        name.trim() to numbers
          .trim()
          .split("|")
          .map { it.trim().split(" ").filter { it.isNotEmpty() } }
      }
      .map { (name, numbers) ->
        val (winnerNumbers, playerNumbers) = numbers.map { it.map { it.toInt() } }

        println("$winnerNumbers $playerNumbers")

        val common = winnerNumbers.toSet().intersect(playerNumbers.toSet())
        println("\t$common")

        common.fold(0) { agg, _ ->
          if (agg == 0) {
            1
          } else {
            agg + agg
          }
        }
          .also { println("\t$it") }
      }.sum()
  }

  override fun task2(input: String): Int {
    TODO("Not yet implemented")
  }
}
