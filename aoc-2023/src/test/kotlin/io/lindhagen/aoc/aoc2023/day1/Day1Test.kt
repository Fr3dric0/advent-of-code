package io.lindhagen.aoc.aoc2023.day1

import io.lindhagen.aoc.aoc2023.BaseTest
import io.lindhagen.aoc.aoc2023.Task
import io.lindhagen.aoc.aoc2023.day1.Day1


internal class Day1Test : BaseTest<Int> {
    override val tester = Day1

    override val sample = Task(
      input = """
      """.trimIndent(),
      task1 = 157,
      task2 = 70,
    )
    override val actual = Task(
      input = "day1",
      task1 = 8202,
      task2 = 2864,
    )
}
