import java.util.HashSet;

/**
 * Created by WangSai on 8/9/18
 */
public class P804_UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        String[] list = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String morseCode = "";
            for (int j = 0; j < word.length(); j++) {
                morseCode += list[word.charAt(j) - 'a'];
            }
            set.add(morseCode);
        }
        return set.size();
    }
}
