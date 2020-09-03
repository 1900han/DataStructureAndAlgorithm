package com.megamind.algorithm.quick_sort;

import com.megamind.algorithm.GeneratorKt;
import com.megamind.algorithm.SortingHelper;

import java.util.Arrays;
import java.util.Random;

public class QuickSort3Ways {
    private QuickSort3Ways() {
    }

    public static <E extends Comparable<E>> void sort(E[] array) {
        Random random = new Random();
        sort(array, 0, array.length - 1, random);
    }

    private static <E extends Comparable<E>> void sort(E[] array, int l, int r, Random random) {
        if (l >= r) {
            return;
        }
        partition(array, l, r, random);
    }

    private static <E extends Comparable<E>> void partition(E[] array, int l, int r, Random random) {
        // 生成 [l,r] 之间的随机索引
        int p = l + random.nextInt(r - l + 1); // +1 是nextInt() 前闭后开
        SortingHelper.swap(array, l, p);
        // arr[l+1...lt] < v ; arr[lt+1...i-1] == v ; arr[gt...r] > v
        int lt = l;
        int i = l + 1;
        int gt = r + 1;
        while (i < gt) {
            if (array[i].compareTo(array[l]) < 0) {
                lt++;
                SortingHelper.swap(array, i, lt);
                i++;
            } else if (array[i].compareTo(array[l]) > 0) {
                gt--;
                SortingHelper.swap(array, i, gt);
            } else {
                i++;
            }
        }
        SortingHelper.swap(array, l, lt);
        // arr[l...lt-1] < v ; arr[lt...gt-1] == v ; arr[gt...r] > v
        sort(array, l, lt - 1, random);
        sort(array, gt, r, random);
    }

    public static void main(String[] args) {
        int n = 100000;

        Integer[] arr = GeneratorKt.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        System.out.println("Random Array");
        SortingHelper.sortTest("QuickSortOptimize", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);
        System.out.println();

        arr = GeneratorKt.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        System.out.println("Ordered Array");
        SortingHelper.sortTest("QuickSortOptimize", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);
        System.out.println();

        arr = GeneratorKt.generateRandomArray(n, 1);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);
        System.out.println("Same Value Array");
        SortingHelper.sortTest("QuickSortOptimize", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);
    }
}
