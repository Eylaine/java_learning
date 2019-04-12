package utils;

import com.alibaba.fastjson.JSON;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * Date: 2019-03-21
 *
 * @author: Eylaine
 */
public class TImeUtilTest {

    @Test
    public void testGetCurrentMonth() {
        System.out.println(TImeUtil.getCurrentMonth());
    }

    @Test
    public void testGetCurrentDay() {
        System.out.println(TImeUtil.getCurrentDay());
    }

    @Test
    public void testFormatTime() {
        System.out.println(TImeUtil.formatTime());
    }

    @Test
    public void test() {
        Map<String, String> temp = new HashMap<>();
        temp.put("a", "a");
        temp.put("b", "b");
        System.out.println(temp);
        System.out.println(JSON.toJSONString(temp));
    }
}