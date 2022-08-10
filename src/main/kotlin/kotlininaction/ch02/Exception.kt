package kotlininaction.ch02

import java.io.BufferedReader
import java.io.StringReader

fun main() {
    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))
}

fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    }
    catch (e: NumberFormatException) {
        return null
    }
    finally {
        reader.close()
    }
}
