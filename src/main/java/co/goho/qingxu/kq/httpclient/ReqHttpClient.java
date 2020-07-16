package co.goho.qingxu.kq.httpclient;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

@Slf4j
public class ReqHttpClient {


    public String sendResquest(String data,String type, String url) {
        log.info("=====调用模块：" + type);
        log.info("=====请求地址：" + url);
        log.info("=====请求参数：" + data);
        String result="";
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse httpResponse = null;
            // 创建一个HttpPost请求
            HttpPost post = new HttpPost(url);
            StringEntity reqEntity = new StringEntity(data, "UTF-8");
            reqEntity.setContentEncoding("UTF-8");
            //reqEntity.setContentType("application/json");
            post.setEntity(reqEntity);
            // 执行post请求操作，并拿到结果
            httpResponse = httpClient.execute(post);
            // 获取结果实体
            HttpEntity resEntity = httpResponse.getEntity();
            if (resEntity != null) {
                // 按指定编码转换结果实体为String类型
                result = EntityUtils.toString(resEntity, "UTF-8");
            }
        } catch (Exception e) {
            log.info("=====请求异常：" + e.getMessage());
        }
        log.info("=====返回参数：" + result);
        return result;
    }


}
