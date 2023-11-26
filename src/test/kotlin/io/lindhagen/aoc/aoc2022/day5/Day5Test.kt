package io.lindhagen.aoc.aoc2022.day5

import io.lindhagen.aoc.aoc2022.BaseTest
import io.lindhagen.aoc.aoc2022.Task

internal class Day5Test : BaseTest<String> {
  override val tester = Day5

  override val sample = Task(
    input = """
        [D]    
    [N] [C]    
    [Z] [M] [P]
     1   2   3 
    
    move 1 from 2 to 1
    move 3 from 1 to 3
    move 2 from 2 to 1
    move 1 from 1 to 2
    """.trimIndent(),
    task1 = "CMZ",
    task2 = "eeffw",
  )
  override val actual = Task(
    input = "day5/input1",
    task1 = "VCTFTJQCG",
    task2 = "wefwf",
  )
}
