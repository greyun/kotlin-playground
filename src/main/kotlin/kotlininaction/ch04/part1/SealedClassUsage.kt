package kotlininaction.ch04.part1

/*
기존 Expr 인터페이스를 sealed class 로 변경하고 구현 클래스들을 중첩 클래스로 명시했다.

interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr
 */
sealed class Expr {
    class Num(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int =
    when (e) {
        is Expr.Num -> e.value
        is Expr.Sum -> eval(e.right) + eval(e.left)
        /*
        when 식에서 sealed 클래스의 모든 하위 클래스를 처리하므로 디폴트 분기(else 분기)가 필요 없어진 모습
        else ->
            throw IllegalArgumentException("Unknown expression")
         */
    }
