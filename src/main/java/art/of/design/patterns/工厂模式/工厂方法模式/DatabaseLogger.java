package art.of.design.patterns.工厂模式.工厂方法模式;

/**
 * Created by WangSai on 2021/3/26
 */
public class DatabaseLogger implements Logger {
    public DatabaseLogger() {
        System.out.println("init DatabaseLogger success.");
    }

    @Override
    public void writeLog(String content) {
        System.out.println(content);
    }
}
