package app.dao.impl;

import app.dao.BlogDao;
import app.entries.Blog;
import org.springframework.stereotype.Repository;

/**
 * Blog Dao实现Bean
 */
@Repository("blogDao")
public class BlogDaoImpl extends SupportDaoImpl<Blog> implements BlogDao{
}
