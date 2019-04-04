package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Description: 通用工具类
 * Date: 2019-03-12
 *
 * @author: Eylaine
 */
public class CommonUtil {

    private static Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);

    public static String ROOTPATH = getRootPath();

    /**
     * 获取项目根目录，如果是在Tomcat中运行，则返回部署根目录
     * @return String rootpath
     */
    private static String getRootPath() {
        String path;
        String temp = System.getProperty("user.dir");  //获取系统路径
        temp = temp.replace("\\","/");  //中文名称中括号等符号需要转义字符，替换\\的情况
        path = temp + "/";
        return path;
    }

    /**
     * 格式化GET接口的请求参数
     * @param params
     * @return
     */
    public static String parseUrl(Map<String, String> params) {
        StringBuilder sb = new StringBuilder("?");

        if (params.size() < 1) {
            LOGGER.error("入参不正确：" + params);
        }

        for (String each: params.keySet()) {
            sb.append(each).append("=").append(params.get(each)).append("&");
        }

        //去除最后一个&
        return sb.substring(0, sb.length() - 1);
    }
}
