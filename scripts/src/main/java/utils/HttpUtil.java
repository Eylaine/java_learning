package utils;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * Date: 2018/11/14
 *
 * @author: Eylaine
 */
public class HttpUtil {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private CloseableHttpClient httpClient;
    private CloseableHttpResponse httpResponse;
    private String DOMAIN = PropUtil.getPropUtil().getValue("domain");

    private static volatile HttpUtil httpUtil = null;

    private HttpUtil() {
        PoolingHttpClientConnectionManager pccm = new PoolingHttpClientConnectionManager();
        pccm.setMaxTotal(100);
        httpClient = HttpClients.custom().setConnectionManager(pccm).build();
    }

    public static HttpUtil getHttpUtil() {

        if (httpUtil == null) {
            synchronized (HttpUtil.class) {
                if (httpUtil == null) {
                    httpUtil = new HttpUtil();
                }
            }
        }
        return httpUtil;
    }

    /**
     * 带header的get请求
     *
     * @param url
     * @param headers
     * @return
     */
    public ResInfo get(String url, Map<String, String> headers) {

//        HttpGet httpGet = new HttpGet(TcConf.DOMAIN + url);
        HttpGet httpGet = new HttpGet(DOMAIN + url);

        if (null != headers && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpGet.addHeader(entry.getKey(), entry.getValue());
            }
        }

        return get(httpGet);
    }

    /**
     * 不带header的get请求
     *
     * @param url
     * @return
     */
    public ResInfo get(String url) {
        return get(url, null);
    }

    /**
     * 对内get请求，真正发送请求
     *
     * @param httpGet
     * @return
     */
    private ResInfo get(HttpGet httpGet) {
        ResInfo resInfo = new ResInfo();
        try {
            LOGGER.info("开始发送get请求：" + httpGet.getURI());
            httpResponse = httpClient.execute(httpGet);
        } catch (Exception e) {
            LOGGER.error("get请求执行失败：");
            LOGGER.error(e.getMessage());
        }
        resInfo.setResCode(httpResponse.getStatusLine().getStatusCode());
        resInfo.setResBody(getBody(httpResponse));
//        resInfo.setResHeader(getHeader(httpResponse));
//        resInfo.setCookies(getCookies());
        return resInfo;
    }

    /**
     * @param url
     * @param headers
     * @param params
     * @return
     */
    public ResInfo post(String url, Map<String, String> headers, Map<String, String> params) {

//        HttpPost httpPost = new HttpPost(TcConf.DOMAIN + url);
        HttpPost httpPost = new HttpPost(DOMAIN + url);

        if (null != headers && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPost.addHeader(entry.getKey(), entry.getValue());
            }
        }

        if (null != params && params.size() > 0) {
            List<BasicNameValuePair> temp = new ArrayList<BasicNameValuePair>();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                temp.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                try {
                    httpPost.setEntity(new UrlEncodedFormEntity(temp, "utf-8"));
                } catch (UnsupportedEncodingException e) {
                    LOGGER.error("请求参数设置异常：");
                    LOGGER.error(e.getMessage());
                }
            }
        }

        return post(httpPost);
    }

    /**
     * @param url
     * @param params
     * @return
     */
    public ResInfo post(String url, Map<String, String> params) {
        return post(url, null, params);
    }

    /**
     * 对内post请求，真正发送请求
     *
     * @param httpPost
     * @return
     */
    private ResInfo post(HttpPost httpPost) {
//        CloseableHttpResponse response;
        try {
            LOGGER.info("发送Post请求：" + httpPost.getURI());
            httpResponse = httpClient.execute(httpPost);
        } catch (Exception e) {
            LOGGER.error("post请求执行异常");
            LOGGER.error(e.getMessage());
            httpResponse = null;
        }

        ResInfo resInfo = new ResInfo();
//        resInfo.setResHeader(getHeader(response));
        resInfo.setResCode(httpResponse.getStatusLine().getStatusCode());
        resInfo.setResBody(getBody(httpResponse));
//        resInfo.setCookies(getCookies());

        return resInfo;
    }

    /**
     * 从响应中获取body
     *
     * @param response
     * @return
     * @throws IOException
     */
    private String getBody(CloseableHttpResponse response) {
        String strResult = "";

        if (null == response) {
            return "";
        }

        HttpEntity httpEntity = response.getEntity();

        try {
            LOGGER.info("获取响应的Body：");
            strResult = EntityUtils.toString(httpEntity);
        } catch (IOException e) {
            LOGGER.error("获取Body信息失败");
            LOGGER.error(e.getMessage());
        }

        return strResult;
    }

    /**
     * 从响应中获取header
     *
     * @param response
     * @return
     */
    private Map<String, String> getHeader(HttpResponse response) {
        Map<String, String> resHeader = new HashMap<>(16);

        Header[] headers = response.getAllHeaders();

        for (Header header : headers) {
            resHeader.put(header.getName(), header.getValue());
        }
        return resHeader;
    }

    /**
     * 获取返回结果中的cookies信息
     * @return
     */
/*    private Map<String, String> getCookies() {
//        StringBuilder sb = new StringBuilder();
        LOGGER.info("获取响应的Cookies：");
        Map<String, String> cookieMap = new HashMap<>(16);

//        List<Cookie> cookies = (httpClient).getCookieStore().getCookies();

        for (Cookie cookie : cookies) {
//            sb.append(cookie.getName() + "=" + cookie.getValue() + ";");
            cookieMap.put(cookie.getName(), cookie.getValue());
        }

        return cookieMap;
    }*/
}
