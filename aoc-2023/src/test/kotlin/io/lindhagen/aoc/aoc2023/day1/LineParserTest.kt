package io.lindhagen.aoc.aoc2023.day1

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import strikt.api.expectThat
import strikt.assertions.isEqualTo

internal class LineParserTest {
  @ParameterizedTest
  @CsvSource(value = [
    "eight87xzjkdpnnjjfqeight, 8, 8",
    "two934seven1, 2, 1",
    "573, 5, 3",
    "3gngzkpkgrf, 3, 3",
  ])
  fun `'parseDigits' identifies correct first and last digit`(line: String, first: Int, last: Int) {
    val digits = LineParser.parseDigits(line)

    expectThat(digits) {
      get { first().second }.isEqualTo(first)
      get { last().second }.isEqualTo(last)
    }
  }
}
