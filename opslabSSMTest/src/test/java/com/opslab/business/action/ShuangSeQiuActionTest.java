package com.opslab.business.action;

import com.google.common.collect.ImmutableMap;
import com.opslab.SpringActionTest;
import org.junit.Test;

import java.util.Map;

/**
 * 双色球
 */
public class ShuangSeQiuActionTest extends SpringActionTest {

    @Test
    public void testRandom() {

        Map<String, String> params = ImmutableMap.<String, String>builder()
                .put("type", "defaultratio")
                .build();

        httpInfo("/se/random");

    }


    @Test
    public void testRandomCount() {
        Map<String, String> params = ImmutableMap.<String, String>builder()
                .put("type", "defaultratio")
                .put("time", "1000000")
                .build();
        httpInfo("/se/randomcount", params);
    }
}