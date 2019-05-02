package Problems;


import java.util.ArrayList;
import java.util.List;

/**
 * 题目链接： https://leetcode.com/problems/fizz-buzz/
 * <p>
 * Write a program that outputs the string representation of numbers from 1 to n.
 * <p>
 * But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 * <p>
 * Example:
 * <p>
 * n = 15,
 * <p>
 * Return:
 * [
 * "1",
 * "2",
 * "Fizz",
 * "4",
 * "Buzz",
 * "Fizz",
 * "7",
 * "8",
 * "Fizz",
 * "Buzz",
 * "11",
 * "Fizz",
 * "13",
 * "14",
 * "FizzBuzz"
 * ]
 */
public class P412_FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();
        int record3 = 3;
        int record5 = 5;
        for (int count = 1; count <= n; count++) {
            if (count == record3 && count == record5) {
                record3 += 3;
                record5 += 5;
                list.add("FizzBuzz");
            } else if (count == record5 && count != record3) {
                record5 += 5;
                list.add("Buzz");
            } else if (count != record5 && count == record3) {
                record3 += 3;
                list.add("Fizz");
            } else {
                list.add(String.valueOf(count));
            }
        }
        return list;
    }

}
