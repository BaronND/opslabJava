package com.opslab.workflow.framework.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hello")
public class HelloController {

    //ResponseBody直接将结果返回
    //通过ResponseBody直接返回json数据 可以同哟*/hello.json获取到json数据
    @ResponseBody
    //RequestMapping是将URL进行映射
    //其中value等于空表示直接响应/请求
    @RequestMapping(method = RequestMethod.GET)
    public String Welcome(ModelMap model) {
        model.addAttribute("message", "111111111");
        return "hello";
    }
    /**
     * 映射请求方式
     * 普通URL路径映射
     * @RequestMapping(value={"/test1", "/user/create"})：
     *  多个URL路径可以映射到同一个处理器的功能处理方法。
     */
    @RequestMapping(value={"/test1", "/user1"},method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "111111111");
        return "hello";
    }


    /**
     * URI 模板模式映射
     * RequestMapping(value="/users/{userId}")：{×××}占位符，
     *  请求的 URL 可以是  “/users/123456”或“/users/abcd” ，
     *  通过@PathV ariable 可以提取 URI 模板模式中的{×××}中的×××变量。
     */
    @RequestMapping(value={"/test/{userId}"},method = RequestMethod.GET)
    public String uriPatter(
            ModelMap model,
            @PathVariable("userId") String userId){

        model.addAttribute("message", userId);
        return "hello";
    }

    /**
     * 映射获取请求参数
     * /params?id=111
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "params", method = RequestMethod.GET)
    public String printparams(
            @RequestParam("id") String id,
            ModelMap model
    ) {
        model.addAttribute("message", "请求参数id:" + id);
        return "hello";
    }
}