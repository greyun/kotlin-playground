package kotlininaction.ch02.packageetest

import java.io.BufferedReader
import java.io.StringReader

fun main() {
    val reader = BufferedReader(StringReader("not a number"))
    readNumber(reader)
}

fun readNumber(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }
    println(number)
}
