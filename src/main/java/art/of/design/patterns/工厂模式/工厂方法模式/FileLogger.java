package art.of.design.patterns.工厂模式.工厂方法模式;

/**
 * Created by WangSai on 2021/3/26
 */
public class FileLogger implements Logger {

    public FileLogger() {
        System.out.println("init FileLogger success.");
    }

    @Override
    public void writeLog(String content) {
        System.out.println(content);
    }
}
