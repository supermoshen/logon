package cn.dhc.logon.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-09-08
 */

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {
        log.error("系统异常【全局异常】：" + e.getMessage(), e);
        return new ModelAndView(e.getMessage());
    }

}
