package kotlininaction.ch03

fun main() {
    performOperation()
    reportOperationCount()

    print("separator $UNIX_LINE_SEPERATOR")
}

fun reportOperationCount() {
    println("Operation performed $opCount times")
}
