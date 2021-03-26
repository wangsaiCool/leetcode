package art.of.design.patterns.factory.pattern.simple;

/**
 * Created by WangSai on 2021/3/25
 */
public class PieChart implements Chart {

    public PieChart() {
        System.out.println("init PieChart");
    }

    @Override
    public void display() {
        System.out.println("display PieChart");
    }
}
