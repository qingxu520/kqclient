package co.goho.qingxu.kq.model.tuling;

import co.goho.qingxu.kq.httpclient.ReqHttpClient;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

public class TulingClient {

    private String name="TULING";
    private String url="http://openapi.tuling123.com/openapi/api/v2";
    private String apikey="af81359e31bb4abea0d1a5f23e815058";
    private String apisign;

    public String text(String userId,String msg){
        String result="";
        if(StringUtils.isNotBlank(msg)){
            TuLingReq.PerceptionBean perceptionBean = new TuLingReq.PerceptionBean(new TuLingReq.PerceptionBean.InputTextBean(msg));
            TuLingReq.UserInfoBean userInfoBean = new TuLingReq.UserInfoBean(apikey,userId,"","");
            TuLingReq req = new TuLingReq(0,perceptionBean,userInfoBean);
            String resSt = new ReqHttpClient().sendResquest(JSON.toJSONString(req),name,url);
            TuLingRes res = JSONObject.parseObject(resSt,TuLingRes.class);
            if(req!=null&&res.getIntent().getCode()>10000 && !res.getResults().isEmpty()){
                result = res.getResults().get(0).getValues().get("text");
            }
        }
       return result;
    }
}
