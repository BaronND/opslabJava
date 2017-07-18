package com.opslab.framework.base.action;

import com.opslab.util.JacksonUtil;
import com.opslab.util.SysUtil;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;


/**
 * 利用Junit测试SpringMVC的controller
 * 业务层方法通过集成并调用actions或url方法即可模拟测试springmvc controller
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations =
        {"classpath*:/spring/Spring-beans-for-JUnit.xml",
                "classpath*:/spring/applicationContext-mvc.xml"})
public abstract class SuperActionTest {
    // 模拟request,response
    protected MockHttpServletRequest request;
    protected MockHttpServletResponse response;

    protected String path;
    @Autowired
    protected WebApplicationContext wac;

    protected MockMvc mockMvc;


    // 执行测试方法之前初始化模拟request,response
    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        response = new MockHttpServletResponse();
        this.mockMvc = webAppContextSetup(this.wac).build();
        path = wac.getServletContext().getContextPath();
    }

    /**
     * 模拟http请求,并返回请求结果
     *
     * @param url
     * @return
     * @throws Exception
     */
    public ResultActions httpPost(String url) throws Exception {
        MockHttpServletRequestBuilder post = post(path + "/" + url);
        return mockMvc.perform(post);
    }

    /**
     * 模拟http请求,直接打印请求结果
     *
     * @param url
     * @throws Exception
     */
    public void httpPostPrint(String url) throws Exception {
        try {
            ResultActions actions = httpPost(url);
            actions.andExpect(status().isOk());
            actions.andDo(print());
        } catch (Exception e) {
            System.out.println("请求异常:" + url);
            e.printStackTrace();
        }
    }

    /**
     * 模拟http请求,并返回请求结果
     *
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public ResultActions httpPost(String url, Map<String, String> params) throws Exception {
        MockHttpServletRequestBuilder post = post(path + "/" + url);
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                post.param(entry.getKey(), entry.getValue());
            }
        }
        return mockMvc.perform(post);
    }

    /**
     * 模拟http请求可带参数,直接打印
     *
     * @param url
     * @param params
     * @throws Exception
     */
    public void httpPostPrint(String url, Map<String, String> params) throws Exception {
        try {
            ResultActions actions = httpPost(url, params);
            actions.andExpect(status().isOk());
            actions.andDo(print());
        } catch (Exception e) {
            System.out.println("请求异常:" + url);
            e.printStackTrace();
        }
    }


    /**
     * 模拟http请求,并返回请求结果
     *
     * @param url
     * @return
     * @throws Exception
     */
    public ResultActions httpGet(String url) throws Exception {
        MockHttpServletRequestBuilder get = get(url);
        return mockMvc.perform(get);
    }

    /**
     * 模拟http请求,直接打印请求结果
     *
     * @param url
     * @throws Exception
     */
    public void httpGetPrint(String url) {
        try {
            ResultActions actions = httpGet(url);
            actions.andExpect(status().isOk());
            actions.andDo(print());
        } catch (Exception e) {
            System.out.println("请求异常:" + url);
            e.printStackTrace();
        }
    }

    /**
     * 模拟http请求,并返回请求结果
     *
     * @param url
     * @param params
     * @return
     * @throws Exception
     */
    public ResultActions httpGet(String url, Map<String, String> params) throws Exception {
        MockHttpServletRequestBuilder post = get(path + "/" + url);
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                post.param(entry.getKey(), entry.getValue());
            }
        }
        return mockMvc.perform(post);
    }

    /**
     * 模拟http请求可带参数,直接打印
     *
     * @param url
     * @param params
     * @throws Exception
     */
    public void httpGetPrint(String url, Map<String, String> params) throws Exception {
        try {
            ResultActions actions = httpGet(url, params);
            actions.andExpect(status().isOk());
            actions.andDo(print());
        } catch (Exception e) {
            System.out.println("请求异常:" + url);
            e.printStackTrace();
        }
    }

    public void info(ResultActions resultActions) {
        StringBuffer sbuf = new StringBuffer();
        try {
            MvcResult mvcResult = resultActions.andReturn();
            MockHttpServletResponse response = mvcResult.getResponse();
            String contentType = response.getContentType();
            sbuf.append("contentType:" + contentType + SysUtil.LINE_SEPARATOR);
            if (contentType != null && contentType.indexOf("application/json") != -1) {
                String json = response.getContentAsString();
                sbuf.append("json:" + json + SysUtil.LINE_SEPARATOR);
            } else {
                ModelAndView modelAndView = mvcResult.getModelAndView();
                if(modelAndView != null) {
                    sbuf.append("viewName:" + modelAndView.getViewName() + SysUtil.LINE_SEPARATOR);
                    String modelMap = JacksonUtil.toJSON(modelAndView.getModelMap());
                    sbuf.append("modelMap:" + modelMap + SysUtil.LINE_SEPARATOR);
                }

            }
            System.out.println(sbuf.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void httpInfo(String url) {
        try {
            info(httpGet(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void httpInfo(String url, Map<String, String> params) {
        try {
            info(httpGet(url, params));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
