package com.megamind.ds.selection_sort

import com.megamind.ds.generateRandomArray
import com.megamind.ds.sortTest
import com.megamind.ds.swap

fun <T : Comparable<T>> selectionSort(arr: Array<T>) {
    val size = arr.size
    for (i in 0 until size) {
        var minIndex = i
        var j = i
        while (j < size) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j
            }
            j++
        }
        swap(arr, i, minIndex)
    }
}

fun <T : Comparable<T>> selectionSort2(arr: Array<T>) {
    val size = arr.size
    for (i in size - 1 downTo 0) {
        var minIndex = i
        var j = i
        while (j >= 0) {
            if (arr[j] > arr[minIndex]) {
                minIndex = j
            }
            j--
        }
        swap(arr, i, minIndex)
    }
}


fun main() {
    val dataSize = intArrayOf(10_000, 100_000)
    for (n in dataSize) {
        val arr = generateRandomArray(n, n)
        sortTest("selectionSort", arr)
        sortTest("selectionSort2", arr)
    }
}
