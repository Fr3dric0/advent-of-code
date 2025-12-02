package io.lindhagen.aoc.aoc2025.day2

import io.lindhagen.aoc.aoc2025.BaseTest
import io.lindhagen.aoc.aoc2025.Task


internal class Day2Test : BaseTest<Long> {
    override val tester = Day2

    override val sample = Task(
      input = """
      11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124
      """.trimIndent(),
      task1 = 1227775554L,
      task2 = 4174379265L,
    )
    override val actual = Task(
      input = "day2",
      task1 = 23039913998L,
      task2 = 53340L,
    )
}
