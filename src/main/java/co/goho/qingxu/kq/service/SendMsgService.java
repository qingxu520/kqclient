package co.goho.qingxu.kq.service;

import co.goho.qingxu.kq.entity.SendMsg;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SendMsgService {

    List<SendMsg> findByStateAndQqAndSendDate(String state,String qq, String sendDate);
}
