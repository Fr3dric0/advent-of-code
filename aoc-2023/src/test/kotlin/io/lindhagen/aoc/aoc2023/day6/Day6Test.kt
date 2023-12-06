package io.lindhagen.aoc.aoc2023.day6

import io.lindhagen.aoc.aoc2023.BaseTest
import io.lindhagen.aoc.aoc2023.Task

internal class Day6Test : BaseTest<Int> {
  override val tester = Day6

  override val sample = Task(
    input = """
      Time:      7  15   30
      Distance:  9  40  200
      """.trimIndent(),
    task1 = 288,
    task2 = 46,
  )
  override val actual = Task(
    input = "day6",
    task1 = 219849,
    task2 = 9881048,
  )
}
