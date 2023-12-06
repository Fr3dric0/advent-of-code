package io.lindhagen.aoc.aoc2023

import io.lindhagen.aoc.utils.BaseDay
import io.lindhagen.aoc.utils.InputUtils.readDayInput
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

data class Task<out OUTCOME>(
  val input: String,
  val task1: OUTCOME,
  val task2: OUTCOME,
)

internal interface BaseTest<out OUTCOME> {
  val sample: Task<OUTCOME>
  val actual: Task<OUTCOME>

  val tester: BaseDay<OUTCOME>

  @Test
  fun `'task1' sample`() {
    expectThat(tester.task1(sample.input)).isEqualTo(sample.task1)
  }
  @Test
  fun `'task1' actual`() {
    val input = readDayInput(actual.input)
    expectThat(tester.task1(input)).isEqualTo(actual.task1)
  }

  @Test
  fun `'task2' sample`() {
    expectThat(tester.task2(sample.input)).isEqualTo(sample.task2)
  }
  @Test
  fun `'task2' actual`() {
    val input = readDayInput(actual.input)
    expectThat(tester.task2(input)).isEqualTo(actual.task2)
  }
}

