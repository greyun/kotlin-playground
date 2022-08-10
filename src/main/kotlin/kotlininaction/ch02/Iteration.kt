package kotlininaction.ch02

fun main() {
    val oneToTen = 1..10

    for (i in oneToTen)
        println(i)

    for (i in 1 .. 100)
        print(fizzBuzz(i))

    println()

    for (i in 100 downTo 1 step 2)
        print(fizzBuzz(i))
}

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}
