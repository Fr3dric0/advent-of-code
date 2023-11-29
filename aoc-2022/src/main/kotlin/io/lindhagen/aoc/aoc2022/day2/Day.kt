package io.lindhagen.aoc.aoc2022.day2

import io.lindhagen.aoc.utils.BaseDay

enum class RoundOutcome {
  DRAW,
  WIN,
  LOOSE,
}

internal object Day : BaseDay<Int> {
  private val shapeScore = mapOf(
    // Rock
    "A" to 1,
    // Paper
    "B" to 2,
    // Scissor
    "C" to 3,
  )

  override fun task1(input: String): Int {
    return input
      .trim()
      .split("\n")
      .map {
        val (opponent, player) = it.trim().split(" ")
        opponent to player
      }
      .map {
        // Convert player to the same move-codes
        val player = when (it.second) {
          "X" -> "A"
          "Y" -> "B"
          "Z" -> "C"
          else -> throw IllegalArgumentException("Unknown player move: ${it.second}")
        }

        it.first to player
      }
      .sumOf { calculatePlayerScoreTask1(it.first, it.second) }
  }

  override fun task2(input: String): Int {
    return input
      .trim()
      .split("\n")
      .map {
        val (opponent, player) = it.trim().split(" ")
        opponent to player
      }
      .map {
        val playerOutcome = when (it.second) {
          "X" -> RoundOutcome.LOOSE
          "Y" -> RoundOutcome.DRAW
          "Z" -> RoundOutcome.WIN
          else -> throw IllegalArgumentException("Unknown player move: ${it.second}")
        }

        it.first to playerOutcome
      }
      .sumOf { calculatePlayerScoreTask2(it.first, it.second) }
  }

  private fun calculatePlayerScoreTask2(opponent: String, playerOutcome: RoundOutcome): Int {
    val playerAction = when (playerOutcome) {
      RoundOutcome.LOOSE -> when (opponent) {
        "A" -> "C"
        "B" -> "A"
        else -> "B"
      }
      RoundOutcome.DRAW -> opponent
      RoundOutcome.WIN -> when (opponent) {
        "A" -> "B"
        "B" -> "C"
        else -> "A"
      }
    }

    val actionScore = shapeScore.getValue(playerAction)
    val roundScore = roundScore(playerOutcome)

    return actionScore + roundScore
  }

  private fun calculatePlayerScoreTask1(opponent: String, player: String): Int {
    val actionScore = shapeScore.getValue(player)

    val outcome = roundOutcome(opponent, player)
    val roundScore = roundScore(outcome)

    return actionScore + roundScore
  }

  private fun roundOutcome(opponent: String, player: String): RoundOutcome {
    return when (opponent) {
      "A" -> {
        when (player) {
          "A" -> RoundOutcome.DRAW
          "B" -> RoundOutcome.WIN
          else -> RoundOutcome.LOOSE
        }
      }
      "B" -> {
        when (player) {
          "A" -> RoundOutcome.LOOSE
          "B" -> RoundOutcome.DRAW
          else -> RoundOutcome.WIN
        }
      }
      else -> {
        when (player) {
          "A" -> RoundOutcome.WIN
          "B" -> RoundOutcome.LOOSE
          else -> RoundOutcome.DRAW
        }
      }
    }
  }

  private fun roundScore(outcome: RoundOutcome) = when (outcome) {
    RoundOutcome.LOOSE -> 0
    RoundOutcome.WIN -> 6
    RoundOutcome.DRAW -> 3
  }
}
