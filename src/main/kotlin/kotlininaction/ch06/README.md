# 6. 코틀린 타입 시스템

**다루는 내용**
* 널이 될 수 있는 타입과 널을 처리하는 구문의 문법
* 코틀린 원시 타입 소개와 자바 타입과 코틀린 원시 타입의 관계
* 코틀린 컬렉션 소개와 자바 컬렉션과 코틀린 컬렉션의 관계

## 6.1 널 가능성(Nullability)

개발자들을 당황시키는 NPE 를 미연에 방지하기 위해 null check 시점을 가능한 컴파일 시점으로 옮긴다.

### 6.1.1 널이 될 수 있는 타입

코틀린은 기본적으로 명시된 모든 타입에 null 인자가 전달될 때 compile 에러를 발생시킨다.

```
/* java */
int strLen(String s) {
    return s.length();
}
strLen(null) // Runtime 에러 발생 -> NPE

/* kotlin */
fun strLen(s: String) = s.length
strLen(null) // Compile 에러 발생 -> ERROR: Null can not be a value of a non-null type String
```

null 참조를 저장하려면 타입 옆에 ? 키워드를 명시해야 한다.
```
fun strLenSafe(s: String?) = ...
```

널이 될 수 있는 타입인 변수에 대해 메서드를 직접 호출할 수 없다.
```
fun strLenSafe(s: String?) = s.length
// ERROR: Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String?
```

널이 될 수 있는 값을 널이 될 수 없는 타입의 변수에 대입할 수 없다.
```
val x: String? = null
val y: String = x
// ERROR: Type mismatch. Required: String, Found: String?
```

널이 될 수 있는 타입의 값을 널이 될 수 없는 타입의 파라미터를 받는 함수에 전달할 수 없다.
```
strLen(x)
// ERROR: Type mismatch. Required: String, Found: String?
```

null check 를 하면 컴파일러가 이 사실을 인지하고 nullable 타입도 not-null 타입처럼 사용할 수 있다.
```
fun strLen(s: String) = if (s != null) s.length else 0
```

### 6.1.2 타입의 의미

동일한 타입의 변수에 대한 연산을 컴파일러가 통과시킨 경우 그 연산이 잘 실행되리라 보장 받을 수 있다.

double 과 Java 변수를 비교했을 때 자바에서 String 타입에는 문자열과 null 이라는 두 가지 종류의 값이 들어간다. 이 두 종류의 값은 서로 완전히 다르다. null 인 경우에 사용하지 못하는 연산이 많아진다.

이는 자바의 타입 시스템이 null 을 제대로 다루지 못다는 뜻이다.(명치샷) 매번 null check 가 필요.

그래서 코틀린은 nullable, not-null 타입을 구분해 각 타입의 값에 대해 가능한 연산을 명확히 하고, 실행 시점에 예외 발생 가능성을 판단할 수 있게 한다. -> 모두 컴파일 단계에서

### 6.1.3 안전한 호출 연산자: ?.

`?.`연산자는 null check 와 메서드 호출을 한 번의 연산으로 수행한다.
```
s?.length()
-> if (s != null) s.length() else null
```

### 6.1.4 엘비스 연산자: ?:

`?:`연산자는 null check 와 값 반환을 한 번의 연산으로 수행한다.
```
val s: String = s ?: ""
-> val s: String = if (s != null) s else ""
```

`?.`+`?:` 두 연산자를 함께 사용하면 유용하다.
```
fun strLenSafe(s: String?) : Int = s?.length ?: 0
```

### 6.1.5 안전한 캐스트: as?

`as?`연산자는 `as` 연산자의 Type check 기능이 추가된 버전이라고 보면 된다.
```
fun some(o: Any?): Boolean {
    val otherPerson = o as Person ?: return false
    return otherPerson.name == name
}
```

### 6.1.6 널 아님 선언: !!

`!!`연산자는 컴파일러에게 직접 이 값은 널이 아니라는 사실을 전달함

코틀린 설계자들은 "이거 쓰지 말고 더 좋은 방법 찾아봐" 라는 의도로 `!!` 라는 못생긴 기호를 택했다고 함...
```
fun strLenSafe(s: String?) = s!!.length
strLenSafe(null)
// 컴파일 에러는 사라지지만 null 전달 시 런타임 오류가 발생한다. -> NPE
```

### 6.1.7 let 연산자

> javascript 의 `let` 아니다.

`let` 연산자는 null 이면 람다를 실행하지 않는다.
```
fun getTheBestPersonInTheWorld() : Person? = null

val person: Person? = getTheBestPersonInTheWorld()
if (person != null) sendEmailTo(person.name)
-> getTheBestPersonInTheWorld()?.let { sendEmailTo(it.name) }
```

### 6.1.8 프로퍼티 초기화 지연: lateinit
