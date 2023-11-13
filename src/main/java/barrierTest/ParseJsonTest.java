package barrierTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WangSai on 2023/6/1
 */
public class ParseJsonTest {
    private static final String jsonRaw = "{\n" +
            "    \"galleryApi\":{\n" +
            "        \"barrierEnable\":true,\n" +
            "        \"_barrierRateComments\":\"barrierRate base num is 10000\",\n" +
            "        \"barrierRate\":0,\n" +
            "        \"barrierLevel\":[\n" +
            "            1,2,4\n" +
            "        ],\n" +
            "        \"testUserId\":[\n" +
            "            73959969\n" +
            "        ],\n" +
            "        \"retryAfterInSeconds\":10,\n" +
            "        \"ignoreURIs\":[\n" +
            "            \"get:/mic/gallery/v3/user/full/video/playinfo\"\n" +
            "        ]\n" +
            "    },\n" +
            "    \"appBackUpApi\":{\n" +
            "        \"barrierEnable\":true,\n" +
            "        \"barrierRate\":0,\n" +
            "        \"barrierLevel\":[\n" +
            "            1,2,4,8\n" +
            "        ],\n" +
            "        \"testUserId\":[\n" +
            "            73959969\n" +
            "        ]\n" +
            "    },\n" +
            "    \"smsApi\":{\n" +
            "        \"barrierEnable\":false,\n" +
            "        \"barrierRate\":0,\n" +
            "        \"barrierLevel\":[\n" +
            "            1,2,4\n" +
            "        ],\n" +
            "        \"testUserId\":[\n" +
            "            73959969\n" +
            "        ]\n" +
            "    },\n" +
            "    \"phoneCallApi\":{\n" +
            "        \"barrierEnable\":false,\n" +
            "        \"barrierRate\":0,\n" +
            "        \"barrierLevel\":[\n" +
            "            1,2,4\n" +
            "        ],\n" +
            "        \"testUserId\":[\n" +
            "            73959969\n" +
            "        ]\n" +
            "    },\n" +
            "    \"contactApi\":{\n" +
            "        \"barrierEnable\":false,\n" +
            "        \"barrierRate\":0,\n" +
            "        \"barrierLevel\":[\n" +
            "            1,2,4\n" +
            "        ],\n" +
            "        \"testUserId\":[\n" +
            "            73959969\n" +
            "        ]\n" +
            "    }\n" +
            "}";

    private static final ObjectMapper JSON_PRETTY_MAPPER = new ObjectMapper();
    private static final Gson JSON_PRETTY_PRINTING = new Gson().newBuilder().setPrettyPrinting().create();

    public static void main(String[] args) throws IOException {
        JSONObject jsonObject = new JSONObject(jsonRaw);

        System.out.println("\nparse1 json.");
//        Map<String, BarrierSetting> settingMap1 = parseJson1(jsonObject);
        System.out.println("\nparse2 json.");
//        Map<String, BarrierSetting> settingMap2 = parseJson2(jsonRaw);

        System.out.println("\nparse3 json.");
        Map<String, BarrierSetting> settingMap3 = parseGson3(jsonRaw);
        String json = JSON_PRETTY_PRINTING.toJson(settingMap3);
        System.out.println("tojson result:\n" + json);

//        System.out.println("\noutPrint1.");
//        outPrint(settingMap1);
//        System.out.println("\noutPrint2.");
//        outPrint(settingMap2);
        System.out.println("\noutPrint3.");
        outPrint(settingMap3);

    }

    private static void outPrint(Map<String, BarrierSetting> map) {
        map.forEach((k, v) -> System.out.println(k + ":" + v));
    }

    private static Map<String, BarrierSetting> parseGson3(String data) {
        return new Gson().fromJson(data,
                new TypeToken<Map<String, BarrierSetting>>() {
                }.getType());
    }

    // 借助ObjectMapper反序列化Barrier对象
    private static Map<String, BarrierSetting> parseJson2(String data) throws IOException {
        return JSON_PRETTY_MAPPER.readValue(data, new TypeReference<Map<String, BarrierSetting>>() {
        });
    }

    // 手动创建Barrier对象
    private static Map<String, BarrierSetting> parseJson1(JSONObject jsonObject) {
        Map<String, BarrierSetting> settingMap = new HashMap<>();
        for (String apiName : jsonObject.keySet()) {
            JSONObject content = (JSONObject) jsonObject.get(apiName);
            boolean barrierEnable = content.optBoolean("barrierEnable");
            short barrierRate = (short) content.optInt("barrierRate");
            JSONArray array = content.getJSONArray("barrierLevel");
            short[] barrierLevel = new short[array.length()];
            for (int i = 0; i < array.length(); i++) {
                barrierLevel[i] = (short) array.optInt(i);
            }
            settingMap.put(apiName, new BarrierSetting()
                    .setBarrierEnable(barrierEnable)
                    .setBarrierRate(barrierRate)
                    .setBarrierLevel(barrierLevel)
            );
        }
        return settingMap;
    }
}
