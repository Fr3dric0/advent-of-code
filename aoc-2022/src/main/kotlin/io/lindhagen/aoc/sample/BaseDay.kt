package io.lindhagen.aoc.sample

interface BaseDay<out OUTCOME> {
  fun task1(input: String): OUTCOME
  fun task2(input: String): OUTCOME
}
