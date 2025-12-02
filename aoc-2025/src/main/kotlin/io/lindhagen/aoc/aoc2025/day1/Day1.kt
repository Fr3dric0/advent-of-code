package io.lindhagen.aoc.aoc2025.day1

import io.lindhagen.aoc.utils.BaseDay
import kotlin.math.abs
import kotlin.math.ceil

/**
 * https://adventofcode.com/2025/day/1
 * */
internal object Day1 : BaseDay<Int> {
  override fun task1(input: String): Int {
    val initialPosition = 50

    val movement = input
      .trim()
      .split("\n")
      .map { it.trim() }
      .map { it.first() to it.substring(1) }
      .map { it.first to it.second.toInt() }

    val intermediaryPositions = mutableListOf(initialPosition)
    var currentPosition = initialPosition

    movement.forEach { (direction, distance) ->
      val difference = when (direction.lowercase()) {
        "l" -> currentPosition - distance
        "r" -> currentPosition + distance
        else -> error("Unknown direction $direction")
      }

      val newPosition = difference.mod(100)

      println("Position: $currentPosition, New position: $newPosition, direction: $direction, distance: $distance, difference: $difference")

      intermediaryPositions.add(newPosition)
      currentPosition = newPosition
    }

    val answer = intermediaryPositions.count { it == 0 }
    return answer
  }

  override fun task2(input: String): Int {
    val initialPosition = 50

    val movement = input
      .trim()
      .split("\n")
      .map { it.trim() }
      .map { it.first() to it.substring(1) }
      .map { it.first to it.second.toInt() }

    val intermediaryPositions = mutableListOf(initialPosition)
    var currentPosition = initialPosition

    movement.forEach { (direction, distance) ->
      val difference = when (direction.lowercase()) {
        "l" -> currentPosition - distance
        "r" -> currentPosition + distance
        else -> error("Unknown direction $direction")
      }

      val newPosition = difference.mod(100)

      val movementsPastZero = ceil(abs(difference).toDouble()/100).toInt()
      println("Position: $currentPosition, New position: $newPosition, Past Zero: $movementsPastZero, direction: $direction, distance: $distance, difference: $difference")

      intermediaryPositions.add(movementsPastZero)
      currentPosition = newPosition
    }

    val answer = intermediaryPositions.count { it == 0 }
    return answer
  }
}
