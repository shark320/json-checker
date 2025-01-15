package com.vpavlov.json_checker

import com.vpavlov.json_checker.validators.JsonValidator
import com.vpavlov.json_checker.validators.XMLValidator
import java.nio.file.Files
import java.nio.file.Paths


fun main(args: Array<String>) {
    if (args.isEmpty() || args.contains("-help")) {
        printHelp()
        return
    }

    val folderPath = args[0]
    val validateXml = args.contains("-xml")
    val outputAll = args.contains("-all")
    val path = Paths.get(folderPath)

    if (!Files.exists(path) || !Files.isDirectory(path)) {
        println("The specified path is not a valid directory: $folderPath")
        return
    }

    val validFiles = mutableListOf<String>()
    val invalidFiles = mutableListOf<Pair<String, String>>()

    var checkedFiles = 0
    val fileSuffix = if (validateXml) ".xml" else ".json"
    Files.walk(path).filter { Files.isRegularFile(it) && (it.toString().endsWith(fileSuffix)) }.forEach {
        checkedFiles++
        try {
            if (it.toString().endsWith(".json")) {
                JsonValidator.validateFile(it)
            } else if (it.toString().endsWith(".xml")) {
                XMLValidator.validateFile(it)
            }
            validFiles.add(it.toString())
        } catch (e: Exception) {
            invalidFiles.add(Pair(it.toString(), e.message ?: "Unknown error"))
        }
    }

    println("Checked files: $checkedFiles")

    if (outputAll) {
        println("Valid files:")
        validFiles.forEach { println(it) }
    }

    println("Invalid files:")
    invalidFiles.forEach { (file, error) -> println("$file - $error") }
}


fun printHelp() {
    println("Usage: java -jar JsonValidator.jar <path-to-folder> [options]")
    println("Checks the validity of all JSON (and optionally XML) files in the given folder and its subfolders.")
    println("\nOptions:")
    println("  -xml         Also validate XML files")
    println("  -all         Output both valid and invalid files")
    println("  -help        Show this help message")
}
