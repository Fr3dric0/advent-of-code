package io.lindhagen.aoc.aoc2023.day5

import io.lindhagen.aoc.utils.BaseDay

data class PlantingRange(
  val min: Long,
  val max: Long,
  val size: Long,
  val destination: Long,
) {
  fun isWithin(source: Long): Boolean {
    return source in min..max
  }

  fun getDestination(source: Long): Long? {
    if (!isWithin(source)) {
      return null
    }

    val diff = source - min
    return destination + diff
  }
}

private class PlantingMap {
  val name: String
  val coordinates: List<PlantingRange>

  constructor(name: String, lines: List<String>) {
    this.name = name

    val map = mutableListOf<PlantingRange>()

    lines
      .forEach { line ->
        val (destination, source, length) = line.split(" ").map { it.toLong() }

        map.add(PlantingRange(
          min = source,
          max = source + length - 1,
          size = length,
          destination = destination,
        ))
      }

    coordinates = map
  }

  fun getOrDefault(source: Long): Long {
    val match = coordinates.firstOrNull { range -> range.isWithin(source) }
    return match?.getDestination(source) ?: source
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
    val lines = input.trim().split("\n\n")

    val seeds = getSeedsRanges(lines)
    val maps = buildPlantingMaps(lines)

    val smallestLocations = maps.last().coordinates.sortedBy { it.min }

    val mapsReversed = maps.reversed()
    println(mapsReversed)

    val locationRange = smallestLocations[0]
    println(locationRange)

    seeds
      .asSequence()
      .forEach { (seedStart, seedSize) ->
        val seedEnd = seedStart + seedSize - 1
        println("$seedStart - $seedEnd ($seedSize)")
      }

    return 0
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

    val maps = buildPlantingMaps(lines)

    return seeds to maps
  }

  private fun buildPlantingMaps(lines: List<String>): List<PlantingMap> {
    return lines
      .filter { !it.startsWith("seeds:") }
      .map { line ->
        val (name, coordinates) = line.split(":\n")

        PlantingMap(
          name = name.replace("map", "").trim(),
          lines = coordinates.trim().split("\n"),
        )
      }
  }

  private fun getSeedsRanges(lines: List<String>): List<Pair<Long, Long>> {
    return lines[0]
      .replace("seeds:", "")
      .trim()
      .split(" ")
      .map { it.toLong() }
      .chunked(2)
      .map { it[0] to it[1] }
  }
}
