package com.megamind.algorithm.quick_sort.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * 最小的k个数
 */
public class GetLeastNumbers {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        Random rand = new Random();
        // 求的是第 k 小的数字，对应的索引是 k - 1
        selectK(arr, 0, arr.length - 1, k - 1, rand);
        return Arrays.copyOf(arr, k);
    }

    private int selectK(int[] arr, int l, int r, int k, Random rand) {
        int p = partition(arr, l, r, rand);
        if (k == p) return arr[p];
        if (k < p) return selectK(arr, l, p - 1, k, rand);
        return selectK(arr, p + 1, r, k, rand);
    }

    private int partition(int[] arr, int l, int r, Random rand) {
        int p = l + rand.nextInt(r - l + 1);
        swap(arr, l, p);

        int i = l + 1;
        int j = r;

        while (true) {
            while (i <= j && arr[i] < arr[l]) {
                i++;
            }
            while (j >= i && arr[j] > arr[l]) {
                j--;
            }

            if (i >= j) {
                break;
            }
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
