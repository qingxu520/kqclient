package co.goho.qingxu.kq.dao;

import co.goho.qingxu.kq.entity.MsgForum;
import co.goho.qingxu.kq.entity.MsgPrivate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MsgPrivateRepository extends JpaRepository<MsgPrivate, Long> {
}
