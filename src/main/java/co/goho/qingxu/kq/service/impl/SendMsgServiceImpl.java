package co.goho.qingxu.kq.service.impl;

import co.goho.qingxu.kq.dao.SendMsgRepository;
import co.goho.qingxu.kq.entity.SendMsg;
import co.goho.qingxu.kq.service.SendMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendMsgServiceImpl implements SendMsgService {

    @Autowired
    private SendMsgRepository sendMsgRepository;

    @Override
    public List<SendMsg> findByStateAndQqAndSendDate(String state, String qq, String sendDate) {
        return sendMsgRepository.findByStateAndQqAndSendDate(state,qq,sendDate);
    }
}
