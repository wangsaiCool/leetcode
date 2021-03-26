package art.of.design.patterns.factory.pattern.simple;

/**
 * Created by WangSai on 2021/3/25
 */
public class LineChart implements Chart {

    public LineChart() {
        System.out.println("init LineChart.");
    }

    @Override
    public void display() {
        System.out.println("dis play LineChart");

    }
}
