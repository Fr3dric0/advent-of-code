package io.lindhagen.aoc.aoc2022.day7

import io.lindhagen.aoc.aoc2022.BaseTest
import io.lindhagen.aoc.aoc2022.Task
import io.lindhagen.aoc.aoc2022.day6.Day6

internal class Day7Test : BaseTest<Int> {
  override val tester = Day7

  override val sample = Task(
    input = """
    ${'$'} cd /
    ${'$'} ls
    dir a
    14848514 b.txt
    8504156 c.dat
    dir d
    ${'$'} cd a
    ${'$'} ls
    dir e
    29116 f
    2557 g
    62596 h.lst
    ${'$'} cd e
    ${'$'} ls
    584 i
    ${'$'} cd ..
    ${'$'} cd ..
    ${'$'} cd d
    ${'$'} ls
    4060174 j
    8033020 d.log
    5626152 d.ext
    7214296 k
    """.trimIndent(),
    task1 = 7,
    task2 = 19,
  )
  override val actual = Task(
    input = "day6/input1",
    task1 = 1343,
    task2 = 2193,
  )
}

