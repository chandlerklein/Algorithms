package com.chandler.algorithms.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LongestSubsequence {

    public static int length(int[] nums) {
        var set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int result = 0;

        while (!set.isEmpty()) {
            var seed = set.iterator().next();
            int count = 0;
            int left = seed - 1;
            int right = seed;
            while (set.remove(left--)) count++;
            while (set.remove(right++)) count++;
            result = Math.max(count, result);
        }
        return result;
    }

    public static void main(String[] args) {
        var nums = new int[]{0, 9, 5, 1, 4, 2, 3, 6};
        int longestSubsequence = LongestSubsequence.length(nums);
        System.out.println("Length of longest subsequence is: " + longestSubsequence);
    }
}
