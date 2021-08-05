package problems;

/**
 * Created by WangSai on 3/16/19.
 */

class P942_DIStringMatch {
    public int[] diStringMatch(String S) {
        int lo = 0;
        int hi = S.length();
        int[] arr = new int[S.length() + 1];


        for (int i = 0; i < S.length(); i++) {
            char letter = S.charAt(i);
            if (letter == 'I') {
                arr[i] = lo++;
            } else {
                arr[i] = hi--;
            }

        }
        arr[S.length()] = lo;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        return arr;
    }

    public static void main(String[] args) {
        String s = "IDID";
        new P942_DIStringMatch().diStringMatch(s);
    }
}



