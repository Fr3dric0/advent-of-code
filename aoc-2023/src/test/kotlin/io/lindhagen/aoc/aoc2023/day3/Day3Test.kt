package io.lindhagen.aoc.aoc2023.day3

import io.lindhagen.aoc.aoc2023.BaseTest
import io.lindhagen.aoc.aoc2023.Task

internal class Day3Test : BaseTest<Int> {
  override val tester = Day3

  override val sample = Task(
    input = """
      467..114..
      ...*......
      ..35..633.
      ......#...
      617*......
      .....+.58.
      ..592.....
      ......755.
      ...${'$'}.*....
      .664.598..
      """.trimIndent(),
    task1 = 4361,
    task2 = 467835,
  )
  override val actual = Task(
    input = "day3",
    task1 = 2076,
    task2 = 70950,
  )
}
