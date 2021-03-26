package art.of.design.patterns.factory.pattern.simple;

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
