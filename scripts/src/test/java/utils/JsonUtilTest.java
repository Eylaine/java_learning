package utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.testng.annotations.Test;

/**
 * Description:
 * Date: 2018-12-11
 *
 * @author: Eylaine
 */
public class JsonUtilTest {

    @Test
    public void getOne() {
        String strJson = "";
        JSONObject jsonObject = JSONObject.fromObject(strJson);
        JSONArray result = jsonObject.getJSONArray("result");

        for (int i = 0; i < result.size(); i++) {
            String restId = result.getString(i);
        }
    }

}