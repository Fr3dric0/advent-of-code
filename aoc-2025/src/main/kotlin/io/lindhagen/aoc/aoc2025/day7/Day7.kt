package io.lindhagen.aoc.aoc2025.day7

import io.lindhagen.aoc.utils.BaseDay
import io.lindhagen.aoc.utils.FifoQueue
import java.util.Stack

data class Point(val x: Int, val y: Int) {
  override fun toString() = "($x, $y)"
}

enum class ItemType(val symbol: Char) {
  ENTRANCE('S'),
  POINT('.'),
  SPLITTER('^'),
  BEAM('|');

  override fun toString() = symbol.toString()

  companion object {
    fun fromSymbol(symbol: Char): ItemType = entries.first { it.symbol == symbol }
  }
}

/**
 * https://adventofcode.com/2025/day/3
 * */
internal object Day7 : BaseDay<Long> {
  override fun task1(input: String): Long {
    val diagram = input
      .trim()
      .lines()
      .map { it.toCharArray().map { ItemType.fromSymbol(it) } }

    println(diagram.joinToString("\n") { it.joinToString(" ") })

    traverseDiagram(diagram)
    return 0
  }

  private fun traverseDiagram(diagram: List<List<ItemType>>) {
    var beamX = diagram.first().indexOfFirst { it == ItemType.ENTRANCE }
    var beamY = 1

    val splits = mutableListOf<Point>()

    val stack = FifoQueue(mutableListOf(Point(x = beamX, y= beamY)))

    while(stack.isNotEmpty()) {
      println(stack)
      val position = requireNotNull(stack.poll())

      if (position.y > diagram.lastIndex) {
        println("Completed diagram")
        break
      }

      val item = diagram[position.y][position.x]
      println("Point: (${position.x}, ${position.y}) -> $item")

      when (item) {
        ItemType.POINT -> {
          val nextPosition = position.copy(y = position.y + 1)
          if (nextPosition.y <= diagram.lastIndex && !stack.contains(nextPosition)) {
            println("\tMoving! $position -> $nextPosition")
            stack.add(nextPosition)
          }
        }
        ItemType.SPLITTER -> {
          splits.add(position)

          val left = position.copy(x = position.x - 1)
          val right = position.copy(x = position.x + 1)
          val points = listOf(left, right).filter { !stack.contains(it) }
          println("\tSplit! $points")

          stack.addAll(points)
        }
        else -> {}
      }
    }

    println(splits.size)
  }

  override fun task2(input: String): Long {
    return 0
  }
}
