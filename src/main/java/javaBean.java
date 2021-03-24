import org.json.JSONObject;

/**
 * Created by WangSai on 2021/2/28
 */
public class javaBean {
    public static void main(String[] args) {
        Person old = new Person();
        old.setName("t1");

        String content = old.toString();
        Object value = JSONObject.stringToValue(content);

        Person np = (Person) value;

        System.out.println(np.toString());



    }



    static class Person{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }


}
