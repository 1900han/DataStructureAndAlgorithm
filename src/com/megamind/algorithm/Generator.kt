package com.megamind.algorithm

import kotlin.random.Random

fun generateOrderedArray(n: Int): Array<Int> {
    val arr = Array(n) { 0 }
    for (i in 0 until n) {
        arr[i] = i
    }
    return arr
}

fun generateRandomArray(n: Int, bound: Int): Array<Int> {
    val arr = Array(n) { 0 }
    for (i in 0 until n) {
        arr[i] = Random.nextInt(bound)
    }
    return arr
}