package kotlininaction.ch03.part5

fun main() {
    // 3중 따움표의 여러 줄 문자열에는 들여쓰기나 줄 바꿈을 포함한 모든 문자가 들어간다.
    val kotlinLogo = """|  //
                       .| //
                       .|/ \"""
    println(kotlinLogo.trimMargin("."))
}
