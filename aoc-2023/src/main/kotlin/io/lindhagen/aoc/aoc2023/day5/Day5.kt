package io.lindhagen.aoc.aoc2023.day5

import io.lindhagen.aoc.utils.BaseDay

private class PlantingMap {
  val name: String
  val coordinates: List<Pair<Long, Long>> = emptyList()
  val oldCoordinates = mutableMapOf<Long, Long>()

  constructor(name: String, lines: List<String>) {
    this.name = name

    val map = mutableListOf<Pair<Long, Long>>()

    println("$name")
    lines
      .forEach { line ->
        val (destination, source, length) = line.split(" ").map { it.toLong() }
        println("\t$destination, $source, $length")

        for (index in 0..<length) {
          oldCoordinates[source + index] = destination + index
//          map.add(destination + index to source + index)
        }
        println("$name: Coordinates inserted")
      }

    println("$name: Sorting coordinates for search")
//    coordinates = map.sortedBy { it.first }
    println("$name: Sorting completed")
  }

  fun getOrDefault(source: Long): Long {
    return oldCoordinates[source] ?: source
//    val index = coordinates.binarySearch {
//      val diff = it.first - source
//
//      if (diff == 0L) {
//        0
//      } else if (diff < 0) {
//        -1
//      } else {
//        1
//      }
//    }
//
//    return if (index >= 0) {
//      coordinates[index].second
//    } else {
//      source
//    }
  }

  override fun toString(): String {
    return "PlantingMap(name='$name', coordinates=$coordinates)"
  }
}

internal object Day5 : BaseDay<Long> {
  override fun task1(input: String): Long {
    val (seeds, maps) = buildInput(input)

    val locations = seeds
      .asSequence()
      .map { seed ->
        var value: Long = seed

        maps.forEach { mapper ->
          value = mapper.getOrDefault(value)
        }

        value
      }
      .toList()

    return locations.min()
  }

  override fun task2(input: String): Long {
    TODO("Not yet implemented")
  }

  private fun buildInput(input: String): Pair<List<Long>, List<PlantingMap>> {
    val lines = input.split("\n\n")

    val seeds = lines[0]
      .let {
        it
          .replace("seeds:", "")
          .trim()
          .split(" ")
          .map { it.toLong() }
      }

    val maps = lines
      .filter { !it.startsWith("seeds:") }
      .map { line ->
        val (name, coordinates) = line.split(":\n")
        println("Line: $name")

        PlantingMap(
          name = name.replace("map", "").trim(),
          lines = coordinates.split("\n"),
        )
//          .also { println(it) }
      }

    return seeds to maps
  }
}
