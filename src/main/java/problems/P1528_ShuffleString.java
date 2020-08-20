package problems;

/**
 * Created by WangSai on 2020/8/20
 */
public class P1528_ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] ans = new char[indices.length];

        for (int index = 0; index < indices.length; index++) {
            ans[indices[index]] = s.charAt(index);
        }
        return new String(ans);

    }
}
