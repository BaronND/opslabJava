package app.service.impl;

import app.annotation.ServiceMethod;
import app.annotation.ServiceType;
import app.dao.BlogDao;
import app.entries.Blog;
import app.entries.EntryPage;
import app.service.BlogService;
import app.service.sql.BusinessLogSQL;
import evilp0s.ValidUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * BlogService实现Bean
 */

@Service("blogService")
public class BlogServiceImpl extends SupportServiceImpl<Blog> implements BlogService {
    @Resource(name="blogDao")
    @Getter @Setter private BlogDao dao;

    public EntryPage getPage(int page, int size){
        String hql = "from Blog a where 1=1 order by a.createTime desc";
        return dao.query(hql, page, size);
    }

    @Override
    public List<Blog> index(int page, int size) {
        List list = new ArrayList<>();
        //制作部分投影查询
        String hql ="select a.blogid,a.title,a.createTime,a.label,a.digest" +
                " from Blog a where 1=1 order by a.createTime desc";
        EntryPage entryPage = dao.query(hql, page, size);
        if(ValidUtil.isValid(entryPage)){
            list = entryPage.getList();
        }
        return list;
    }
}
