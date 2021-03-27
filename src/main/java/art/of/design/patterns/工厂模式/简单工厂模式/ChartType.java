package art.of.design.patterns.工厂模式.简单工厂模式;

/**
 * Created by WangSai on 2021/3/25
 */
public enum ChartType {
    LINE_CHART(0),
    PIE_CHART(1),
    ;

    private int value;
    ChartType(int value) {
        this.value = value;
    }

    public ChartType findByValue(int value) {
        switch (value) {
            case 0:
                return LINE_CHART;
            case 1:
                return PIE_CHART;
            default:
                return null;
        }
    }
}
