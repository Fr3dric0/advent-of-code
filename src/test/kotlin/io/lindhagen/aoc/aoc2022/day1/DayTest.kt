package io.lindhagen.aoc.aoc2022.day1

import io.lindhagen.aoc.utils.InputUtil.readInput
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo


internal class DayTest {
  val task1SampleInput = """
      1000
      2000
      3000
  
      4000
  
      5000
      6000
  
      7000
      8000
      9000
      
      10000
    """.trimIndent()

  @Test
  fun `'task1' sample`() {
    expectThat(Day.task1(task1SampleInput)).isEqualTo(24000)
  }

  @Test
  fun `'task1' actual`() {
    val input = readInput("day1/input1")

    val output = Day.task1(input)
    expectThat(output).isEqualTo(69177)
  }

  @Test
  fun `'task2' sample`() {
    val output = Day.task2(task1SampleInput)
    expectThat(output).isEqualTo(45000)
  }

  @Test
  fun `'task2' actual`() {
    val input = readInput("day1/input1")
    expectThat(Day.task2(input)).isEqualTo(207456)
  }
}
