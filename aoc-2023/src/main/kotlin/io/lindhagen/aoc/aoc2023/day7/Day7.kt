package io.lindhagen.aoc.aoc2023.day7

import io.lindhagen.aoc.utils.BaseDay

private val cardStrength = listOf(
  "A",
  "K",
  "Q",
  "J",
  "T",
  "9",
  "8",
  "7",
  "6",
  "5",
  "4",
  "3",
  "2",
)

private val handTypeStrength = listOf(
  "five_of_a_kind",
  "four_of_a_kind",
  "full_house",
  "three_of_a_kind",
  "two_pair",
  "one_pair",
  "high_card",
)

data class CardHand(
  val cards: List<String>,
  val bid: Long,
  val type: String = getType(cards),
): Comparable<CardHand> {

  override fun compareTo(other: CardHand): Int {
    // The earlier you match in the list, the better
    val currentStrength = handTypeStrength.indexOf(type)
    val otherStrength = handTypeStrength.indexOf(other.type)

    if (currentStrength != otherStrength) {
      println("$this ($currentStrength) / $other ($otherStrength)")
    }
    if (currentStrength < otherStrength) {
      return -1
    }
    if (currentStrength > otherStrength) {
      return 1
    }

    cards.forEachIndexed { index, card ->
      val otherCard = other.cards[index]
      val currentCardStrength = cardStrength.indexOf(card)
      val otherCardStrength = cardStrength.indexOf(otherCard)

      if (currentCardStrength < otherCardStrength) {
        return -1
      }
      if (currentCardStrength > otherCardStrength) {
        return 1
      }
    }
    return 0
  }

  companion object {
    fun getType(cards: List<String>): String {
      if (cards.toSet().size == 1) {
        // Means that all have the same size
        return "five_of_a_kind"
      }

      if (cards.toSet().size == cards.size) {
        // Every card have different labels
        return "high_card"
      }

      val cardGroups = cards
        .groupBy { it }
        .toList()
        .sortedByDescending { it.second.size }

      if (cardGroups[0].second.size == 4 && cardGroups[1].second.size == 1) {
        return "four_of_a_kind"
      }

      if (cardGroups[0].second.size == 3 && cardGroups[1].second.size == 2) {
        // Three cards have the same label and the two others share the same label
        return "full_house"
      }

      if (cardGroups[0].second.size == 3 && cardGroups.any { it.second.isNotEmpty() }) {
        // Three cards have the same label and we have two with different labels
        return "three_of_a_kind"
      }

      if (cardGroups[0].second.size == 2 && cardGroups[1].second.size == 2) {
        return "two_pair"
      }

      return "one_pair"
    }
  }
}

internal object Day7: BaseDay<Long> {
  override fun task1(input: String): Long {
    val cardHands = input
      .trim()
      .lines()
      .map { it.trim().split(" ") }
      .map { (handRaw, bidRaw) ->
        val cards = handRaw.toList().map(Char::toString)
        val bid = bidRaw.toLong()

        CardHand(cards = cards, bid = bid)
      }
      .sorted()

    return cardHands.mapIndexed { index, hand ->
      val rank = cardHands.size - index
      (hand.bid * rank)
//        .also { println("$hand $it ($rank)") }
    }.sum()
  }

  override fun task2(input: String): Long {
    TODO("Not yet implemented")
  }
}
