package art.of.design.patterns.factory.pattern.method;

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
