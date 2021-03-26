package art.of.design.patterns.factory.pattern.simple;

/**
 * Created by WangSai on 2021/3/25
 */
public class FactoryMainTest {

    public static void main(String[] args) {
        Chart chart = ChartFactory.getChart(ChartType.LINE_CHART);
        chart.display();

        chart = ChartFactory.getChart(ChartType.PIE_CHART);
        chart.display();
    }
}
