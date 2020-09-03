package com.megamind.algorithm.quick_sort;

import com.megamind.algorithm.GeneratorKt;
import com.megamind.algorithm.SortingHelper;

import java.util.Arrays;
import java.util.Random;

public class QuickSort2Ways {
    private QuickSort2Ways() {
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
        // arr[l+1...i-1] <= v ; arr[j+1...r] >= v
        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && array[i].compareTo(array[l]) < 0) {
                i++;
            }
            while (j >= i && array[j].compareTo(array[l]) > 0) {
                j--;
            }
            if (i >= j) break;
            SortingHelper.swap(array, i, j);
            i++;
            j--;
        }
        SortingHelper.swap(array, l, j);
        return j;
    }

    public static void main(String[] args) {
        int n = 100000;

        Integer[] arr = GeneratorKt.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println("Random Array");
        SortingHelper.sortTest("QuickSortOptimize", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        System.out.println();

        arr = GeneratorKt.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println("Ordered Array");
        SortingHelper.sortTest("QuickSortOptimize", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        System.out.println();

        arr = GeneratorKt.generateRandomArray(n, 1);
        arr2 = Arrays.copyOf(arr, arr.length);
        System.out.println("Same Value Array");
        SortingHelper.sortTest("QuickSortOptimize", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
    }
}
