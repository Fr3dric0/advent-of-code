package io.lindhagen.aoc.aoc2023.day2

import io.lindhagen.aoc.utils.BaseDay

data class CubeGame(
  val name: String,
  val sets: List<List<Pair<String, Int>>>,
)

internal object Day2 : BaseDay<Int> {
  override fun task1(input: String): Int {
    input
      .trim()
      .also { println(it) }
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

        CubeGame(name = gameName, sets = sets)
      }
      .also { println(it.joinToString("\n")) }

    return 0
  }

  override fun task2(input: String): Int {
    TODO("Not yet implemented")
  }
}
