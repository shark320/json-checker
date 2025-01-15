package com.vpavlov.json_checker.validators

import com.fasterxml.jackson.databind.ObjectMapper
import java.nio.file.Files
import java.nio.file.Path

object JsonValidator{

    const val JSON_EXTENSION = ".json"

    fun validateFile(file: Path){
        val mapper = ObjectMapper()
        mapper.readTree(file.toFile())
    }

}