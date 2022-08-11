package kotlininaction.ch04.part4

import kotlininaction.ch02.Person
import java.awt.Window
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import java.io.File

/* object 키워드를 사용하는 상황들 */

/* 4.4.1 객체 선언: 싱글턴 쉽게 만들기 */
// 객체 선언은 단위 테스트가 불가함: 구글 주스(Guice)와 같은 프레임워크의 도움을 받아야 한다. <- 별로 좋진 않네

// 일반 클래스 인스턴스와 달리 싱글턴 객체는 객체 선언문이 있는 위치에서 생성자 호출 없이 즉시 만들어진다.
object Payroll {
    val allEmployees = arrayListOf<Person>()
    fun calculateSalary() {
        for (person in allEmployees) {}
    }
}

fun main() {
    Payroll.allEmployees.add(Person("a", false))
    Payroll.calculateSalary()
}

// 객체 선언도 클래스나 인터페이스를 상속할 수 있다.
object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, ignoreCase = true)
    }

}

/* 4.4.2 동반 객체: 팩토리 메서드와 정적 멤버가 들어갈 장소 */
// 코틀린은 static 이 없다. 최상위 함수와 object 가 이를 대신하지만 클래스 내 private 멤버를 참조하기에는 companion object 가 제격이다. -- 클래스와 함께 따라다니는 정적 멤버?
class A {
    companion object { // 동반 객체
        fun bar() = println("Companion object called")
    }
}
// A.bar()

// FactoryMethod
enum class UserType(val code: String) {
    SUBSCRIBING("01"), FACEBOOK("02");
}
class User private constructor(val nickname: String, val type: UserType) {
    companion object SpecificName { // 이름도 붙일 수 있음(없으면 기본 이름은 Companion)  => User.SpecificName.of(...)
        fun of(email: String = "", accountId: Int = 0, type: UserType) {
            when (type) { // Enum 안에 있는 값 외의 조건은 불필요하기에 else 를 제거해도 되는 듯
                UserType.SUBSCRIBING -> User(email.substringBefore('@'), type)
                UserType.FACEBOOK -> User(getFacebookName(accountId), type)
            }
        }
    }
}
private fun getFacebookName(accountId: Int): String {
    TODO("Not yet implemented")
}

/* 4.4.4 객체 식: 무명 내부 클래스를 다른 방식으로작성 */
// 무명 객체로 이벤트 리스너 구현
fun addMouseListeners(window: Window) {
    window.addMouseListener(
        object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent?) = super.mouseClicked(e)
            override fun mouseEntered(e: MouseEvent?) = super.mouseEntered(e)
        }
    )
}

fun countClicks(window: Window) {
    var clickCount = 0
    window.addMouseListener(object : MouseAdapter() {
        override fun mouseClicked(e: MouseEvent?) {
            clickCount++ // java 와 달리 로컬 변수 값 변경이 가능하다.
        }
    })
}
