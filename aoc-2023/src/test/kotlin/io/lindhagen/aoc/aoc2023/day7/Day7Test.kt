package io.lindhagen.aoc.aoc2023.day7

import io.lindhagen.aoc.aoc2023.BaseTest
import io.lindhagen.aoc.aoc2023.Task

internal class Day7Test : BaseTest<Long> {
  override val tester = Day7

  override val sample = Task(
    input = """
      AAAAA 2
      22222 3
      AAAAK 5
      22223 7
      AAAKK 11
      22233 13
      AAAKQ 17
      22234 19
      AAKKQ 23
      22334 29
      AAKQJ 31
      22345 37
      AKQJT 41
      23456 43
      """.trimIndent(),
    task1 = 1343L,
    task2 = 5905L,
  )
  override val actual = Task(
    input = "day7",
    task1 = 250232501L,
    task2 = 9881048L,
  )
}
