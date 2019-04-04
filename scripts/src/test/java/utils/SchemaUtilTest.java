package utils;

import org.testng.annotations.Test;

/**
 * Description:
 * Date: 2019-04-04
 *
 * @author: Eylaine
 */
public class SchemaUtilTest {

    @Test
    public void testValidate() {

        String str = "{\"resCode\":200,\"resBody\":{\"name\":\"Error Code\",\"message\":\"Error Message\"}}";

        String schemaPath = CommonUtil.ROOTPATH + "src/main/resources/schema/test.json";

        System.out.println(SchemaUtil.validate(str, schemaPath));
    }
}