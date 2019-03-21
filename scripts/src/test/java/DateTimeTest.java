import org.testng.annotations.Test;

/**
 * Description:
 * Date: 2018/11/23
 *
 * @author: Eylaine
 */
public class DateTimeTest {

    @Test
    public void testStampToDate() {
        System.out.println(DateTime.stampToDate(1542977180421L));
        System.out.println(DateTime.stampToDate(1542901229000L));
    }
}