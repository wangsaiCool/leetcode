/**
 * Created by WangSai on 2/20/19
 */
public class P344_ReverseString {
    public void reverseString(char[] s) {
        for (int i = 0; i < s.length/2; i++) {
            int left = i;
            int right = s.length - 1 - i;
            char tmp = s[left];
            s[left]=s[right];
            s[right]=tmp;
        }
    }

    public static void main(String[] args) {
        char[] s = "hello".toCharArray();
        new P344_ReverseString().reverseString(s);
        for(char single:s){
            System.out.print(single);
        }
    }
}
