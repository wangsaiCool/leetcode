package art.of.design.patterns.工厂模式.工厂方法模式;

/**
 * Created by WangSai on 2021/3/26
 */
public class FileLoggerFactory implements LoggerFactory {

    @Override
    public Logger createLogger() {
        System.out.println("create FileLogger.");
        return new FileLogger();
    }
}
