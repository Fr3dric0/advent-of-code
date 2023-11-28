package io.lindhagen.aoc.utils

interface BaseDay<out OUTCOME> {
  fun task1(input: String): OUTCOME
  fun task2(input: String): OUTCOME
}
