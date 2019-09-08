package cn.dhc.logon.controller;

import cn.dhc.logon.entity.User;
import cn.dhc.logon.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-09-08
 */
@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 例如：http://localhost:9090/set?key=name&value=minbo英文名
     */
    @GetMapping("/set")
    public ResponseEntity<?> setKeyAndValue(String key, String value) {
        log.debug("访问set:key={},value={}", key, value);
        RedisUtil.set(this.redisTemplate, key, value);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 例如：http://localhost:9090/get?key=name
     */
    @GetMapping("/get")
    public ResponseEntity<?> getKey(String key) {
        log.debug("访问get:key={}", key);
        String result = (String) RedisUtil.get(this.redisTemplate, key);
        log.debug("get result=" + result);
        return ResponseEntity.ok(result);
    }

    /**
     * 例如：http://localhost:9090/setObj?id=A001&name=minbo英文名&age=100
     *
     * @return
     */
    @GetMapping("/setObj")
    public ResponseEntity<?> setObj(Integer id, String name, Integer age) {
        User user = new User();
        user.setId(id);
        user.setUsername(name);
        user.setAge(age);
        log.debug("访问set：" + user.toString());
        RedisUtil.set(this.redisTemplate, "user:" + user.getId(), user);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * 例如：http://localhost:9090/getObj?id=A001
     *
     * @param id
     * @return
     */
    @GetMapping("/getObj")
    public ResponseEntity<?> getObj(String id) {
        log.debug("访问get:key id={}", id);
        Object o = RedisUtil.get(this.redisTemplate, "user:" + id);
        String result = o.toString();
        log.debug("get obj result=" + result);
        return ResponseEntity.ok(result);
    }


}
