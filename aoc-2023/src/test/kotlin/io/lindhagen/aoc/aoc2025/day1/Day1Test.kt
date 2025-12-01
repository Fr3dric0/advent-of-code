package io.lindhagen.aoc.aoc2025.day1

import io.lindhagen.aoc.aoc2025.BaseTest
import io.lindhagen.aoc.aoc2025.Task


internal class Day1Test : BaseTest<Int> {
    override val tester = Day1

    override val sample = Task(
      input = """
      two1nine
      eightwothree
      abcone2threexyz
      xtwone3four
      4nineeightseven2
      zoneight234
      7pqrstsixteen
      """.trimIndent(),
      task1 = 209,
      task2 = 281,
    )
    override val actual = Task(
      input = "day1",
      task1 = 52974,
      task2 = 53340,
    )
}
