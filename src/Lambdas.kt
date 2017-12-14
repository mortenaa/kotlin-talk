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
    val sum = list.filter { i -> i > 12 }.map { i -> i * 2 }.sum()
    println(sum)
    val max = list.filter { it.rem(2) == 0 }.max()
    println(max)
    println(list.groupBy { v -> v.rem(2) })
    println(list.partition { it.rem(2) == 0 })
    val things = listOf("A", 42, 3.14, "Foo", Pair(1, 2))
    val sum1 = things
            .filter { it is Int }
            .map { it as Int }
            .map { it * 2 }
            .sum()
    println(sum1)

    val sumIt = { x: Int, y: Int -> x + y }
    sumIt(1, 2)

}