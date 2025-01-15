package com.vpavlov

import com.fasterxml.jackson.core.JsonParseException
import com.fasterxml.jackson.databind.ObjectMapper
import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
    if (args.isEmpty() || args.contains("-help")) {
        printHelp()
        return
    }

    val folderPath = args[0]
    val path = Paths.get(folderPath)

    if (!Files.exists(path) || !Files.isDirectory(path)) {
        println("The specified path is not a valid directory: $folderPath")
        return
    }

    val validFiles = mutableListOf<String>()
    val invalidFiles = mutableListOf<Pair<String, String>>()
    val mapper = ObjectMapper()

    var checkedFiles = 0
    Files.walk(path).filter { Files.isRegularFile(it) && it.toString().endsWith(".json") }.forEach {
        checkedFiles++
        try {
            mapper.readTree(it.toFile())
            validFiles.add(it.toString())
        } catch (e: JsonParseException) {
            invalidFiles.add(Pair(it.toString(), "Invalid JSON format: ${e.message}"))
        } catch (e: Exception) {
            println("Unexpected error while processing file: ${it.toString()}\n${e.message}")
            invalidFiles.add(Pair(it.toString(), "Unexpected error: ${e.message}"))
        }
    }

    println("Checked files: $checkedFiles")
    println("Valid files:")
    validFiles.forEach { println(it) }
    println("Invalid files:")
    invalidFiles.forEach { (file, error) -> println("$file - $error") }
}

fun printHelp() {
    println("Usage: java -jar JsonValidator.jar <path-to-folder>")
    println("Checks the validity of all JSON files in the given folder and its subfolders.")
    println("\nOptions:")
    println("  -help         Show this help message")
}
