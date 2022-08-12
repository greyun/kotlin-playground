package kotlininaction.ch05

data class Person(val name: String, val age: Int)

fun iterationCollectionWithLambda() {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))

    // maxBy 는 kotlin 1.4 부터 deprecated 됨
    println(people.maxBy { it.age })
    println(people.maxBy(Person::age))

    println(people.maxByOrNull { it.age })
    println(people.maxByOrNull(Person::age))

    // Lambda 문법의 간소화
    people.maxBy() { p: Person -> p.age }
    people.maxBy { p: Person -> p.age } // 람다가 유일한 인자이면 호출 시 빈 괄호 제거 가능
    people.maxBy { p -> p.age } // 파라미터 타입 생략(컴파일러가 추론함)
    people.maxBy { it.age } // 티폴트 파라미터 it 사용하기: 람다 파라미터를 지정하지 않으면 it 이라는 이름으로 자동으로 만들어짐

    val names = people.joinToString(
        separator = " ",
        transform = { p: Person -> p.name }
    )

    // 이 방식도 가능하나 joinToString 을 잘 모르는 개발자는 위 방식이 더 이해하기 쉬울 것
    // Intellij 의 "move lambda argument into parentheses" 기능을 사용하여 위와 같은 형태로 변환 가능
    people.joinToString(" ") { p: Person -> p.name }
}

fun lambdaValue() {
    val sum1 = fun (x: Int, y: Int) = x + y // 궁금해서 해봤는데 서로 동일하네.. 람다식 내부 동작은 함수인 듯.
    val sum2 = { x: Int, y: Int -> x + y }

    println(sum1(1, 2))
    println(sum2(1, 2))

    println(sum1)
    println(sum2)
}
fun main() {
    println("iteration collectionW with lambda")
    iterationCollectionWithLambda()

    println("assign lambda to value")
    lambdaValue()

    println("run keyword exec lambda")
    runKeyword()
}

private fun runKeyword() {
    run { println(42) }
}
