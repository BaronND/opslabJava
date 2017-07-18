package Guava.Collections.performance;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * <h6>Description:<h6>
 * <p></p>
 *
 * @date 2015-06-29.
 */
public class JDKMapTest {
    private static Map<String, String> map = new HashMap<String, String>();

    static {
        UUID uuid = UUID.randomUUID();
        map.put("9b5777ea-c78b-43ab-98e8-96c4bbade398", "11111111");
        for (int i = 0; i < 1000000; i++) {
            map.put(UUID.randomUUID().toString(), String.valueOf(i));
        }

    }

    @Test
    public void testJDKMap() {
        System.out.println("map的大小:" + map.size());
        System.out.println(map.get("9b5777ea-c78b-43ab-98e8-96c4bbade398"));
    }
}
