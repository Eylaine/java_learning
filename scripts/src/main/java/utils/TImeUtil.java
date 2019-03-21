package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Description:
 * Date: 2019-02-21
 * @author: Eylaine
 */
public class TImeUtil {

    //默认时间格式
    private static String pattern = "yyyy-MM-dd HH:mm:ss:SSS";
    private static LocalDateTime now = LocalDateTime.now();

    /**
     *  获取当前月份
     * @return
     */
    public static int getCurrentMonth() {
        return now.getMonthValue();
    }

    /**
     * 获取当前日子
     * @return
     */
    public static int getCurrentDay() {
        return now.getDayOfMonth();
    }

    /**
     *
     * @return
     */
    public static String formatTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern);
        return now.format(dtf);
    }

}
