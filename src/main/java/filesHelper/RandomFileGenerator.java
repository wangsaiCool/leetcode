package filesHelper;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by WangSai on 2022/6/20
 */
public class RandomFileGenerator {
    private static final int ONE_MB = 1024 * 1024;

    public static void main(String[] args) throws IOException {

        String content = "12345";
        String substring = StringUtils.substring(content, 0, 1);
        System.out.println(substring);

//        String path = "/tmp/";
//        int folderCnt = 3;
////        while (folderCnt-- > 0) {
//        int fileCnt = 20;
//        while (fileCnt-- > 0) {
//            generateRandomFile(path + addPrefixZero(folderCnt, 2) + "/", fileCnt, ONE_MB * 100);
//        }
////        }

    }

    private static void generateRandomFile(String path, int index, int size) throws IOException {
        String realPath = path + "batch_del_test_" + addPrefixZero(index, 8) + ".txt_1";
        String content = (UUID.randomUUID() + UUID.randomUUID().toString() + UUID.randomUUID()).replaceAll("-", "");
        File targetFile = new File(realPath);
        while (targetFile.length() < size) {
            content += (content + content + "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaafbasdf");
            FileUtils.writeStringToFile(new File(realPath), content, true);
        }

    }

    private static String addPrefixZero(int num, int expectWidth) {
        StringBuilder ans = new StringBuilder();
        int t = num;
        for (int i = 0; i < expectWidth; i++) {
            if (t == 0) {
                ans.append("0");
            } else {
                ans.append(t % 10);
                t /= 10;
            }
        }
        return ans.reverse().toString();
    }
}
