package filesHelper;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by WangSai on 2022/6/20
 */
public class RandomFileGenerator {
    private static final int ONE_KB = 1024;
    private static final String PATH = "/tmp/test_jpeg";
    private static final String FILE_NAME_PREFIX = "test_random_jpeg";
    private static final String FILE_NAME_SUFFIX = ".jpeg";
    private static final int EXPECT_FILE_NAME_NUM_WIDTH = 6;
    private static final int FILE_SIZE = ONE_KB * ONE_KB;

    public static void main(String[] args) throws IOException {
        int fileCnt = 200;
        int fileNumStart = 0;
        String  path1 = PATH;
        for (; fileNumStart < fileCnt; fileNumStart++) {
            if (fileNumStart % 2 == 0) {
                path1 = PATH + fileNumStart / 2;
            }
            String fileName = makeFileName(path1, FILE_NAME_PREFIX, fileNumStart, EXPECT_FILE_NAME_NUM_WIDTH, FILE_NAME_SUFFIX);
            long realSize = generateRandomFile(fileName, FILE_SIZE);
            System.out.printf("success, fileName:{%s}, size:{%s}KB\n", fileName, realSize * 1.0 / ONE_KB);
        }
    }

    private static long generateRandomFile(String path, int expectedSize) throws IOException {
        File targetFile = new File(path);
        StringBuilder appendContent = new StringBuilder(expectedSize);

        while (appendContent.length() < expectedSize) {
            String newContent = UUID.randomUUID().toString().replaceAll("-", "");
            appendContent.append(newContent);
            if (appendContent.length() < expectedSize / 2) {
                appendContent.append(appendContent);
            } else {
                appendContent.append(newContent);
            }
        }
        if (targetFile.length() < expectedSize) {
            FileUtils.writeStringToFile(targetFile, appendContent.toString(), true);
        }
        return targetFile.length();
    }

    /**
     * 拼接文件名字
     *
     * @param path 目标路径, 如"/tmp/"
     * @param fileNamePrefix 文件名前缀, "test_batch_del_"
     * @param fileNum 文件编号, 如985
     * @param expectFileNumWidth 期望携带前缀0的文件编号的位数, 如6
     * @param fileNameSuffix 文件后缀 ".txt"
     * @return 文件名, 如"/tmp/test_batch_del_000985.txt"
     */
    private static String makeFileName(String path, String fileNamePrefix, int fileNum, int expectFileNumWidth, String fileNameSuffix) {
        if (!path.endsWith("/")) {
            path += "/";
        }
        if (!fileNamePrefix.endsWith("_")) {
            fileNamePrefix += "_";
        }
        if (!fileNameSuffix.startsWith(".")) {
            fileNameSuffix = "." + fileNameSuffix;
        }
        String fileNumWithPrefixZero = addPrefixZero(fileNum, expectFileNumWidth);
        return path + fileNamePrefix + fileNumWithPrefixZero + fileNameSuffix;
    }

    /**
     * @param fileNum 文件编号
     * @param expectWidth 期望文件编号的位数
     * @return 携带前导0的文件编号
     * 如fileNum=12, expectWidth=4, 则返回0012.
     */
    private static String addPrefixZero(int fileNum, int expectWidth) {
        StringBuilder ans = new StringBuilder();
        int t = fileNum;
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
