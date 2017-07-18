package com.opslab.business.service;

import com.opslab.SpringTest;
import com.opslab.business.BusinessConstant;
import com.opslab.util.JacksonUtil;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;


public class ShuangSeQiuServiceTest extends SpringTest {

    private ShuangSeQiuService service;

    @Before
    public void before() {
        super.before();
        service = (ShuangSeQiuService) Context.getBean("shuangSeQiuService");
    }

    @Test
    public void testredRandom() {

        for (int i = 0; i < 100; i++) {
            int[] reds = service.redRandom();
            String json = JacksonUtil.toJSON(reds);
            System.out.println(json);
        }
    }

    @Test
    public void testRandom() {
        for (int i = 0; i < 100; i++) {
            int[] reds = service.random();
            String json = JacksonUtil.toJSON(reds);
            System.out.println(json);
        }
    }

    @Test
    public void testRandomCount() {
        for (int i = 0; i < 2; i++) {
            Map<String, Map<Integer, Integer>> stringMapMap = service.randomCount(10000);
            String json = JacksonUtil.toJSON(stringMapMap);
            System.out.println(json);
        }
    }

    @Test
    public void testRedRandomRatio() {
        for (int i = 0; i < 100; i++) {
            int[] reds = service.redRandom(BusinessConstant.RED_RATIO);

            String json = JacksonUtil.toJSON(reds);
            System.out.println(json);
            System.out.println(service.blueRandom(BusinessConstant.BLUE_RATIO));

            int[] se = service.random(BusinessConstant.RED_RATIO, BusinessConstant.BLUE_RATIO);
            json = JacksonUtil.toJSON(se);
            System.out.println(json);
        }
    }

    @Test
    public void realCount() {
        Map<String, Map<Integer, Integer>> result = service.realCount();
        System.out.println(JacksonUtil.toJSON(result));

    }

    @Test
    public void testRandom1() {
        for (int i = 0; i < 10; i++) {
            Map<String, List<Integer>> result = service.random(8, 1);
            System.out.println(JacksonUtil.toJSON(result));
        }

    }
}