package io.lindhagen.aoc.aoc2023.day9

import io.lindhagen.aoc.aoc2023.BaseTest
import io.lindhagen.aoc.aoc2023.Task

internal class Day9Test : BaseTest<Long> {
  override val tester = Day9

  override val sample = Task(
    input = """
      """.trimIndent(),
    task1 = 1343L,
    task2 = 5905L,
  )
  override val actual = Task(
    input = "day9",
    task1 = 250232501L,
    task2 = 9881048L,
  )
}
