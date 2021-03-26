package art.of.design.patterns.factory.pattern.method;

/**
 * Created by WangSai on 2021/3/26
 */
public class DatabaseLoggerFactory implements LoggerFactory {

    @Override
    public Logger createLogger() {
        System.out.println("createLogger DatabaseLogger");
        return new DatabaseLogger();
    }
}
