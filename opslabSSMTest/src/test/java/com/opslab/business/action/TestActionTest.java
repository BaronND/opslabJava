
package com.opslab.business.action;

import com.google.common.collect.ImmutableMap;
import com.opslab.SpringActionTest;
import org.junit.Test;

import java.util.Map;

public class TestActionTest extends SpringActionTest {

    @Test
    public void testURL() {
        Map<String, String> params = ImmutableMap.<String, String>builder()
                .put("type", "defaultratio")
                .build();

        httpInfo("/se/random");

    }
}
