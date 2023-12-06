package io.lindhagen.aoc.aoc2023.day6

import io.lindhagen.aoc.utils.BaseDay
import io.lindhagen.aoc.utils.ListUtils.multiply

internal object Day6 : BaseDay<Int> {
  override fun task1(input: String): Int {
    val (timeLine, distanceLine) = input.trim().lines()

    val time = extractNumbers(timeLine.replace("Time:", "").trim())
    val distance = extractNumbers(distanceLine.replace("Distance:", "").trim())

    val winningTimes = time
      .zip(distance)
      .map { findWinningTimes(it.first, it.second) }
    return winningTimes.map { it.size }.multiply()
  }

  override fun task2(input: String): Int {
    TODO("Not yet implemented")
  }

  private fun extractNumbers(line: String): List<Int> {
    return line.split("\\W+".toRegex()).map { it.toInt() }
  }

  private fun findWinningTimes(maxTime: Int, winningDistance: Int): List<Pair<Int, Int>> {
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
