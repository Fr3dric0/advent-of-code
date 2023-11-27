package io.lindhagen.aoc.aoc2022.day6

import io.lindhagen.aoc.aoc2022.BaseTest
import io.lindhagen.aoc.aoc2022.Task

internal class Day6Test : BaseTest<Int> {
  override val tester = Day6

  override val sample = Task(
    input = """
    mjqjpqmgbljsphdztnvjfqwrcgsmlb
    """.trimIndent(),
    task1 = 7,
    task2 = 19,
  )
  override val actual = Task(
    input = "day6/input1",
    task1 = 1343,
    task2 = 2193,
  )
}

