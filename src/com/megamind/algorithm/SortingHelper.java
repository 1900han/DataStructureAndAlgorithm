package com.megamind.algorithm;

import com.megamind.algorithm.insertion_sort.InsertionSortKt;
import com.megamind.algorithm.selection_sort.SelectionSortKt;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.megamind.algorithm.merge_sort.MergeSortKt.mergeSort;

public class SortingHelper {
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static <E> void swap(E[] array, int i, int j) {
        E t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static <E extends Comparable<E>> void sortTest(String sortName, E[] arr) {
        long startTime = System.nanoTime();
        switch (sortName) {
            case "selectionSort": {
                SelectionSortKt.selectionSort(arr);
                break;
            }
            case "selectionSort2": {
                SelectionSortKt.selectionSort2(arr);
                break;
            }
            case "insertionSort": {
                InsertionSortKt.insertionSort(arr);
                break;
            }
            case "insertionSort2": {
                InsertionSortKt.insertionSort2(arr);
                break;
            }
            case "insertionSort3": {
                InsertionSortKt.insertionSort3(arr);
                break;
            }
            case "mergeSort": {
                mergeSort(arr);
                break;
            }
            default:
                break;
        }
        long endTime = System.nanoTime();
        BigDecimal duration = new BigDecimal((endTime - startTime) / 1000_000_000.0).setScale(6, RoundingMode.HALF_UP);
        if (!isSorted(arr)) {
            throw new RuntimeException(sortName + " failed");
        }
        System.out.println(sortName + " n = " + arr.length + ", time: " + duration + " s");
    }
}
