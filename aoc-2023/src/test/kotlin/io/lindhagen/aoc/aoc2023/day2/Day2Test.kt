package io.lindhagen.aoc.aoc2023.day2

import io.lindhagen.aoc.aoc2023.BaseTest
import io.lindhagen.aoc.aoc2023.Task

internal class Day2Test : BaseTest<Int> {
  override val tester = Day2

  override val sample = Task(
    input = """
      Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
      Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
      Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
      Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
      Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
      """.trimIndent(),
    task1 = 8,
    task2 = 281,
  )
  override val actual = Task(
    input = "day2",
    task1 = 52974,
    task2 = 53340,
  )
}
