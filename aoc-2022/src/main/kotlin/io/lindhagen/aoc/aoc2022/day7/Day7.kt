package io.lindhagen.aoc.aoc2022.day7

import io.lindhagen.aoc.utils.BaseDay
import java.lang.IllegalStateException
import java.util.LinkedList

sealed class FileSystem(open val name: String)

data class File(
  override val name: String,
  val size: Long,
) : FileSystem(name)

data class Folder(
  override val name: String,
  val children: MutableList<FileSystem> = mutableListOf(),
  var isCurrent: Boolean = false,
  var parent: Folder? = null,
) : FileSystem(name) {
  override fun toString(): String = "Folder(name=$name, isCurrent=$isCurrent, parent=${parent?.name}, children=${children.map { it.toString() }})"
}

sealed class Command(
  val name: String,
  val args: List<String> = emptyList(),
)
class ListDirectoryAndFiles : Command("ls")
data class ChangeDirectory(
  val destination: String,
) : Command("cd", listOf(destination))

object Day7 : BaseDay<Int> {
  override fun task1(input: String): Int {
    val results = input
      .trim()
      .split("\n")
      .map {
        if (it.startsWith("$")) {
          it
            .replace("$ ", "")
            .split(" ")
            .let { parseCommand(it) }
        } else {
          parseOutput(it.split(" "))
        }
      }

    val fs = buildFileSystem(results.toMutableList())

    return 0
  }

  override fun task2(input: String): Int {
    TODO("Not yet implemented")
  }

  private fun calculateFsSize(fs: Folder) {
    val queue = LinkedList<Folder>()
    fs
      .children
      .filterIsInstance<Folder>()
      .let { queue.addAll(it) }

    while (queue.isNotEmpty()) {
      val folder = queue.poll()
      println(folder)
    }
  }

  private fun buildFileSystem(commands: MutableList<Any>): Folder {
    val root = Folder(name = "/")

    var current: Folder = root

    commands
      .filter { it !is ListDirectoryAndFiles }
      // Discard the command starting in the root, because we have implicitly added that
      .filter { it !is ChangeDirectory || it.destination != "/" }
      .forEachIndexed { index, input ->
        println("fs $index $input")

        if (input is FileSystem) {
          if (input is Folder) {
            input.parent = current
          }

          current.children.add(input)
        }

        if (input is ChangeDirectory) {
          current = changeDirectory(input, current)
        }
      }

    println(root)

    return root
  }

  private fun changeDirectory(input: ChangeDirectory, current: Folder): Folder {
    println("\tChanging to ${input.destination}")
    if (input.destination == "..") {
      val parent = current.parent
        ?: throw IllegalStateException(
          "Cannot cd on level up, because directory (${current.name}) have no parent."
        )

      return parent
    }

    val destination = current.children
      .filterIsInstance<Folder>()
      .find { it.name == input.destination }
      ?: throw IllegalStateException(
        "Trying to navigate to destination: ${input.destination}, but it doesn't exist in: ${current.name}"
      )


    return destination
  }

  private fun parseCommand(command: List<String>): Command {
    val mutableCommand = command.toMutableList()
    val name = mutableCommand.removeFirst()

    if (name == "ls") {
      return ListDirectoryAndFiles()
    }
    if (name == "cd") {
      return ChangeDirectory(
        destination = mutableCommand.last(),
      )
    }

    throw IllegalArgumentException("Unknown command: $command")
  }

  private fun parseOutput(output: List<String>): FileSystem {
    if (output.first() == "dir") {
      return Folder(
        name = output.last(),
      )
    }

    return File(
      name = output.last(),
      size = output.first().toLong(),
    )
  }
}
