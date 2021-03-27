package art.of.design.patterns.工厂模式.简单工厂模式;

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
