package problems;

/**
 * Created by WangSai on 2019-05-19 22:29
 *
 * 题目链接：https://leetcode.com/problems/fibonacci-number/
 *
 * 题目描述：斐波那切数列
 * */


public class P509_FibonacciNumber {
    public int fib(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        return fib(N-2) + fib(N - 1);
    }

    public int fib1(int N) {

        if (N == 0 || N == 1) {
            return N;
        }

        int pre = 0;
        int sum = 1;
        int count = 2;
        while (count++ <= N) {
            int now = sum;
            sum += pre;
            pre = now;

        }

        return sum;
    }
}
