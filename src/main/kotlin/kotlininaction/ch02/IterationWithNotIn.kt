package kotlininaction.ch02

fun main() {
    println(isLetter('q'))
    println(isNotDigit('z'))
    println(recognize('8'))

    println("Kotlin" in "Java".."Scala") // "Java" <= "Kotlin && "Kotlin" <= "Scala" 와 같다.
    println("Kotlin" in setOf("Java", "Scala"))
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's letter!"
    else -> "I don't know..."
}
