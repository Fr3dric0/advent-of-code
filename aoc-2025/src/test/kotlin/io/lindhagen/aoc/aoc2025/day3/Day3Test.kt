package io.lindhagen.aoc.aoc2025.day3

import io.lindhagen.aoc.aoc2025.BaseTest
import io.lindhagen.aoc.aoc2025.Task


internal class Day3Test : BaseTest<Long> {
    override val tester = Day3

    override val sample = Task(
      input = """
      987654321111111
      811111111111119
      234234234234278
      818181911112111
      """.trimIndent().trimMargin(),
      task1 = 357L,
      task2 = 4174379265L,
    )
    override val actual = Task(
      input = "day3",
      task1 = 17346L,
      task2 = 35950619148L,
    )
}
