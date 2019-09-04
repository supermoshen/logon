package cn.dhc.logon.controller;

import cn.dhc.logon.entity.User;
import cn.dhc.logon.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-09-04
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/list")
    public ResponseEntity<?> getUserList(Integer pageOffset, Integer pageSize){
        Page<User> userList = userService.getUserList(pageOffset, pageSize);
        return ResponseEntity.ok(userList);
    }

    @GetMapping(value = "/info/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }


}
