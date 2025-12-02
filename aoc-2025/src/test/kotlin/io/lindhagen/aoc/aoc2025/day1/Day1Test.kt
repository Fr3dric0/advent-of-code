package io.lindhagen.aoc.aoc2025.day1

import io.lindhagen.aoc.aoc2025.BaseTest
import io.lindhagen.aoc.aoc2025.Task


internal class Day1Test : BaseTest<Int> {
    override val tester = Day1

    override val sample = Task(
      input = """
      L68
      L30
      R48
      L5
      R60
      L55
      L1
      L99
      R14
      L82
      """.trimIndent(),
      task1 = 3,
      task2 = 6,
    )
    override val actual = Task(
      input = "day1",
      task1 = 1036,
      task2 = 53340,
    )
}
