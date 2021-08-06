package com.chandler.algorithms.sort;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class BinaryInsertionSort {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            int index = binarySearch(arr, 0, j, key);

            while (j >= index) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    private static int binarySearch(int[] arr, int left, int right, int key) {
        if (right <= left) {
            return key > arr[left] ? left + 1 : left;
        }
        int mid = (left + right) >>> 1;
        if (key == arr[mid]) {
            return mid + 1;
        } else if (key < arr[mid]) {
            return binarySearch(arr, 0, mid - 1, key);
        } else {
            return binarySearch(arr, mid + 1, right, key);
        }
    }


    public static void main(String[] args) {
        var r = ThreadLocalRandom.current();
        int streamSize = 10;
        int randomNumberBound = 1000;

        var arr = r.ints(streamSize, 0, randomNumberBound)
                .toArray();

        System.out.printf("Binary insertion sorting array%n%s%n", Arrays.toString(arr));
        BinaryInsertionSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
