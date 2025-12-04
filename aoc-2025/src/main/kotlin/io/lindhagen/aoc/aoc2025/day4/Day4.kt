package io.lindhagen.aoc.aoc2025.day4

import com.sun.corba.se.impl.orbutil.graph.Graph
import io.lindhagen.aoc.utils.BaseDay
import kotlin.math.max
import kotlin.math.min

const val PAPER_ROLL_SYMBOL = "@"

data class PaperRoll(
  val position: Pair<Int, Int>,
  // Each item is the position
  val neighbors: List<Pair<Int, Int>>,
)

/**
 * https://adventofcode.com/2025/day/3
 * */
internal object Day4 : BaseDay<Long> {
  override fun task1(input: String): Long {
    val grid = input.trim().split("\n").map { it.trim().split("").filter { it.isNotEmpty() } }
//    println(grid.joinToString("\n"))

    val paperrolls = buildGraph(grid)
    val rollsAccessible = paperrolls.filter { it.neighbors.size < 4 }
    println(rollsAccessible)

    return rollsAccessible.size.toLong()
  }

  private fun buildGraph(grid: List<List<String>>): List<PaperRoll> {
    val paperrolls = grid.mapIndexed { y, row ->
      row.mapIndexedNotNull { x, symbol ->
        val position = y to x
        println("Position: $position, ${grid[y][x]}")

        if (symbol != PAPER_ROLL_SYMBOL) {
          // Not looking at a paper-roll, nothing to do
          return@mapIndexedNotNull null
        }

        val neighbors = mutableListOf<Pair<Int, Int>>()

        if (y > 0) {
          val topRow = grid[y-1]
          println("\tTop")
          neighbors.addAll(findNeighbors(topRow, rowIndex = y - 1, currentX = x))
        }

        val sameRow = with(row) {
          val left = if (x > 0 && row[x-1] == PAPER_ROLL_SYMBOL) {
            x-1
          } else {
            null
          }

          val right = if (x < size - 1 && row[x + 1] == PAPER_ROLL_SYMBOL) {
            x+1
          } else {
            null
          }

          listOfNotNull(left, right).map { x -> x to y }
        }

        println("\tSame: $sameRow")
        neighbors.addAll(sameRow)

        if (y < grid.size - 1) {
          val bottomRow = grid[y+1]
          println("\tBottom")
          neighbors.addAll(findNeighbors(bottomRow, rowIndex = y + 1, currentX = x))
        }

        println("\tNeighbors; $neighbors")

        PaperRoll(
          position = x to y,
          neighbors = neighbors,
        )
      }
    }.flatten()

    return paperrolls
  }

  private fun findNeighbors(row: List<String>, rowIndex: Int, currentX: Int): List<Pair<Int, Int>> {
    val neighbors = mutableListOf<Pair<Int, Int>>()
    println("\tLooking at: $row")

    if (row[currentX] == PAPER_ROLL_SYMBOL) {
      neighbors.add(currentX to rowIndex)
    }

    if (currentX > 0 && row[currentX-1] == PAPER_ROLL_SYMBOL) {
      neighbors.add(currentX - 1 to rowIndex)
    }

    if (currentX < row.size - 1 && row[currentX+1] == PAPER_ROLL_SYMBOL) {
      neighbors.add(currentX + 1 to rowIndex)
    }

    return neighbors
  }


  override fun task2(input: String): Long {

    return 0
  }
}
