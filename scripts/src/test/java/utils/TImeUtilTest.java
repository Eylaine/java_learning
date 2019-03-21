package utils;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

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
}