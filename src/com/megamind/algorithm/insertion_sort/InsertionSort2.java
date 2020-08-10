package com.megamind.algorithm.insertion_sort;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

public class InsertionSort2 {
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            while (j - 1 >= 0) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
                j--;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static int[] generateRandomArray(int n, int random) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int num = new Random().nextInt(random);
            arr[i] = num;
        }
        return arr;
    }

    private static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    private static void sortTest(int[] arr) {
        long startTime = System.nanoTime();
        insertionSort(arr);
        long endTime = System.nanoTime();
        BigDecimal duration = new BigDecimal((endTime - startTime) / 1000_000_000.0).setScale(6, RoundingMode.HALF_UP);
        if (!isSorted(arr)) {
            throw new RuntimeException("failed");
        }
        System.out.println("n = " + arr.length + " time: " + duration + " s");
    }

    public static void main(String[] args) {
        int[] integers = generateRandomArray(1000000, 1000000);
        sortTest(integers);
    }
}
