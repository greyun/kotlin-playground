/*
    이 어노테이션을 사용하면 아래 joinToString 함수를 java 에서 static 함수처럼 사용할 수 있다.
    StringFunctions.joinToString(...);
*/
@file:JvmName("StringFunctions")

package strings

fun <T> joinToString(
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

