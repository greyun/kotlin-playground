package kotlininaction.ch05

import java.io.File

/* sequence interface 는 Java8의 Stream 과 동일한 개념 및 동작
 */
fun sequenceExample() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))

    people.asSequence()
        .map(Person::name)
        .filter { it.startsWith("A") }
        .toList()
}

fun diffCollectionApiWithSequenceApi() {
    val numbers = listOf(1, 2, 3, 4)

    val printAndMap: (Int) -> Int = { print("map$it "); it * it }
    val printAndFilter: (Int) -> Boolean = { print("filter$it "); it % 2 == 0 }

    println("Collection api")
    numbers
        .map(printAndMap)
        .filter(printAndFilter)
    // map1 map2 map3 map4 filter1 filter4 filter9 filter16
    // collection 이 2개 생성됨

    println("\nSequence api")
    numbers.asSequence()
        .map(printAndMap)
        .filter(printAndFilter)
        .toList()
    // map1 filter1 map2 filter4 map3 filter9 map4 filter16
    // 순차 처리로 하나의 collection 만 생성됨
}

fun generateSequenceExample() {
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }

}

fun File.isInsideHiddenDirectory() = generateSequence(this) { it.parentFile }.any { it.isHidden }

fun main() {
    sequenceExample()
    diffCollectionApiWithSequenceApi()
}
