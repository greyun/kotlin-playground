package strings

// 확장 함수라고 불리우는 이것은 마치 javascript prototype 같다.
fun String.lastChar(): Char = this.get(this.length - 1)

fun main() {
    println("Kotlin".lastChar())

    val list = listOf(1, 3, 5)
    print(list.joinToString())
}

// 수신 객체를 참조하는 확장 함수로 변경
fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = ""
): String {
    val result = StringBuilder(prefix)
    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}
