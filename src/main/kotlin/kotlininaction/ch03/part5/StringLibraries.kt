package kotlininaction.ch03.part5

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("dir: $directory, name: $fileName, ext: $extension")
}

fun main() {
    parsePath("/Users/greyun/kotlin-book/chapter.adoc") // dir: /Users/greyun/kotlin-book, name: chapter, ext: adoc
}
