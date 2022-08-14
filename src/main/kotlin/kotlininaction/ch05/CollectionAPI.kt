package kotlininaction.ch05

val list = listOf(1, 2, 3, 4)
val people = listOf(Person("Alice", 29), Person("Bob", 31))

fun filterExample() {
    println(list.filter { it % 2 == 0})
    println(people.filter { it.age > 30 })

    val maxAge = people.maxBy(Person::age).age
    println(people.filter { it.age == maxAge })
}

fun mapExample() {
    println(list.map { it * it })
    println(people.map { it.name })
}

fun filterWithMapExample() {
    println(people.filter { it.age > 30 }.map(Person::name))
}

fun allExample() {
    val canBeInclude29 = { p: Person -> p.age >= 29 }
    println(people.all(canBeInclude29))
}

fun anyExample() {
    val canBeInclude29 = { p: Person -> p.age >= 29 }
    println(people.any(canBeInclude29))
}

fun countExample() {
    val canBeInclude29 = { p: Person -> p.age >= 29 }
    println(people.count(canBeInclude29))
}

fun findExample() {
    val canBeInclude29 = { p: Person -> p.age >= 29 }
    println(people.find(canBeInclude29))
    println(people.firstOrNull(canBeInclude29)) // 동일한 API, 없으면 null 이 반환되는 것을 명확히 하기 좋음
}

fun groupByExample() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31), Person("Carol", 31))
    println(people.groupBy { it.age })

    val list = listOf("a", "ab", "b", "bbc", "abc", "c")
    println(list.groupBy(String::first))
}

fun flatMapExample() {
    class Book(val title: String, val authors: List<String>)
    val books = listOf(Book("Power overwhelming", listOf("Sam", "Peter")),
                       Book("Operation CWAL", listOf("Paul", "Peter")))
    println(books.flatMap { it.authors }.toSet())

    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })
}

fun main() {
    filterExample()
    mapExample()
    filterWithMapExample()

    allExample()
    anyExample()
    countExample()
    findExample()

    groupByExample()

    flatMapExample()
}
