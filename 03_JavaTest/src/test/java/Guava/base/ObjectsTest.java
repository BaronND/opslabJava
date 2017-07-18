package Guava.base;

import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import org.junit.Test;

import static org.junit.Assert.*;


public class ObjectsTest {
    @Test
    public void testObjects() {
        assertTrue(Objects.equal("a", "a"));
        assertFalse(Objects.equal("a", null));
        assertFalse(Objects.equal(null, "a"));
        assertTrue(Objects.equal(null, null));
        assertNotSame(Objects.hashCode("a", "b", "c"), Objects.hashCode("c", "b", "a"));
        assertNotSame(Objects.hashCode("a", "b", "c"), Objects.hashCode("c", "b", "a"));
        assertEquals(1, ComparisonChain.start().compare(1, 1).compare("aString", "aString").compare(true, false).result());
    }
}
