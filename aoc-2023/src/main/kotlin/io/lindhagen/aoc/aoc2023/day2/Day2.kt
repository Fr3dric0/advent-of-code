package io.lindhagen.aoc.aoc2023.day2

import io.lindhagen.aoc.utils.BaseDay

data class CubeGame(
  val name: String,
  val id: Int,
  val sets: List<List<Pair<String, Int>>>,
)

internal object Day2 : BaseDay<Int> {
  override fun task1(input: String): Int {
    val games = buildGames(input)
//      .also { println(it.joinToString("\n")) }

    val possibleGames = games.filter(::isGamePossible)
//    println(games.filter { !isGamePossible(it) }.joinToString("\n"))

    return possibleGames.sumOf { it.id }
  }

  override fun task2(input: String): Int {
    val games = buildGames(input)

    return 0
  }

  private val configuration = mapOf(
    "red" to 12,
    "green" to 13,
    "blue" to 14,
  )

  private fun isGamePossible(game: CubeGame): Boolean {
    val colors = maxAmountByColor(game)
//      .also { println("$game -> $it") }

    return colors
      .all { (color, amount) ->
        val maxValue = configuration.getValue(color)
        amount <= maxValue
      }
//      .also { println("\t $it") }
  }

  private fun maxAmountByColor(game: CubeGame): Map<String, Int> {
    return game
      .sets
      .flatten()
      .groupBy { it.first }
      .mapValues { it.value.map { (_, amount) -> amount } }
      // Find the largest amount presented to us, for each color
      .mapValues { it.value.max() }
  }

  private fun buildGames(input: String): List<CubeGame> {
    return input
      .trim()
      .lines()
      .map {
        val (gameName, sets) = it.split(": ")
        gameName to sets
      }
      .map { (gameName, setsRaw) ->
        val sets = setsRaw
          .split(";")
          .map {
            it
              .trim()
              .split(",")
              .map { cube ->
                val (amount, color) = cube.trim().split(" ")
                color to amount.toInt()
              }
          }

        CubeGame(
          id = gameName.filter { it.isDigit() }.toInt(),
          name = gameName,
          sets = sets,
        )
      }
  }
}
