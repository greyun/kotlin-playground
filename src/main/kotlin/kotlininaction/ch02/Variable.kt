package kotlininaction.ch02

fun main() {
    val question = "삶, 우주, 그리고 모든 것에 대한 궁극적인 질문"
    val answer = 42
    val answer2: Int = 42
    val answer3: Int
    answer3 = 42

    val message: String
    if (true) message = "success"
    else message = "fail"

    val languages = arrayListOf("Java")
    languages.add("Kotlin")

    var answer4 = 42
    answer4 = 43

    println(question)
    println(answer)
    println(answer2)
    println(answer3)
    println(message)
    println(languages)
    println(answer4)
}
