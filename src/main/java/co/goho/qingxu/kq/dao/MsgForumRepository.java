package co.goho.qingxu.kq.dao;

import co.goho.qingxu.kq.entity.MsgForum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MsgForumRepository extends JpaRepository<MsgForum, Long> {
}
