import java.util.*

//var x: Int = null

var y: Int? = null

var z = null

fun main(args: Array<String>) {

    val y: String? = if (Random().nextBoolean()) "foo" else null

    // println(y.length) // Unsafe, does not compile

    //println(y!!.length) // Unsafe, compiles

    if (y != null) {
        println(y.length) // safe
    }

    y.let {               // safe
        println(it)
    }

    val l = if (y != null) y.length else -1

    val m = y?.length ?: -1

    println(l + m)

    println(doSomething(42))
}

fun doSomething(something: Any): Int {
    val x = when (something) {
        is String -> something.length
        is Int -> something
        is List<*> -> something.size
        else -> -1
    }
    return x
}