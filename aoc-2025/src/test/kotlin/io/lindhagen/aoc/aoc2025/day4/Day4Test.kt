package io.lindhagen.aoc.aoc2025.day4

import io.lindhagen.aoc.aoc2025.BaseTest
import io.lindhagen.aoc.aoc2025.Task


internal class Day4Test : BaseTest<Long> {
    override val tester = Day4

    override val sample = Task(
      input = """
      ..@@.@@@@.
      @@@.@.@.@@
      @@@@@.@.@@
      @.@@@@..@.
      @@.@@@@.@@
      .@@@@@@@.@
      .@.@.@.@@@
      @.@@@.@@@@
      .@@@@@@@@.
      @.@.@@@.@.
      """.trimIndent().trimMargin(),
      task1 = 13L,
      task2 = 43L,
    )
    override val actual = Task(
      input = "day4",
      task1 = 1547L,
      task2 = 8948L,
    )
}
