package kotlininaction.ch03.part4

fun main(args: Array<String>) {
    val list = listOf("args: ", *args) // '*' spread 연산자로 java 의 ...args 와 동일
    println(list)

    // 중위 호출: 인자가 하나뿐인 함수에 사용할 수 있다
    val map = mapOf(1.to("one"), 7 to "seven", 53 to "fifty-three")

    // 구조 분해 선언(destructuring declaration) js 에서 자주 사용하여 익숙하다
    val (number, name) = 1 to "one"
}
