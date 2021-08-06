package com.chandler.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) >>> 1;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int length = right - left + 1;
        int[] temp = new int[length];
        int i = left;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, left, length);
    }

    public static void main(String[] args) {
        var arr = new Random()
                .ints(30, 0, 101)
                .toArray();

        System.out.println(Arrays.toString(arr));
        MergeSort.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
