package com.megamind.algorithm.quick_sort;

import com.megamind.algorithm.SortingHelper;

/**
 * 可能退化成n^2
 */
public class QuickSort {
    private QuickSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] array) {
        sort(array, 0, array.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(array, l, r);
        sort(array, l, p - 1);
        sort(array, p + 1, r);
    }

    private static <E extends Comparable<E>> int partition(E[] array, int l, int r) {
        // arr[l+1...j] < v ; arr[j+1...r] >= v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (array[i].compareTo(array[l]) < 0) {
                j++;
                SortingHelper.swap(array, i, j);
            }
        }
        SortingHelper.swap(array, l, j);
        return j;
    }
}
