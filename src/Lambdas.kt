fun doIt(value: Int, body: (Int) -> Int): Int {
    return body(value)
}


fun main(args: Array<String>) {
    doIt(10, { v -> 16 * v})
    doIt(10, { it * 16 })
    doIt(10) { it * 16 }

    doIt(42) {
        16
    }.let {
        println(it)
    }

    val list: List<Int> = listOf(10, 11, 12, 13, 14, 15)
    val sum = list.filter { it -> it > 12 }.map { it -> it * 2 }.sum()
    println(sum)
    val max = list.filter { it -> it.rem(2) == 0 }.max()
    println(max)
    println(list.groupBy { it -> it.rem(2) })
}