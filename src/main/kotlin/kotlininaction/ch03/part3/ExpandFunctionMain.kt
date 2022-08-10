package kotlininaction.ch03

// 확장 함수를 사용하려면 import 가 필수적: 여러 클래스의 어떤 확장 함수를 사용할 지 모호한 상황을 피하기 위함
import strings.lastChar
//import strings.lastChar as last // alias 기능도 있네

fun main() {
    println("Kotlin".lastChar())
//    println("Kotlin".last())
}
