package cn.dhc.logon.repository;

import cn.dhc.logon.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-09-02
 */
public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor<User> {
}
