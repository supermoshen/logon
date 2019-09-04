package cn.dhc.logon.service;

import cn.dhc.logon.entity.User;
import cn.dhc.logon.repository.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-09-04
 */
@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    public Page<User> getUserList(Integer page, Integer size) {
        if (null == page) {
            page = 0;
        }
        if (StringUtils.isEmpty(size)) {
            size = 10;
        }
        PageRequest pageable = PageRequest.of(page, size, Sort.Direction.DESC, "updateTime");
        return userRepository.findAll(pageable);
    }

    public User getUserById(Long id){
        return userRepository.getOne(id);
    }
}
