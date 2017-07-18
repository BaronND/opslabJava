package com.opslab.blog.admin;

import com.opslab.blog.util.JacksonUtil;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.Iterator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
        {"classpath:spring/applicationContext-core.xml", "classpath:spring/Junit-beans.xml"})
public class SuperServiceTest {

    public void print(Collection collection) {
        if (collection != null && collection.size() > 0) {
            System.out.println("collection:");
            Iterator iterator = collection.iterator();
            while (iterator.hasNext()) {
                String json = JacksonUtil.toJSON(iterator.next());
                System.out.println("\t" + json);
            }

        }
    }

    public void print(Object object){
        if(object == null){
            System.out.println("object is null");
        }
        System.out.println(JacksonUtil.toJSON(object));
    }
}
