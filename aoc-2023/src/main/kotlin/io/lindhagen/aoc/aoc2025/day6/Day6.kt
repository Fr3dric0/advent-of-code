package io.lindhagen.aoc.aoc2025.day6

import io.lindhagen.aoc.utils.BaseDay
import io.lindhagen.aoc.utils.ListUtils.multiply

internal object Day6 : BaseDay<Long> {
  override fun task1(input: String): Long {
    val (timeLine, distanceLine) = input.trim().lines()

    val time = extractNumbers(timeLine.replace("Time:", "").trim())
    val distance = extractNumbers(distanceLine.replace("Distance:", "").trim())

    val winningTimes = time
      .zip(distance)
      .map { findWinningTimes(it.first, it.second) }
    return winningTimes.map { it.size }.multiply().toLong()
  }

  override fun task2(input: String): Long {
    val (timeLine, distanceLine) = input.trim().lines()

    val time = extractNumbers(timeLine.replace("Time:", "").trim())
      .joinToString("") { it.toString() }.toLong()
    val distance = extractNumbers(distanceLine.replace("Distance:", "").trim())
      .joinToString("") { it.toString() }.toLong()

    println(time)
    println(distance)

    val winningTimes = findWinningTimes(time, distance)

    return winningTimes.size.toLong()
  }

  private fun extractNumbers(line: String): List<Long> {
    return line.split("\\W+".toRegex()).map { it.toLong() }
  }

  private fun findWinningTimes(maxTime: Long, winningDistance: Long): List<Pair<Long, Long>> {
    return (0..maxTime).mapNotNull { chargeUpTime ->
      val remainingTime = maxTime - chargeUpTime
      if (remainingTime <= 0) {
        return@mapNotNull null
      }

      val speed = chargeUpTime
      val distance = speed * remainingTime

      if (distance <= winningDistance) {
        return@mapNotNull null
      }

      chargeUpTime to distance
    }
  }


}
