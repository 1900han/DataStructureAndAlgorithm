package com.megamind.algorithm.merge_sort

import com.megamind.algorithm.generateRandomArray
import com.megamind.algorithm.sortTest
import java.util.*

fun <E : Comparable<E>> merge(arr: Array<E>, l: Int, mid: Int, r: Int) {
    val temp = Arrays.copyOfRange(arr, l, r + 1)

    var i = l
    var j = mid + 1

    for (k in l..r) {
        if (i > mid) {
            arr[k] = temp[j - l]
            j++
        } else if (j > r) {
            arr[k] = temp[i - l]
            i++
        } else if (temp[i - l] <= temp[j - l]) {
            arr[k] = temp[i - l]
            i++
        } else {
            arr[k] = temp[j - l]
            j++
        }
    }
}

fun <E : Comparable<E>> mergeSort(arr: Array<E>) {
    mergeSort(arr, 0, arr.size - 1)
}

private fun <E : Comparable<E>> mergeSort(arr: Array<E>, l: Int, r: Int) {
    if (l >= r) {
        return
    }
    val mid = l + (r - l) / 2
    mergeSort(arr, l, mid)
    mergeSort(arr, mid + 1, r)
    merge(arr, l, mid, r)
}

fun main() {
    val dataSize = intArrayOf(10_000, 100_000, 1_000_000)
    for (n in dataSize) {
        val arr = generateRandomArray(n, n)
        sortTest("mergeSort", arr)
    }
}

