package co.goho.qingxu.kq.model;

import co.goho.qingxu.kq.entity.MsgGroup;
import com.mumu.listenner.KQMSGAdapter;
import com.mumu.msg.RE_MSG_Forum;
import com.mumu.msg.RE_MSG_Group;
import com.mumu.msg.RE_MSG_Private;
import lombok.extern.slf4j.Slf4j;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

@Slf4j
public class MyQQAdapter extends KQMSGAdapter {

    private RewriteKQWebClient kqWebClient;
    Pattern p = Pattern.compile("[\n`~!@#$%^&*()+=|{}':;'.<>/?~@#￥%……&*（）,，——+|{}【】‘；：”“’。 、]");
    MyQQAdapter(RewriteKQWebClient kqWebClient) {
        this.kqWebClient = kqWebClient;
    }

    /**
     * 接收私聊消息
     */
    public void Re_MSG_Private(RE_MSG_Private msg) {
        String message=msg.getMsg();
        log.info("-----私聊消息："+message);
        if(StringUtils.isNotBlank(message)){
            String pinyin=getPingYin(message);
            if(p.matcher(message).replaceAll("").trim().equals("大白")){
                return;
            }else if (message.contains("大白一刀")) {
                kqWebClient.sendPrivateMSG(msg.getFromqq(),"你好,接收到了你的消息：" + msg.getMsg());
            }else if (message.contains("笑死")) {
                kqWebClient.sendPrivateMSG(msg.getFromqq(),"你好,接收到了你的消息：" + msg.getMsg());
            }else if(message.contains("大")&&pinyin.contains("白")){
                kqWebClient.sendPrivateMSG(msg.getFromqq(),"你好,接收到了你的消息：" + msg.getMsg());
            }else if(!message.contains("大摆")&&!message.contains("大败")&&!message.contains("打败")&&pinyin.contains("da")&&pinyin.contains("bai")){
                kqWebClient.sendPrivateMSG(msg.getFromqq(),"你好,接收到了你的消息：" + msg.getMsg());
            }
        }
    }

    public void RE_MSG_FORUM(RE_MSG_Forum msg) {

    }

    /**
     * 接收群消息
     */
    public void RE_MSG_Group(RE_MSG_Group msg) {
        if(!msg.getFromGroup().equals("733233022")){
            return;
        }
        MsgGroup msgGroup = new MsgGroup(msg);
        log.info("------群消息："+msgGroup.toString());
        String message=msg.getMsg();
        if(StringUtils.isNotBlank(message)){
            if(message.contains("梅花桩")&&msg.getFromQQ().equals("3618258577")){
                kqWebClient.sendGroupMSG("2457733127", msg.getFromGroup(), "[CQ:at,qq=342643974] " + message, true);
            }
        }
//        if(StringUtils.isNotBlank(message)){
//            String pinyin=getPingYin(message);
//            if(msg.getFromQQ().equals("3618258577")){
//                return;
//            }else if(p.matcher(message).replaceAll("").trim().equals("大白")){
//                return;
//            }else if (message.contains("大白一刀")) {
//                kqWebClient.sendGroupMSG("2457733127", msg.getFromGroup(), "[CQ:at,qq=" + msg.getFromQQ() + "] " + " 一jio", true);
//            }else if (message.contains("笑死")) {
//                kqWebClient.sendGroupMSG("2457733127", msg.getFromGroup(), "[CQ:at,qq=" + msg.getFromQQ() + "] " + " 你笑个屁", true);
//            }else if(message.contains("大")&&message.contains("白")&&message.contains("胖")&&message.contains("狗")&&message.contains("猪")&&message.contains("臭")&&message.contains("憨")&&message.contains("智障")&&message.contains("傻")&&message.contains("id=46")&&message.contains("id=128055")&&message.contains("id=128054")){
//                if(!p.matcher(subStr(message)).replaceAll("[").replaceAll("]","").trim().startsWith("不")){
//                    kqWebClient.sendGroupMSG("2457733127", msg.getFromGroup(), "[CQ:at,qq=" + msg.getFromQQ() + "] " + message.replaceAll("大",(StringUtils.isNotBlank(msg.getNick())?msg.getNick():msg.getUsername())).replaceAll("白",""), true);
//                }else if(message.contains("不")||pinyin.contains("bu")){
//                    kqWebClient.sendGroupMSG("2457733127", msg.getFromGroup(), "[CQ:at,qq=" + msg.getFromQQ() + "] " + "是吗", true);
//                }
//            }else if(message.contains("大")&&message.contains("白")&&message.contains("帅")&&message.contains("欧")&&!message.contains("不")&&!pinyin.contains("不")){
//                kqWebClient.sendGroupMSG("2457733127", msg.getFromGroup(), "[CQ:at,qq=" + msg.getFromQQ() + "] " + "说的不错", true);
//            } else if(message.contains("大")&&message.contains("白")){
//                kqWebClient.sendGroupMSG("2457733127", msg.getFromGroup(), "[CQ:at,qq=" + msg.getFromQQ() + "] " + message.replaceAll("大",(StringUtils.isNotBlank(msg.getNick())?msg.getNick():msg.getUsername())).replaceAll("白",""), true);
//            }else if(!message.contains("大摆")&&!message.contains("大败")&&!message.contains("打败")&&pinyin.contains("da")&&pinyin.contains("bai")){
//                kqWebClient.sendGroupMSG("2457733127", msg.getFromGroup(), "[CQ:at,qq=" + msg.getFromQQ() + "] " + new TulingClient().text(msg.getFromGroup(),subStr(message)), true);
//            }else if(message.contains("累")){
//                kqWebClient.sendGroupMSG("2457733127", msg.getFromGroup(), "[CQ:at,qq=" + msg.getFromQQ() + "] " +"累个P累", true);
//            }else if(!message.contains("想起")&&message.contains("才")&&(message.contains("醒")||message.contains("起"))){
//                kqWebClient.sendGroupMSG("2457733127", msg.getFromGroup(), "[CQ:at,qq=" + msg.getFromQQ() + "] " +"你是猪吧", true);
//            }else if(message.contains("2457733127")){
//                kqWebClient.sendGroupMSG("2457733127", msg.getFromGroup(), "[CQ:at,qq=" + msg.getFromQQ() + "] " + new TulingClient().text(msg.getFromGroup(),subStr(message)), true);
//            }else if(message.contains("CQ:rps")){
//                kqWebClient.sendGroupMSG("2457733127", msg.getFromGroup(), "[CQ:at,qq=" + msg.getFromQQ() + "] " + "[CQ:rps,type={1}]", true);
//            }else if(message.contains("CQ:dice")){
//                kqWebClient.sendGroupMSG("2457733127", msg.getFromGroup(), "[CQ:at,qq=" + msg.getFromQQ() + "] " + "[CQ:dice,type={6}]", true);
//            }else if(!message.contains("CQ:record") && !message.contains("CQ:shake") && !message.contains("CQ:image") && !message.contains("CQ:anonymous") && !message.contains("CQ:location") && !message.contains("CQ:sign") && !message.contains("CQ:music")){
//                int i = (int)(Math.random()*20+1);
//                if(i==1){
//                    kqWebClient.sendGroupMSG("2457733127", msg.getFromGroup(), "[CQ:at,qq=" + msg.getFromQQ() + "] " + new TulingClient().text(msg.getFromGroup(),subStr(message)), true);
//                }
//            }
//        }

    }

    /**
     * 得到 全拼
     *
     * @param src
     * @return
     */
    public static String getPingYin(String src) {
        char[] t1 = null;
        t1 = src.toCharArray();
        String[] t2 = new String[t1.length];
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        int t0 = t1.length;
        try {
            for (int i = 0; i < t0; i++) {
                // 判断是否为汉字字符
                if (java.lang.Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                    t4 += t2[0];
                } else {
                    t4 += java.lang.Character.toString(t1[i]);
                }
            }
            return t4;
        } catch (BadHanyuPinyinOutputFormatCombination e1) {
            e1.printStackTrace();
        }
        return t4;
    }

    String subStr(String str) {
        if (StringUtils.isNotBlank(str)) {
            if (str.contains("[") && str.contains("]")) {
                String str1 = str.substring(0, str.indexOf("]"));
                str = str.substring(str1.length() + 1, str.length());
                subStr(str);
            }
        }
        return str;
    }

}
