package io.lindhagen.aoc.aoc2022.day6

import io.lindhagen.aoc.utils.BaseDay

object Day6 : BaseDay<Int> {
  private const val startOfPacketLength = 4
  private const val startOfMessageLength = 14

  override fun task1(input: String): Int {
    val startSequence = (startOfPacketLength..<(input.length))
      .map { index ->
        val sequence = input.substring(index - startOfPacketLength, index)
        sequence
      }
      .find { isStartSequence(it) }

    return input.indexOf(startSequence!!) + startOfPacketLength
  }

  override fun task2(input: String): Int {
    val startSequence = (startOfMessageLength..<(input.length))
      .map { index ->
        val sequence = input.substring(index - startOfMessageLength, index)
        sequence
      }
      .find { isStartSequence(it) }

    return input.indexOf(startSequence!!) + startOfMessageLength
  }

  private fun isStartSequence(sequence: CharSequence): Boolean {
    return sequence.length == sequence.toSet().size
  }
}
