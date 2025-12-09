package io.lindhagen.aoc.aoc2025.day8

import io.lindhagen.aoc.aoc2025.BaseTest
import io.lindhagen.aoc.aoc2025.Task


internal class Day8Test : BaseTest<Long> {
    override val tester = Day8

    override val sample = Task(
      input = """
      
      """.trimIndent().trimMargin(),
      task1 = 4277556L,
      task2 = 14L,
    )
    override val actual = Task(
      input = "day8",
      task1 = 5782351442566L,
      task2 = 8948L,
    )
}
