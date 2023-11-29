package io.lindhagen.aoc.aoc2022.day3

import io.lindhagen.aoc.utils.BaseDay

object Day3 : BaseDay<Int> {
  override fun task1(input: String): Int {
    return input
      .trim()
      .split("\n")
      .map {
        val middle = it.length / 2
        val stack1 = it.substring(0, middle).toList()
        val stack2 = it.substring(middle).toList()

        stack1 to stack2
      }
      .map { commonItems(it.first, it.second) }
      .flatMap { it.map(::itemPriority) }
      .sum()
  }

  override fun task2(input: String): Int {
    return input
      .trim()
      .split("\n")
      .map { it.toList() }
      .chunked(3) // Groups of three
      .mapIndexed { index, group ->
        index % 3 to group
      }
      .map { (group, stacks) ->
        val common = stacks
          .map { it.toSet() }
          .reduce { acc, chars -> acc.intersect(chars) }
        group to common
      }
      .map { it.second.first() }
      .sumOf(::itemPriority)
  }

  private fun commonItems(stack1: List<Char>, stack2: List<Char>): Set<Char> {
    return stack1.toSet()
      .intersect(stack2.toSet())
  }

  private fun itemPriority(character: Char): Int {
    val lowerCase = ('a'..'z').toList()
    val upperCase = lowerCase.map { it.uppercaseChar() }

    return if (lowerCase.contains(character)) {
      lowerCase.indexOf(character) + 1
    } else {
      upperCase.indexOf(character) + 27
    }
  }
}
