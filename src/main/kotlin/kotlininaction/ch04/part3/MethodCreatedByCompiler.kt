package kotlininaction.ch04.part3

/* kotlin 은 equals, hashCode, toString 등의 메서드를 보이지 않는 곳에서 생성해준다. */

/* 4.3.1 모든 클래스에 생성되는 메서드 */

/*class Client(val name: String, val postalCode: Int) {
    // toString()
    override fun toString() = "Client(name='$name', postalCode=$postalCode)"
    // equals()
    override fun equals(other: Any?): Boolean {
        // intellij 로 재동생성한 equals
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Client

        if (name != other.name) return false
        if (postalCode != other.postalCode) return false

        return true
    }
    // hashCode
    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + postalCode
        return result
    }
}*/

/* 4.3.2 data class */
// 위에 난잡한 Client class 내 override 된 코드들을 data class 를 사용하면 안보이는 곳에서 자동으로 생성해준다.
data class Client(val name: String, val postalCode: Int)

fun main() {
    val cli1 = Client("a", 123)
    val cli2 = Client("a", 123)
    println(cli1)
    println(cli1 == cli2) // equals()
    println(cli1 === cli2) // hash 값 비교

    println(cli1.copy(name = "a", postalCode = 321)) // copy() 불변 객체도 변경하며 복사할 수 있다.
}

/* 4.3.3 클래스 위임 */
// 상속을 허용하지 않는 클래스에 새로운 동작을 추가해야 하는 경우 일반적으로 에코레이터 패턴을 사용하는데 by 키워드를 사용해 위임 클래스를 쉽게 만들 수 있다.
// test 작성 시 interface 의 stub 클래스를 항상 직접 구현했었는데 by 키워드를 사용해 필요한 함수만 override 하면 되어 매우 유용할 듯 하다.
class DelegatingCollection<T> (innerList: Collection<T> = ArrayList<T>()) : Collection<T> by innerList
