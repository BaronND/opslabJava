package app.struts.action;

import app.annotation.ActionClass;
import app.annotation.ActionMethod;
import app.annotation.ActionType;
import app.entries.Blog;
import app.entries.EntryPage;
import app.service.BlogService;
import app.util.sec;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * BlogAction
 */
@Controller("blogAction")
@ActionClass("博客Action")
public class BlogAction extends SupportAction<Blog> {

    @Resource(name = "blogService")
    @Getter
    @Setter
    private BlogService service;

    @ActionMethod(type = ActionType.BUSINESS, name = "添加blog")
    public String exec_Add() {
        return "add";
    }

    @ActionMethod(type = ActionType.BUSINESS, name = "添加blog")
    public String exec_Save() {
        service.save(this.model);
        return SUCCESS;
    }

    @ActionMethod(type = ActionType.BUSINESS, name = "获取首页blog列表")
    public String exec_list(){
        printJSON(service.index(this.page,this.size));
        return null;
    }

    @ActionMethod(type = ActionType.BUSINESS, name = "查看blog")
    public String exec_page() {
        if (sec.isSec(id)) {
            this.model = service.get(id);
            return "page";
        }
        return ERROR;
    }
}
