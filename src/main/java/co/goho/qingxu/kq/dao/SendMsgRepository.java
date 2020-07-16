package co.goho.qingxu.kq.dao;

import co.goho.qingxu.kq.entity.SendMsg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SendMsgRepository extends JpaRepository<SendMsg, Long> {

    List<SendMsg> findByStateAndQqAndSendDate(@Param("state") String state, @Param("qq")String qq, @Param("sendDate")String sendDate);
}
