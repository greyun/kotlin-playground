package kotlininaction.ch02

fun main() {
    fun max(a: Int, b: Int): Int {
        return when {
            a > b -> a
            else -> b
        }
    }

    fun max2(a: Int, b: Int): Int {
        if (a > b) {
            return a
        } else {
            return b
        }
    }

    fun max3(a: Int, b: Int): Int {
        return if (a > b) a else b
    }

    fun max4(a: Int, b: Int) = if (a > b) a else b

    println(max(1, 2))
}
