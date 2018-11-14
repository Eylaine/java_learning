import java.time.LocalDate;

/**
 * Description:
 * Date: 2018/11/14
 * @author: Eylaine
 */
public class DateTime {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        monFirst(localDate);
        System.out.println();
        sunFirst(localDate);
    }

    /**
     * 打印当月的日历（星期一为第一天）
     * @param localDate LocalDate
     */
    public static void monFirst(LocalDate localDate) {
        int month = localDate.getMonthValue();
        int today = localDate.getDayOfMonth();

        localDate = localDate.minusDays(today - 1);
        int value = localDate.getDayOfWeek().getValue();
        System.out.println("Mon Tue Wed Thu Fri Sat Sun");

        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }

        while (localDate.getMonthValue() == month) {
            System.out.printf("%3d", localDate.getDayOfMonth());
            if (localDate.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            localDate = localDate.plusDays(1);
            if (localDate.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }

        if (localDate.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
    }

    /**
     * 打印当月的日历（星期日为第一天）
     * @param localDate LocalDate
     */
    public static void sunFirst(LocalDate localDate) {
        //获取当前月份
        int month = localDate.getMonthValue();
        //获取当前日期
        int today = localDate.getDayOfMonth();

        //当月第一天
        localDate = localDate.minusDays(today - 1);
        //第一天星期几
        int value = localDate.getDayOfWeek().getValue();
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 0; i < value; i++) {
            System.out.print("    ");
        }

        while (localDate.getMonthValue() == month) {
            System.out.printf("%3d", localDate.getDayOfMonth());
            if (localDate.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            if (localDate.getDayOfWeek().getValue() == 6) {
                System.out.println();
            }
            localDate = localDate.plusDays(1);
        }
    }
}
