package art.of.design.patterns.工厂模式.工厂方法模式;

import myUtils.XMLUtil;

/**
 * Created by WangSai on 2021/3/26
 */
public class FactoryMainTest {
    public static void main(String[] args) {
        String loggerFactory = "loggerFactory";
        LoggerFactory factory = (LoggerFactory) XMLUtil.getBean(loggerFactory);
        if (null == factory) {
            return;
        }

        Logger logger = factory.createLogger();
        logger.writeLog("it is a test");


    }
}
