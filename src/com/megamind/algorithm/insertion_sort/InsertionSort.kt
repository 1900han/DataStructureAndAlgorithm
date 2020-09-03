package com.megamind.algorithm.insertion_sort

import com.megamind.algorithm.SortingHelper
import com.megamind.algorithm.generateRandomArray

fun <T : Comparable<T>> insertionSort(arr: Array<T>) {
    for (i in arr.indices) {
        var j = i
        while (j - 1 >= 0) {
            if (arr[j] < arr[j - 1]) {
                SortingHelper.swap(arr, j, j - 1)
            } else {
                break
            }
            j--
        }
/*        while (j > 0 && arr[j] < arr[j - 1]) {
            swap(arr, j, j - 1)
            j--
        }*/
    }
}

fun <T : Comparable<T>> insertionSort2(arr: Array<T>) {
    for (i in arr.indices) {
        val t = arr[i]
        var j = i
        while (j - 1 >= 0 && t < arr[j - 1]) {
            arr[j] = arr[j - 1]
            j--
        }
        arr[j] = t
    }
}

fun <T : Comparable<T>> insertionSort3(arr: Array<T>) {
    for (i in arr.size - 1 downTo 0) {
        val t = arr[i]
        var j = i
        while (j + 1 < arr.size && t > arr[j + 1]) {
            arr[j] = arr[j + 1]
            j++
        }
        arr[j] = t
    }
}

fun main() {
    val dataSize = intArrayOf(10_000, 100_000,1_000_000)
    for (n in dataSize) {
//        println("Random Array : ")
//        val arr = generateRandomArray(n, n)
//        val arr2 = Arrays.copyOf(arr, arr.size)
//        sortTest("insertionSort2", arr)
//        sortTest("selectionSort", arr2)
//        println()
//        println("Ordered Array : ")
//        val arr3 = generateOrderedArray(n)
//        val arr4 = Arrays.copyOf(arr3, arr3.size)
//        sortTest("insertionSort2", arr3)
//        sortTest("selectionSort", arr4)

        val arr5 = generateRandomArray(n, n)
        SortingHelper.sortTest("insertionSort3", arr5)
    }
}