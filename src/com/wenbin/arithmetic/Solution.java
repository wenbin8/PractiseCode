package com.wenbin.arithmetic;

import edu.princeton.cs.algs4.BinarySearch;

import java.util.Arrays;

/**
 * Created by wenbin on 2018/1/8.
 */
public class Solution {
    public static void main(String args[]) {
        Solution solution = new Solution();
        System.out.println(solution.permutation("abc", "cba"));
        System.out.println(solution.permutation("aaac", "ccca"));
    }

    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean permutation(String A, String B) {

        if (A.length() != B.length()) {
            return false;
        }

        char aArray[] = A.toCharArray();
        char bArray[] = B.toCharArray();

        Arrays.sort(aArray);
        Arrays.sort(bArray);

        for (int i = 0; i < aArray.length; i++) {
            if (aArray[i] != bArray[i]) {
                return false;
            }
        }
        return true;
    }
}
