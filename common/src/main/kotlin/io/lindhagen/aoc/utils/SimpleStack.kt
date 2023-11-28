package io.lindhagen.aoc.utils

@JvmInline
value class SimpleStack(val stack: MutableList<String>) {
  fun takeLastN(n: Int): List<String> {
    return stack
      .takeLast(n)
      .also {
        // Not a pretty way to remove the lastN items
        (0..<n).forEach {
          stack.removeLast()
        }
      }
  }

  fun pop(): String {
    return stack.removeLast()
  }
  fun add(item: String) {
    stack.add(item)
  }

  fun addAll(items: List<String>) {
    stack.addAll(items)
  }

  fun peek(): String? = stack.lastOrNull()
}

@JvmInline
value class SimpleStackCollection(val stacks: List<SimpleStack>) {
  fun move(fromStack: Int, toStack: Int, count: Int) {
    println("Command: move $count from ${fromStack + 1} to ${toStack + 1}...")
    (0..<count).map {
      val item = stacks[fromStack].pop()
      println("\t${it + 1}) moving $item from ${stacks[fromStack]} to ${stacks[toStack]}")
      stacks[toStack].add(item)
    }
  }

  fun moveBatch(fromStack: Int, toStack: Int, count: Int) {
    println("Batch Command: move $count from ${fromStack + 1} to ${toStack + 1}...")

    val items = stacks[fromStack].takeLastN(count)
    println("\t1) moving $items from ${stacks[fromStack]} to ${stacks[toStack]}")
    stacks[toStack].addAll(items)
  }

  fun print() {
    println()
    stacks.forEachIndexed { index, stack ->
      println("${index + 1} : ${stack.stack.joinToString(" | ")} |")
    }
  }

  fun itemsAtTop(): List<String> {
    return stacks.mapNotNull { it.peek() }
  }
}
