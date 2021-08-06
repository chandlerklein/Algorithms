package com.chandler.algorithms.sort;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        var arr = new Random().ints(30, 0, 101).toArray();
        System.out.println(Arrays.toString(arr));
        SelectionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
