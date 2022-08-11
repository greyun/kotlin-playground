package kotlininaction.ch04.part1

import kotlin.math.pow

interface Clickable {
    fun click()

    // 디폴트 구현 메서드
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun showOff() = println("I'm focusable!")
}

class Button : Clickable, Focusable {
    // java 와 달리 kotlin 에서는 override 변경자를 꼭 사용해야함
    override fun click() = println("I was clicked!")

    // 동일한 이름의 디폴트 구현 메서드를 갖는 인터페이스를 구현하면 반드시 디폴트 구현 메서드를 override 해야한다
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main() {
    Button().click()
    Button().showOff()
}
