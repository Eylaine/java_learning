package utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Description:
 * Date: 2018-12-11
 *
 * @author: Eylaine
 */
public class JsonUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    /**
     * 根据path，获取Json串中的值
     * path的格式：a.b.c, a.b[0].c, a.b[0].c[0]
     * @param strJson
     * @param path
     * @return
     */
    public static String getValue(String strJson, String path) {

        JSONObject jsonObject = JSONObject.parseObject(strJson);
        String[] temp = path.split("\\.");
        String result = "";
        int num = temp.length;

        if (1 == num) {
            result = jsonObject.getString(temp[0]);
            return result;
        }

        if (2 == num) {
            if (temp[1].endsWith("]")) {
                JSONArray jsonArray1 = jsonObject.getJSONArray(temp[0]);
                int index1 = Integer.parseInt(temp[1].substring(1, temp[1].length() - 1));
                result = jsonArray1.getString(index1);
            } else {
                result = jsonObject.getJSONObject(temp[0]).getString(temp[1]);
            }

            return result;
        }

        if (3 == num) {
            if (temp[1].endsWith("]")) {
                JSONArray jsonArray1 = jsonObject.getJSONArray(temp[0]);
                int index1 = Integer.parseInt(temp[1].substring(1, temp[1].length() - 1));
                if (temp[2].endsWith("]")) {
                    JSONArray jsonArray2 = jsonArray1.getJSONArray(index1);
                    int index2 = Integer.parseInt(temp[2].substring(1, temp[2].length() - 1));
                    return jsonArray2.getString(index2);
                } else {
                    result = jsonArray1.getJSONObject(index1).getString(temp[2]);
                }
            } else {
                JSONObject jsonObject1 = jsonObject.getJSONObject(temp[0]);
                if (temp[2].endsWith("]")) {
                    JSONArray jsonArray2 = jsonObject1.getJSONArray(temp[1]);
                    int index2 = Integer.parseInt(temp[2].substring(1, temp[2].length() - 1));
                    result = jsonArray2.getString(index2);
                } else {
                    result = jsonObject1.getJSONObject(temp[1]).getString(temp[2]);
                }
            }

            return result;
        }

        return result;

    }

    /**
     *
     * @param strJson
     * @param key
     * @return
     */
    private static String getFromJsonObject(String strJson, String key) {
        JSONObject jsonObject = JSONObject.parseObject(strJson);
        return jsonObject.getString(key);
    }

}
