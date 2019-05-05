package Problems;


/**
 * 题目链接:
 * https://leetcode.com/problems/divisor-game/
 * <p>
 * 题目描述；
 * <p>
 * Alice and Bob take turns playing a game, with Alice starting first.
 * <p>
 * Initially, there is a number N on the chalkboard.  On each player's turn, that player makes a move consisting of:
 * <p>
 * Choosing any x with 0 < x < N and N % x == 0.
 * Replacing the number N on the chalkboard with N - x.
 * Also, if a player cannot make a move, they lose the game.
 * <p>
 * Return True if and only if Alice wins the game, assuming both players play optimally.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 * Example 2:
 * <p>
 * Input: 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 1000
 *
 *
 * 解题思路：
 * 一开始我的思路的是类似素数筛选法一样，初始条件 n=1必败，然后遍历 i=1 to n,如果 n=i 必败，则有n = xx 必胜。
 * 提交完发现才打败了30%+，我猜肯定有什么取巧的办法，又在纸上多手工递推了几个，发现所有必败的都是奇数，必胜的都是偶数。
 * 这里用数学归纳法证明一下：
 * 假设对于 i<=n 都有，
 *
 * i 为奇数，必败
 * i 为偶数，必胜
 * 则对于 i=n+1 ，则有
 *
 * i 为奇数，则无论如何选择，由于不存在偶数 x 使得 i % x==0, 则 x 必为奇数，则 i-x 必为偶数，i-x <=n，所以对手拿到 i-x以后必胜，则我方必败。
 * i 为偶数，我方直接选择 x=1, 将 i-1 即 n 交给对方，对方拿到 n（n<=n） 以后必败，则我方必胜。
 * 且显而易见的有
 * i=1, 必败
 * i=2, 必胜
 * 即对i<=2 成立，则对于 i 属于任意正整数都成立。
 */

public class P1025_DivisorGame {
    public boolean divisorGame(int N) {

        return N % 2 == 0;

    }
}
