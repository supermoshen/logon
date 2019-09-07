package cn.dhc.logon.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : charles
 * @date : 2019-09-07
 */
@Component
@Slf4j
public class MyHttpInterceptor extends HandlerInterceptorAdapter {

    private static final String EXPECT_PATH = "/index/info";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String url = request.getRequestURL().toString();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        StringBuilder queryString = new StringBuilder();
        //remove last blank
        Map<String, String[]> params = request.getParameterMap();
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (String value : values) {
                queryString.append(key);
                queryString.append("=");
                queryString.append(value);
                queryString.append("&");
            }
        }
        String string = queryString.toString();
        string = "".equals(queryString.toString()) ? null : string.substring(0, string.length() - 1);
        log.info(String.format("请求参数, url: %s, method: %s, params: %s", url, method, string));

        if (EXPECT_PATH.equals(uri)) {
            return true;
        }

        // 其他拦截请求（请求必须都带上用户id）
        String userId = request.getParameter("userId");
        if (userId != null) {
            return true;
        } else {
            this.output(response, "{\n"
                    + "\"code\": \"4001\",\n"
                    + "\"message\": \"参数错误\"\n"
                    + "}");
            return false;
        }
    }

    /**
     * output result
     */
    private void output(HttpServletResponse response, String result) throws Exception {
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        out.println(result);
    }

}
