package app.service;

import app.annotation.ServiceMethod;
import app.annotation.ServiceType;
import app.entries.Blog;

import java.util.List;

/**
 * BlogService接口
 */
public interface BlogService extends SupportService<Blog>{
    @ServiceMethod(type= ServiceType.BUSINESS,name="首页显示的列表")
    public List<Blog> index(int page, int size);
}
