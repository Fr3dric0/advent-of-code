package io.lindhagen.aoc.aoc2025.day5

import io.lindhagen.aoc.aoc2025.BaseTest
import io.lindhagen.aoc.aoc2025.Task


internal class Day5Test : BaseTest<Long> {
    override val tester = Day5

    override val sample = Task(
      input = """
      3-5
      10-14
      16-20
      12-18
      
      1
      5
      8
      11
      17
      32
      """.trimIndent().trimMargin(),
      task1 = 3L,
      task2 = 14L,
    )
    override val actual = Task(
      input = "day5",
      task1 = 690L,
      task2 = 8948L,
    )
}
