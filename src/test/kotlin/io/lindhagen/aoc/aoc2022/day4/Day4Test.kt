package io.lindhagen.aoc.aoc2022.day4

import io.lindhagen.aoc.aoc2022.BaseTest
import io.lindhagen.aoc.aoc2022.Task

internal class Day4Test : BaseTest {
  override val tester = Day4

  override val sample = Task(
    input = """
    2-4,6-8
    2-3,4-5
    5-7,7-9
    2-8,3-7
    6-6,4-6
    2-6,4-8
    """.trimIndent(),
    task1 = 2,
    task2 = 4,
  )
  override val actual = Task(
    input = "day4/input1",
    task1 = 431,
    task2 = 823,
  )
}
