package kotlininaction.ch03

fun main() {
    val set = hashSetOf(1, 7, 53)
    val list = arrayListOf(1, 7, 53)
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    // java 와 다르게 기본적으로 toString()이 구현되어 있는 듯.
    println(set) // [1, 53, 7]
    println(list) // [1, 7, 53]
    println(map) // {1=one, 7=seven, 53=fifty-three}

    // kotlin 은 java 의 Collection 을 그대로 사용하며 java 보다 더 많은 기능들을 제공한다.
    println(set.javaClass) // class java.util.HashSet

    val strings = listOf("first", "second", "fourteenth")
    println(strings.last())

    val numbers = setOf(1, 14, 2)
    println(numbers.max())

    fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
    ): String {
        val result = StringBuilder(prefix)
        for ((index, element) in collection.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(element)
        }
        result.append(postfix)
        return result.toString()
    }

    println(joinToString(list, " ", " ", ".")) // 가독성이 좋지 않음
    // 이름 붙인 인자
    println(joinToString(list, separator = " ", prefix = " ", postfix = ".")) // 주의: java 로 작성된 method 는 이와 같은 "이름 붙인 인자" 를 사용할 수 없음

    // 디폴트 파라미터 값을 적용한 joinToString
    /*
        이 기능 또한 java 로 작성된 method 에서는 사용이 불가함.
        다만, @JvmOverloads 어노테이션을 함수에 추가하면 코틀린 컴파일러가 해당 함수를 오버로딩한 메서드들을 추가하여 동작시킨다.
     */
    fun <T> joinToStringWithDefaultParameterValue(
        collection: Collection<T>,
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
    ): String {
        val result = StringBuilder(prefix)
        for ((index, element) in collection.withIndex()) {
            if (index > 0) result.append(separator)
            result.append(element)
        }
        result.append(postfix)
        return result.toString()
    }

    println(joinToStringWithDefaultParameterValue(list)) // default value 를 적용한 parameter 는 생략이 가능하다
    println(joinToStringWithDefaultParameterValue(list, "; ")) // 일부 parameter 만 전달하는 것도 가능
    println(joinToStringWithDefaultParameterValue(list, prefix = "!")) // 이름을 붙ㅇ면 심지어 순서를 섞어도...
}
