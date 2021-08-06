package search;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class BinarySearch {

    public static int search(int[] arr, int left, int right, int key) {
        if (right < left) {
            return -1;
        }
        int mid = (left + right) >>> 1;

        if (key == arr[mid]) {
            return mid;
        } else if (key < arr[mid]) {
            return search(arr, 0, mid - 1, key);
        } else {
            return search(arr, mid + 1, right, key);
        }
    }

    public static void main(String[] args) {
        var r = ThreadLocalRandom.current();
        int streamSize = 10;
        int randomNumberBound = 1000;

        var arr = r.ints(streamSize, 0, randomNumberBound)
                .sorted()
                .toArray();

        int key = arr[r.nextInt(streamSize)];

        System.out.printf("Looking for %d in %s%n", key, Arrays.toString(arr));
        var index = BinarySearch.search(arr, 0, arr.length, key);
        System.out.printf("Found %d at index %d", key, index);
    }
}
