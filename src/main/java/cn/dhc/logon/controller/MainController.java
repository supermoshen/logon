package cn.dhc.logon.controller;

import cn.dhc.logon.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-09-07
 */
@RestController
@RequestMapping("/index")
public class MainController {

    @GetMapping(value = "/info")
    public ResponseEntity<?> index(){
        return ResponseEntity.ok("Hello World");
    }
}
