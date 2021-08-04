package com.chandler.algorithms.sorting;

import java.util.ArrayList;
import java.util.Random;

public class InsertionSort {

    public static void sort(int n, int numTimes) {
        System.out.printf("Insertion sorting array with size of %d %d times\n", n, numTimes);
        var times = new ArrayList<Long>();

        for (int x = 0; x < numTimes; x++) {
            int[] arr = new Random().ints(n, 0, 101).toArray();
            var start = System.currentTimeMillis();

            for (int i = 1; i < arr.length; i++) {
                int key = arr[i];
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }

            var finish = System.currentTimeMillis();
            var timeElapsed = finish - start;
            times.add(timeElapsed);
        }

        long averageTime = times.stream().mapToLong(Long::valueOf).sum() / times.size();
        System.out.printf("Insertion sort completed - average sort time of %sms", averageTime);
    }
}
