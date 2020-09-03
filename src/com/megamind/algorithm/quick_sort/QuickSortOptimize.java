package com.megamind.algorithm.quick_sort;

import com.megamind.algorithm.GeneratorKt;
import com.megamind.algorithm.SortingHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * 对于数组里都是相等的数据，速度退化成n^2
 */
public class QuickSortOptimize {
    private QuickSortOptimize() {
    }

    public static <E extends Comparable<E>> void sort(E[] array) {
        Random random = new Random();
        sort(array, 0, array.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort(E[] array, int l, int r, Random random) {
        if (l >= r) {
            return;
        }
        int p = partition(array, l, r, random);
        sort(array, l, p - 1, random);
        sort(array, p + 1, r, random);
    }

    private static <E extends Comparable<E>> int partition(E[] array, int l, int r, Random random) {
        // 生成 [l,r] 之间的随机索引
        int p = l + random.nextInt(r - l + 1); // +1 是nextInt() 前闭后开
        SortingHelper.swap(array, l, p);
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

    public static void main(String[] args) {
        int n = 1000000;

        Integer[] arr = GeneratorKt.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("mergeSort", arr);
        SortingHelper.sortTest("QuickSortOptimize", arr2);

        arr = GeneratorKt.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("mergeSort", arr);
        SortingHelper.sortTest("QuickSortOptimize", arr2);
    }
}
