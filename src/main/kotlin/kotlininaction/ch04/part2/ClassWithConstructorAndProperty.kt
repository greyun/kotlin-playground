package kotlininaction.ch04.part2

import java.awt.Button
import javax.naming.Context
import javax.swing.text.AttributeSet

/*
    kotlin 은 주(primary) 생성자와 부(secondary) 생성자를 구분한다.
    또한 kotlin 에서는 초기화 블록(initializer block) 을 통해 초기화 로직을 추가할 수 있다.
 */

/* 4.2.1 클래스 초기화 */
class User
    (val nickname: String) // <- 이 친구가 주 생성자

// User class 는 실제로 아래 처럼 동작한다.
class User1 constructor(_nickname: String) {
    val nickname: String
    init {
        nickname = _nickname
    }
}

class User2 constructor(nickname: String) {
    val nickname: String
    init {
        this.nickname = nickname // java 처럼도 가능
    }
}

// 주 생성자 앞에 별다른 애노테이션이나 가시성 변경자가 없다면 constructor 생략 가능
class User3 (_nickname: String) {
    val nickname = _nickname // 프로퍼티를 주 생성자의 파라미터로 초기화
}

// 주 생성자의 파라미터로 프로퍼티를 초기화하면 가장 간결한 코드가 됨
class User4(val nickname: String)

class User5(
    val nickname: String,
    val isSubscribed: Boolean = true, // 디폴트 값 정의 가능
)

fun main() {
    val foo = User5("foo") // 디폴트 값 사용
    val bar = User5("bar", false)
    val baz = User5("baz", isSubscribed = false) // 인자 이름 지정
}

/*
    TIP: java 특정 라이브러리는 noArgsConstructor 를 강제하는데
    kotlin 에서 모든 생성자 파라미터에 디폴트 값을 지정하면 noArgsConstructor 를 자동으로 만들어주기에 유용하다고 한다.
*/

class RadioButton: Button() // 상속 시 Button 의 생성자를 호출해야 하기에 () 를 통해 빈 생성자를 호출한다.

open class User6(val nickname: String)
class TwitterUser(nickname: String) : User6(nickname) // java 의 super(nickname)

/* 4.2.2 부 생성자 */
open class View {
    // 부 생성자들
    constructor(ctx: Context) {}
    constructor(ctx: Context, attr: AttributeSet) {}
}

/* 4.2.3 인터페이스에 선언된 프로퍼티 구현 */
interface User7 {
    val nickname: String // 추상 프로퍼티 선언: 구현 클래스에 nickname 제공을 강제한다.
}

class PrivateUser(override val nickname: String) : User7
class SubscribingUser(val email: String) : User7 {
    override val nickname: String
        get() = email.substringBefore('@') // custom getter
}
class FacebookUser(val accountId: Int) : User7 {
    override val nickname = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String {
        TODO("Need Facebook API Call")
    }
}

/* 4.2.4 게터와 세터에서 뒷받침하는(?) 필드에 접근 - 필드명과 값을 얘기하는 듯 함 */
class User8(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent())
            field = value
        }
}

/*
    val user = User8("Alice")
    user.address = "New Address"
 */

/* 4.2.5 접근자의 가시성 변경 */
class LengthCounter {
    var counter = 0
        private set // 외부에서 set 불가
    fun addWord(word: String) {
        counter += word.length
    }
}
