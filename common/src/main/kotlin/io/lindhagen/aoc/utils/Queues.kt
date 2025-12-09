package io.lindhagen.aoc.utils

import java.util.Queue

class FifoQueue<T>(val items: MutableList<T> = mutableListOf()) : Queue<T> {
  override fun add(item: T): Boolean {
    return items.add(item)
  }

  override fun offer(e: T?): Boolean {
    TODO("Not yet implemented")
  }

  override fun remove(): T? {
    TODO("Not yet implemented")
  }

  override fun remove(element: T?): Boolean {
    TODO("Not yet implemented")
  }

  override fun poll(): T? {
    return if (items.isNotEmpty()) {
      items.removeFirst()
    } else {
      null
    }
  }

  override fun element(): T? {
    TODO("Not yet implemented")
  }

  override fun peek(): T? {
    return if (items.isNotEmpty()) {
      items.first()
    } else {
      null
    }
  }

  override fun addAll(elements: Collection<T>): Boolean {
    return items.addAll(elements)
  }

  override fun clear() {
    items.clear()
  }

  override fun iterator(): MutableIterator<T?> {
    return items.iterator()
  }

  override fun removeAll(elements: Collection<T?>): Boolean {
    TODO("Not yet implemented")
  }

  override fun retainAll(elements: Collection<T?>): Boolean {
    TODO("Not yet implemented")
  }

  override val size: Int
    get() = items.size

  override fun isEmpty() =  items.isEmpty()

  override fun contains(element: T): Boolean {
    return items.contains(element)
  }

  override fun containsAll(elements: Collection<T>): Boolean {
    return items.containsAll(elements)
  }

  override fun toString(): String {
    return "[${items.joinToString(",")}]"
  }
}
