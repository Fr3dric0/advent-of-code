package io.lindhagen.aoc.aoc2025.day2

internal object LineParser {
  fun parseDigits(line: String): List<Pair<Int, Int>> {
    val namedLetterPosition = lettersAsNames
      .mapNotNull { (name, number) ->
        line
          .findFirstAndLastOf(name)
          .map { it.first to number }
      }
      .flatten()

    val rawLetterPosition = line
      .mapIndexed { index, character ->
        if (character.isDigit()) {
          index to character.digitToInt()
        } else {
          null
        }
      }
      .filterNotNull()

    return namedLetterPosition
      .plus(rawLetterPosition)
      .sortedBy { it.first }
      .also { println("$line -> $it") }
  }

  /**
   * We could have the same number multiple places in one string,
   * such as "eight" in "eight87xzjkdpnnjjfqeight".
   * */
  private fun String.findFirstAndLastOf(phrase: String): List<Pair<Int, String>> {
    val first = findAnyOf(listOf(phrase))
    val last = findLastAnyOf(listOf(phrase))

    return listOfNotNull(first, last)
      .associate { it }
      .toList()

  }

  private val lettersAsNames = mapOf(
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9,
  )
}
