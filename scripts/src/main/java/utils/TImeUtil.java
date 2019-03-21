package utils;

import java.time.LocalDate;

/**
 * Description:
 * Date: 2019-02-21
 *
 * @author: Eylaine
 */
public class TImeUtil {

    //默认时间格式
    private static String timeFormat = "yyyy-MM-dd HH:mm:ss:SS";
    private static LocalDate localDate = LocalDate.now();

    /**
     *  获取当前月份
     * @return
     */
    public static int getCurrentMonth() {
        return localDate.getMonthValue();
    }

    /**
     * 获取当前日子
     * @return
     */
    public static int getCurrentDay() {
        return localDate.getDayOfMonth();
    }

}
