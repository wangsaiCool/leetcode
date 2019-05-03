package Problems;

/**
 * 题目链接：https://leetcode.com/problems/remove-outermost-parentheses/
 * <p>
 * <p>
 * 题目描述：
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 * <p>
 * A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
 * <p>
 * Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 * <p>
 * Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 * Example 2:
 * <p>
 * Input: "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:
 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 * Example 3:
 * <p>
 * Input: "()()"
 * Output: ""
 * Explanation:
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 * <p>
 * <p>
 * Note:
 * <p>
 * S.length <= 10000
 * S[i] is "(" or ")"
 * S is a valid parentheses string
 */

public class P1021_RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        if (S == null || S.length() == 0) {
            return result.toString();
        }
        for (int index = 0; index < S.length(); index++) {
            char content = S.charAt(index);
            if (content == '(') {
                count++;
                if (count != 1) {
                    result.append(content);
                }
            } else if (content == ')') {
                count--;
                if (count != 0) {
                    result.append(content);

                }
            }
        }
        return result.toString();
    }

}
