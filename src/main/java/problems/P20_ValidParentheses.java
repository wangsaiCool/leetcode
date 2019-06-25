package Problems;

import java.util.Stack;

/**
 * Created by WangSai on 2019-06-24 23:00
 *
 * 题目链接：https://leetcode.com/problems/valid-parentheses/
 *
 * 题目描述：
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */

public class P20_ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<Character>();
        for (char sub : s.toCharArray()) {
            switch (sub) {
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                default:
                    stack.push(sub);
            }
        }
        return stack.isEmpty();
    }

}
