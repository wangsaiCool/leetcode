package Problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WangSai on 10/16/18.
 */
public class P500_KeyboardRow {
    public String[] findWords(String[] words) {
        if (words == null || words.length == 0) {
            return words;
        }
        List<String> list = new ArrayList<String>();
        for (String word : words) {
            if (isKeyboardRow(word)) {
                list.add(word);
            }
        }
        String[] result = new String[list.size()];
        int index = 0;
        for (String str : list) {
            result[index++] = str;
        }
        return result;
    }

    private boolean isKeyboardRow(String word) {
        if (word == null || word.length() == 0) {
            return false;
        }
        String line1 = "QWERTYUIOP";
        String line2 = "ASDFGHJKL";
        String line3 = "ZXCVBNM";
        boolean flag1 = true;
        boolean flag2 = true;
        boolean flag3 = true;

        for (int i = 0; i < word.length(); i++) {
            String c = word.charAt(i) + "";
            if (!line1.contains(c.toUpperCase())) {
                flag1 = false;
            }
            if (!line2.contains(c.toUpperCase())) {
                flag2 = false;
            }
            if (!line3.contains(c.toUpperCase())) {
                flag3 = false;
            }
        }
        return flag1 || flag2 || flag3;
    }

    public static void main(String[] args) {
        P500_KeyboardRow t = new P500_KeyboardRow();
        String[] arr = {"Hello", "Alaska", "Dad", "Peace"};
        String[] result = t.findWords(arr);
        for (String str : result) {
            System.out.print(str + " ");
        }
    }
}
