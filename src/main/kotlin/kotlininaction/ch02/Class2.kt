package kotlininaction.ch02

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean = height == width
}

fun main() {
    println(Rectangle(10, 10).isSquare)
    println(Rectangle(10, 9).isSquare)
}
