package io.lindhagen.aoc.aoc2022.day1

internal object Day {

  fun task1(input: String): Int {
    return input
      .trim()
      .split("\n\n")
      .map { it.trim().split("\n").map { it.trim() } }
      .map { it.map(String::toInt).sum() }
      .maxBy { it }
  }

  fun task2(input: String): Int {
    return input
      .trim()
      .split("\n\n")
      .map { it.trim().split("\n").map { it.trim() } }
      .map { it.map(String::toInt).sum() }
      .sortedDescending()
      .take(3)
      .sum()
  }
}
