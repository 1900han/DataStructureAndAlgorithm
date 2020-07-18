package com.megamind.algorithm

import com.megamind.algorithm.insertion_sort.insertionSort
import com.megamind.algorithm.insertion_sort.insertionSort2
import com.megamind.algorithm.insertion_sort.insertionSort3
import com.megamind.algorithm.selection_sort.selectionSort
import com.megamind.algorithm.selection_sort.selectionSort2
import java.lang.RuntimeException
import java.math.BigDecimal
import java.math.RoundingMode

fun <T : Comparable<T>> isSorted(arr: Array<T>): Boolean {
    for (i in 1 until arr.size) {
        if (arr[i - 1] > arr[i])
            return false
    }
    return true
}

fun <T : Comparable<T>> sortTest(sortName: String, arr: Array<T>) {
    val startTime = System.nanoTime()
    when (sortName) {
        "selectionSort" -> {
            selectionSort(arr)
        }
        "selectionSort2" -> {
            selectionSort2(arr)
        }
        "insertionSort" -> {
            insertionSort(arr)
        }
        "insertionSort2" -> {
            insertionSort2(arr)
        }
        "insertionSort3" -> {
            insertionSort3(arr)
        }
    }
    val endTime = System.nanoTime()
    val duration = BigDecimal((endTime - startTime) / 1000_000_000.0).setScale(6, RoundingMode.HALF_UP)
    if (!isSorted(arr)) {
        throw RuntimeException("$sortName failed")
    }
    println("$sortName, n = ${arr.size}, time: $duration s")
}

fun <T> swap(arr: Array<T>, i: Int, j: Int) {
    val t = arr[i]
    arr[i] = arr[j]
    arr[j] = t
}