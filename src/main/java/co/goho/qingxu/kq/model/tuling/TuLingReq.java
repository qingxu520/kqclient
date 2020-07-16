package co.goho.qingxu.kq.model.tuling;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class TuLingReq {

    //输入类型:0-文本(默认)、1-图片、2-音频
    private int reqType;
    //输入信息
    private PerceptionBean perception;
    //用户参数
    private UserInfoBean userInfo;

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class PerceptionBean {
        //文本信息
        private InputTextBean inputText;
        //图片信息
        private InputImageBean inputImage;
        //inputMedia
        private inputMedia inputMedia;
        //客户端属性
        private SelfInfoBean selfInfo;

        public PerceptionBean(InputTextBean inputText) {
            this.inputText = inputText;
        }

        @NoArgsConstructor
        @AllArgsConstructor
        @Data
        public static class InputTextBean {
            //1-128字符	直接输入文本
            private String text;
        }

        @NoArgsConstructor
        @AllArgsConstructor
        @Data
        public static class inputMedia {
            //音频地址
            private String url;
        }

        @NoArgsConstructor
        @AllArgsConstructor
        @Data
        public static class InputImageBean {
            //图片地址
            private String url;
        }

        @NoArgsConstructor
        @AllArgsConstructor
        @Data
        public static class SelfInfoBean {
            //地理位置信息
            private LocationBean location;

            @NoArgsConstructor
            @AllArgsConstructor
            @Data
            public static class LocationBean {
                //所在城市
                private String city;
                //省份
                private String province;
                //街道
                private String street;
            }
        }
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    public static class UserInfoBean {
        private String apiKey;
        //用户唯一标识
        private String userId;
        //群聊唯一标识
        private String groupId;
        //群内用户昵称
        private String userIdName;
    }
}
