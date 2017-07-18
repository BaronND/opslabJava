package com.opslab.imagemanager.exception;

import com.opslab.imagemanager.APPManager;
import com.opslab.imagemanager.util.DateUtil;
import com.opslab.imagemanager.util.ExceptionUtil;
import com.opslab.imagemanager.util.JacksonUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * 在spring mvc的Controller层做统一的异常处理
 */
@Component
public class GlobalExceptionHandler implements HandlerExceptionResolver {
    private Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    @Override
    @ResponseBody
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object o, Exception ex) {
        String uri = request.getRequestURI();
        String errorMsg = ex.getMessage();

        Map<String, Object> map = new HashMap<>();
        Map<String, String[]> parameterMap = request.getParameterMap();
        String startTrace = ExceptionUtil.stackTraceToString(ex, APPManager.PACKAGE_NAME);

        map.put("result", "请求异常");
        map.put("msg", errorMsg);
        map.put("data", DateUtil.currentDateTime());
        map.put("uri", uri);
        map.put("requestParameter", parameterMap);
        map.put("startTrace", startTrace);
        logger.error(ex.getMessage());

        try {
            response.setContentType("application/json;charset=UTF-8");
            map.put("msg", "请求操作异常,请稍后再试！或联系管理员！");
            PrintWriter writer = response.getWriter();
            writer.write(JacksonUtil.toJSON(map));
            writer.flush();
            writer.close();
        } catch (Exception e) {
            logger.error("Exception:", e);
        }
        return null;

    }
}
