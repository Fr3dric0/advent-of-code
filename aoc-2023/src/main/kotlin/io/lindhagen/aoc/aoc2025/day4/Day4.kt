package io.lindhagen.aoc.aoc2025.day4

import io.lindhagen.aoc.utils.BaseDay

data class Card(
  val id: Int,
  val winner: Set<Int>,
  val player: Set<Int>,
  val isOriginal: Boolean,
) {
  fun common() = winner.intersect(player)
}

internal object Day4 : BaseDay<Int> {
  override fun task1(input: String): Int {
    return input
      .trim()
      .lines()
      .map {
        val (name, numbers) = it.split(":")

        name.trim() to numbers
          .trim()
          .split("|")
          .map { it.trim().split(" ").filter { it.isNotEmpty() } }
      }
      .map { (_, numbers) ->
        val (winnerNumbers, playerNumbers) = numbers.map { it.map { it.toInt() } }
        val common = winnerNumbers.toSet().intersect(playerNumbers.toSet())

        common.fold(0) { agg, _ ->
          if (agg == 0) {
            1
          } else {
            agg + agg
          }
        }
      }.sum()
  }

  override fun task2(input: String): Int {
    val originalCards = input
      .trim()
      .lines()
      .map {
        val (name, numbers) = it.split(":")

        name.trim() to numbers
          .trim()
          .split("|")
          .map { it.trim().split(" ").filter { it.isNotEmpty() } }
      }
      .map { (name, numbers) ->
        val (winnerNumbers, playerNumbers) = numbers.map { it.map { it.toInt() } }
        println("$winnerNumbers $playerNumbers")

        val cardId = "\\d+".toRegex().findAll(name).map { it.value }.first().toInt()

        cardId to (winnerNumbers to playerNumbers)

        Card(
          id = cardId,
          winner = winnerNumbers.toSet(),
          player = playerNumbers.toSet(),
          isOriginal = true,
        )
      }
      .sortedBy { it.id }

    val cards = originalCards.toMutableList()
    var totalCardsProcessed = 0

    val cardsCache = originalCards.associateBy { it.id }

    var index = 0
    while (index < cards.size) {
      val card = cards[index++]
      totalCardsProcessed += 1

      if (card.common().isNotEmpty()) {
        val winningCards = card.common().size
        val newCopies = findCards(cardsCache, card.id, winningCards)
        cards.addAll(newCopies)
      }
    }

    return totalCardsProcessed
  }

  private fun findCards(cache: Map<Int, Card>, startingFrom: Int, size: Int): List<Card> {
    return (0..<size)
      // Don't include the item at the startingFrom position
      .mapNotNull { cache[startingFrom + 1 + it] }
      .sortedBy { it.id }
  }
}
