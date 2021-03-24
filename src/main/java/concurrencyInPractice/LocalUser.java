package concurrencyInPractice;

/**
 * Created by WangSai on 2021/2/17
 */
public class LocalUser {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public LocalUser setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LocalUser setName(String name) {
        this.name = name;
        return this;
    }
}
