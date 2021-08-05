package com.chandler.algorithms.sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            // non-increasing: arr[j] < key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        var arr = new Random().ints(30, 0, 101).toArray();
        InsertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
