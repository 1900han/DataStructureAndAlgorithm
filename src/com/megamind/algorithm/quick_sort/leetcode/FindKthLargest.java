package com.megamind.algorithm.quick_sort.leetcode;

import java.util.Random;

/**
 * 求第 k 大元素
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Random random = new Random();
        /**
         * 将求第 k 大元素的这个 k ，转换成对应求的是第几小元素对应的索引
         * 如：k 是 1，就是要找最大元素，对应的 selectK 的索引，就是 nums.length - 1
         * 如：k 是 nums.length ，就是要找最小元素，对应的 selectK 的索引，就是 0
         * 之间的转换关系是 nums.length - k
         */
        return selectK(nums, nums.length - k, random);
    }

    private int selectK(int[] nums, int k, Random rand) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int p = partition(nums, l, r, rand);
            if (k == p) return nums[p];
            if (k < p)
                r = p - 1;
            else
                l = p + 1;
        }
        throw new RuntimeException("No solution");
    }

    private int selectKRecursion(int[] nums, int l, int r, int k, Random random) {
        int p = partition(nums, l, r, random);
        if (k == p) return nums[p];

        if (k < p) return selectKRecursion(nums, l, p - 1, k, random);
        return selectKRecursion(nums, p + 1, r, k, random);
    }

    private int partition(int[] nums, int l, int r, Random random) {

        int p = l + random.nextInt(r - l + 1);
        swap(nums, l, p);

        int i = l + 1;
        int j = r;
        while (true) {
            while (i <= j && nums[i] < nums[l]) {
                i++;
            }
            while (j >= i && nums[j] > nums[l]) {
                j--;
            }
            if (i >= j)
                break;
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
