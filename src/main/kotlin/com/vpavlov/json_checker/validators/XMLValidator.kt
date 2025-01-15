package com.vpavlov.json_checker.validators

import org.xml.sax.SAXException
import org.xml.sax.SAXParseException
import java.nio.file.Path
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.parsers.ParserConfigurationException

object XMLValidator {

    const val XML_EXTENSION = ".xml"

    fun validateFile(file: Path) {
        try {
            val factory = DocumentBuilderFactory.newInstance()
            val builder = factory.newDocumentBuilder()
            builder.setErrorHandler(
                object : org.xml.sax.ErrorHandler {
                    override fun error(exception: SAXParseException?) {
                        //Silent
                    }

                    override fun fatalError(exception: SAXParseException?) {
                        //Silent
                    }

                    override fun warning(exception: SAXParseException?) {
                        //Silent
                    }
                }
            )
            builder.parse(file.toFile())
        } catch (e: SAXException) {
            throw Exception("Invalid XML format: ${e.message}")
        } catch (e: ParserConfigurationException) {
            throw Exception("XML parser configuration error: ${e.message}")
        }
    }
}