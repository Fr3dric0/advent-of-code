package io.lindhagen.aoc.aoc2025.day6

import io.lindhagen.aoc.aoc2025.BaseTest
import io.lindhagen.aoc.aoc2025.Task


internal class Day6Test : BaseTest<Long> {
    override val tester = Day6

    override val sample = Task(
      input = """
      123 328  51 64 
       45 64  387 23 
        6 98  215 314
      *   +   *   +  
      """.trimIndent().trimMargin(),
      task1 = 4277556L,
      task2 = 14L,
    )
    override val actual = Task(
      input = "day6",
      task1 = 5782351442566L,
      task2 = 8948L,
    )
}
