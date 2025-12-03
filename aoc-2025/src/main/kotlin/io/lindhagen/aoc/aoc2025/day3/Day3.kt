package io.lindhagen.aoc.aoc2025.day3

import io.lindhagen.aoc.utils.BaseDay
import kotlin.math.ceil

/**
 * https://adventofcode.com/2025/day/3
 * */
internal object Day3 : BaseDay<Long> {
  override fun task1(input: String): Long {
    val batteryBanks = input.trim().split("\n").map {
      it.trim().split("").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    val joltages = batteryBanks
      .map { bank -> bank to calculateJoltage(bank) }
      .map { it.second }

    return joltages.sum()
  }

  fun calculateJoltage(bank: List<Int>): Long {
    val joltages = bank
      .mapIndexed { leadingIndex, leadingCell ->
        bank
          .subList(leadingIndex + 1, bank.size)
          .map { trailingCell -> "$leadingCell$trailingCell".toLong() }
      }
      .flatten()

    return joltages.max()
  }

  override fun task2(input: String): Long {
    val batteryBanks = input.trim().split("\n").map {
      it.trim().split("").filter { it.isNotEmpty() }.map { it.toInt() }
    }

    batteryBanks.map { bank ->
      val largestCells = bank.mapIndexed { index, cell -> cell to index }.sortedByDescending { it.first }
      println(largestCells)
    }
    return 0
  }
}
