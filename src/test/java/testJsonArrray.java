import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by WangSai on 10/25/18
 */
public class testJsonArrray {

    public static void main(String[] args) {
        System.out.println("hello world");
        JSONObject stream = new JSONObject();

        try {
            stream = stream.getJSONArray("hello").getJSONObject(0);
        } catch (JSONException e) {
            System.out.println("JSONException," + e.toString());
        }
        try {
            stream.put("hello", "askdjfljasdkljf");
            stream.getJSONArray("hello").getJSONObject(0);
        } catch (JSONException e) {
            System.out.println(e.toString());
        }

        try {
            JSONArray jsonArray = new JSONArray();
            stream.put("hello", jsonArray);
            stream.getJSONArray("hello").getJSONObject(0);
        } catch (JSONException e) {
            System.out.println(e.toString());
        }

    }

}
