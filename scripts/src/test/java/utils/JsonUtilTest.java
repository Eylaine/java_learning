package utils;

import org.testng.annotations.Test;

/**
 * Description:
 * Date: 2018-12-11
 *
 * @author: Eylaine
 */
public class JsonUtilTest {

    @Test
    public void testGetValue() {
        String strJson = "{\"a\":2,\"b\":[\"b\"],\"c\":[[\"a\",\"b\"]],\"d\":{\"a\":1},\"e\":{\"a\":{\"b\":1}},\"f\":[{\"f\":2},{\"e\":3}]}";
//        System.out.println(JsonUtil.getValue(strJson, "a"));
//        System.out.println(JsonUtil.getValue(strJson, "b.[0]"));
        System.out.println(JsonUtil.getValue(strJson, "f.[1].e"));
//        System.out.println(JsonUtil.getValue(strJson, "d.a"));
        System.out.println(JsonUtil.getValue(strJson, "e.a.b"));
    }
}