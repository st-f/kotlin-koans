package v_builders.examples

import java.util.*

fun todoTask38(): Nothing = TODO(
    """
        Task 38.
        The previous examples can be rewritten with the library function 'apply' (see examples below).
        Write your own implementation of the function 'apply' named 'myApply'.
    """
)

fun <T, R> myApply(receiver: T, f: T.() -> R): R {
    return receiver.f()
}

fun buildString(): String {
    val stringBuilder = StringBuilder()
    myApply (stringBuilder) {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }
    return stringBuilder.toString()
}

fun buildMap(): Map<Int, String> {
    val map = HashMap<Int, String>()
    myApply (map) {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
    return map
}

/*
fun <T> T.myApply(f: T.() -> Unit): T { return this.apply(f) }

fun createString(): String {
    return StringBuilder().myApply {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }.toString()
}

fun createMap(): Map<Int, String> {
    return hashMapOf<Int, String>().myApply {
        put(0, "0")
        for (i in 1..10) {
            put(i, "$i")
        }
    }
}

 */