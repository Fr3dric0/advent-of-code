package io.lindhagen.aoc.aoc2022.day3

import io.lindhagen.aoc.aoc2022.BaseTest
import io.lindhagen.aoc.aoc2022.Task

internal class Day3Test : BaseTest {
  override val tester = Day3

  override val sample = Task(
    input = """
    vJrwpWtwJgWrhcsFMMfFFhFp
    jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL
    PmmdzqPrVvPwwTWBwg
    wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn
    ttgJtRGJQctTZtZT
    CrZsJsPPZsGzwwsLwLmpwMDw
    """.trimIndent(),
    task1 = 157,
    task2 = 70,
  )
  override val actual = Task(
    input = "day3/input1",
    task1 = 8202,
    task2 = 2864,
  )
}
