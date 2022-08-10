package kotlininaction.ch03.part3

fun String.toString() = this.plus("!")
fun String.addNotice() = this.plus("!")

fun main() {
    println("Kotlin".addNotice()) // Kotlin!

    // String 의 멤버 함수인 toString() 의 확장 함수를 선언했으나 멤버 함수의 우선순위가 높기에 확장 함수는 무시됨
    println("Kotlin") // Kotlin
}
