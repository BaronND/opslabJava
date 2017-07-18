package com.opslab.imagemanager;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
        {"classpath:spring/applicationContext-core.xml","classpath:spring/applicationContext-beans.xml"})
public class SuperServiceTest {
}
