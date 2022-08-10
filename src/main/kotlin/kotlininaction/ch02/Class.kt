package kotlininaction.ch02

class Person (val name: String, var isMarried: Boolean)

/* java */
/*
public class ch02.Person {
    private final String name;

    public ch02.Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
*/

fun main() {
    val person = Person("Greyun", false)
    person.isMarried = true
    println(person.name)
    println(person.isMarried)
    println(person)
}
