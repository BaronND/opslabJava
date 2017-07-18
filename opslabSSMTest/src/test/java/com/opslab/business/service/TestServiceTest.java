
package com.opslab.business.service;

import com.opslab.SpringTest;
import org.junit.Before;
import org.junit.Test;


public class TestServiceTest extends SpringTest {

    private TestService service;

    @Before
    public void before() {
        super.before();
        service = (TestService) Context.getBean("testService");
    }

    @Test
    public void test(){
    }
}
