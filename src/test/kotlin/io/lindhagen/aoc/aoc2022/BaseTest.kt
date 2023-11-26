package io.lindhagen.aoc.aoc2022

import io.lindhagen.aoc.sample.BaseDay
import io.lindhagen.aoc.utils.InputUtil
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

data class Task<OUTCOME>(
  val input: String,
  val task1: OUTCOME,
  val task2: OUTCOME,
)

internal interface BaseTest {
  val sample: Task<Int>
  val actual: Task<Int>

  val tester: BaseDay

  @Test
  fun `'task1' sample`() {
    expectThat(tester.task1(sample.input)).isEqualTo(sample.task1)
  }
  @Test
  fun `'task1' actual`() {
    val input = InputUtil.readInput(actual.input)
    expectThat(tester.task1(input)).isEqualTo(actual.task1)
  }

  @Test
  fun `'task2' sample`() {
    expectThat(tester.task2(sample.input)).isEqualTo(sample.task2)
  }
  @Test
  fun `'task2' actual`() {
    val input = InputUtil.readInput(actual.input)
    expectThat(tester.task2(input)).isEqualTo(actual.task2)
  }
}

