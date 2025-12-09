package io.lindhagen.aoc.aoc2025.day6

import io.lindhagen.aoc.utils.BaseDay
import io.lindhagen.aoc.utils.ListUtils.transpose
import java.util.Stack

/**
 * https://adventofcode.com/2025/day/3
 * */
internal object Day6 : BaseDay<Long> {
  override fun task1(input: String): Long {
    val math = input
      .trim()
      .split("\n")
      .map { it.trim() }
      .map { it.split("\\s+".toRegex()) }
      .transpose()

    println(math)

    val solutions = math.map {
      it to problemSolver(it)
    }

    return solutions.sumOf { it.second }
  }

  override fun task2(input: String): Long {
    val math = input
      .trim()
      .split("\n")
      .map { it.trim() }
      .map { it.split("\\s+".toRegex()) }
      .transpose()
    println(math)

    val allProblems = math.map { problems ->
      val numbers = problems.take(problems.size - 1)
      val longestNumber = numbers.maxOf { it.length }
      val padded = numbers
        .map { it.padEnd(longestNumber, '0') }

      val actualNumbers = padded
        .map { it.toCharArray().toList() }
        .transpose()
        .map { it.joinToString("") }
        .reversed() // Right to left processing

      println(actualNumbers)

      actualNumbers.plus(problems.last())
    }.reversed()

    allProblems.map {
      problemSolver(it)
    }

    return 0
  }

  private fun problemSolver(problems: List<String>): Long {
    val operation = problems.last()

    // Inspired by Reverse Polish Notation.
    // The difference is that we only have one operation for all numbers.
    val stack = Stack<Long>()
    problems
      .take(problems.size - 1)
      .map { it.toLong() }
      .reversed()
      .forEach { stack.push(it) }

    println(stack)

    while(stack.size > 1) {
      val a = stack.pop()
      val b = stack.pop()

      val results = when (operation) {
        "*" -> a * b
        "+" -> a + b
        "-" -> a - b
        else -> error("Unsupported operation $operation")
      }

      println("$a $operation $b = $results")
      stack.push(results)
    }

    check(stack.isNotEmpty()) {
      "Stack was unexpectedly empty for problem: $problems"
    }

    check(stack.size == 1) {
      "Stack has unsolved problems: $stack"
    }

    return stack.pop()
  }
}
