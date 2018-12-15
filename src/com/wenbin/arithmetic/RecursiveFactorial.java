package com.wenbin.arithmetic;

/**
 * 递归阶乘
 */
public class RecursiveFactorial {

    public int factorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            int subSolution = factorial(n - 1);
            int solution = subSolution * n;
            return solution;
        }
    }

    public static void main(String[] args) {
        RecursiveFactorial rf = new RecursiveFactorial();


        System.out.println(rf.factorial(7));
    }
}
