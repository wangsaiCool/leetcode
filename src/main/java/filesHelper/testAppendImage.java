package filesHelper;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by WangSai on 2023/3/15
 */
public class testAppendImage {
    private static final String raw = "/home/wangsai/Pictures/WeChat Image_20230518185308.jpg";
    private static final String destPath = "/home/wangsai/Documents/randomFaceImages4/";
    private static final HashSet<byte[]> dedupSet = new HashSet<>();
    private static final Random rand = new Random();

    public static void main(String[] args) throws IOException, InterruptedException {
        byte[] jpgContent = FileUtils.readFileToByteArray(new File(raw));
        byte[] headContent = Arrays.copyOf(jpgContent, jpgContent.length - 8);
        byte[] newContent = new byte[jpgContent.length];
        System.arraycopy(headContent, 0, newContent, 0, headContent.length);

        int count = 1000;
        while (count-- > 0) {
            byte[] tailContent = new byte[8];
            rand.nextBytes(tailContent);
            if (dedupSet.contains(tailContent)) {
                continue;
            } else {
                dedupSet.add(tailContent);
            }
            if (count % 20 == 0) {
                System.out.println(dedupSet.size());
            }
            System.arraycopy(tailContent, 0, newContent, headContent.length, tailContent.length);
            FileUtils.writeByteArrayToFile(new File(destPath + System.currentTimeMillis() + ".jpg"), newContent);
            Thread.sleep(1);

        }
    }
}
