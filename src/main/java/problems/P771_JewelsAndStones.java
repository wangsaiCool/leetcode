package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WangSai on 8/6/18
 */
public class P771_JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        int total = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if (J.charAt(i) == S.charAt(j)) {
                    total++;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String J = stringToString(line);
            line = in.readLine();
            String S = stringToString(line);
            int ret = new P771_JewelsAndStones().numJewelsInStones(J, S);
            String out = String.valueOf(ret);
            System.out.println(out);
        }
    }

    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }
}
