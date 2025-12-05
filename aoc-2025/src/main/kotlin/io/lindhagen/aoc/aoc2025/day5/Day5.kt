package io.lindhagen.aoc.aoc2025.day5

import io.lindhagen.aoc.utils.BaseDay

/**
 * https://adventofcode.com/2025/day/3
 * */
internal object Day5 : BaseDay<Long> {
  override fun task1(input: String): Long {
    val collections = input.trim().split("\n\n")

    val freshIngredients = collections.first().trim()
      .lines()
      .map { it.split("-") }
      .map { it.first().toLong() to it.last().toLong() }
      .map { (it.first..it.second) }

    val availableIngredients = collections.last().trim()
      .lines()
      .map { it.toLong() }

    println(freshIngredients)

    println(availableIngredients)

    val nonSpoiled  = availableIngredients.filter { ingredient ->
      freshIngredients.any { ingredient in it }
    }

    println(nonSpoiled)

    return nonSpoiled.size.toLong()
  }

  override fun task2(input: String): Long {
    return 0
  }
}
