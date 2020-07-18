package com.megamind.ds.stack

fun main() {
    val stack = ArrayStack<Int>()
    for (i in 0 until 5) {
        stack.push(i)
        println(stack)
    }
    stack.pop()
    println(stack)
}