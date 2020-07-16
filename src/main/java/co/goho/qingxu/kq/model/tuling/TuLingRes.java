package co.goho.qingxu.kq.model.tuling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TuLingRes {

    //请求意图
    private IntentBean intent;
    //输出结果集
    private List<ResultsBean> results;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class IntentBean {
        //输出功能code
        private int code;
        //意图名称
        private String intentName;
        //意图动作名称
        private String actionName;
        //功能相关参数
        private Map<String,String> parameters;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class ResultsBean {
        //‘组’编号:0为独立输出，大于0时可能包含同组相关内容 (如：音频与文本为一组时说明内容一致)
        private int groupType;
        //文本(text);连接(url);音频(voice);视频(video);图片(image);图文(news)
        private String resultType;
        //输出值
        private Map<String,String> values;
    }
}
