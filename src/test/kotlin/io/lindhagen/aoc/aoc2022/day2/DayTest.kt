package io.lindhagen.aoc.aoc2022.day2

import io.lindhagen.aoc.aoc2022.BaseTest
import io.lindhagen.aoc.aoc2022.Task
import io.lindhagen.aoc.sample.BaseDay

internal class DayTest : BaseTest {
  override val sample = Task(
    input = """
      A Y
      B X
      C Z
    """.trimIndent(),
    task1 = 15,
    task2 = 12,
  )
  override val actual = Task(
    input = "day2/input1",
    task1 = 11063,
    task2 = 10349,
  )

  override val tester: BaseDay = Day
}
