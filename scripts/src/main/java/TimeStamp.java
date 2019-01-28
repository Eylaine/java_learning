import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 * Description:
 * Date: 2018/11/23
 *
 * @author: Eylaine
 */
public class TimeStamp {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        Date date = new Date();
        System.out.println(date.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        System.out.println(sdf.format(date));

        long st = 1542977180421L;
        Date dd = new Date(st);
        System.out.println(sdf.format(dd));
    }
}
