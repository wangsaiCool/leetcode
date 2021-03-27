package art.of.design.patterns.工厂模式.简单工厂模式;

/**
 * Created by WangSai on 2021/3/25
 */
public class ChartFactory {
    public static Chart getChart(ChartType chartType) {
        switch (chartType) {
            case PIE_CHART:
                return new PieChart();
            case  LINE_CHART:
                return new LineChart();
            default:
                return null;
        }
    }
}
