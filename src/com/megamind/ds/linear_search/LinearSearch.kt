package com.megamind.ds.linear_search

import com.megamind.ds.generateOrderedArray


fun <T> linearSearch(data: Array<T>, target: T): Int {
    data.forEachIndexed { index, _ ->
        if (data[index] == target) {
            return index
        }
    }
    return -1
}




fun main() {
    val dataSize = intArrayOf(1_000_000, 1_000_000_0)
    for (n in dataSize) {
        val intArray = generateOrderedArray(n)
        val startTime = System.nanoTime()
        for (i in 0..1000) {
            linearSearch(intArray, n)
        }
        val endTime = System.nanoTime()
        val duration = (endTime - startTime) / 1000_000_000.0
        println("n=$n, 100 runs: time: $duration")
    }
}