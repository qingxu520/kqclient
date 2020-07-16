package co.goho.qingxu.kq.emnu;

public enum ModelDic {
    TULING("TULING","http://openapi.tuling123.com/openapi/api/v2","af81359e31bb4abea0d1a5f23e815058",""),
    PLATFORM("1","平台提供服务","",""),
    OTHER("2","第三方提供服务","",""),
    OTHER_REGIST("3","第三方注册服务","","");
    private String name;
    private String url;
    private String apikey;
    private String apisign;

    ModelDic(String name, String url,String apikey,String apisign) {
        this.name = name;
        this.url = url;
        this.apikey=apikey;
        this.apisign=apisign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getApisign() {
        return apisign;
    }

    public void setApisign(String apisign) {
        this.apisign = apisign;
    }
}
