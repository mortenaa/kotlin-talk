fun main(args: Array<String>) {
    println("Hello, World!")
    println(max(12, 24))
    println(sum(4, 5))
}

fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}

fun sum(a: Int, b: Int) = a + b