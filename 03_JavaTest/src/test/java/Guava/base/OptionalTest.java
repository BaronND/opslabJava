package Guava.base;

import com.google.common.base.Optional;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;


public class OptionalTest {
    @Test
    public void testOptional() {
        Optional<Integer> possible = Optional.fromNullable(6);
        assertTrue(possible.isPresent());
        assertEquals(6, possible.get().intValue());
        assertEquals(6, possible.or(1).intValue());
        assertEquals(6, possible.orNull().intValue());
        Optional<Integer> absent = Optional.fromNullable(null);
        assertFalse(absent.isPresent());
        try {
            absent.get();
            fail();
        } catch (IllegalStateException e) {
            assertTrue(true);
        }
        assertEquals(1, absent.or(1).intValue());
        assertNull(absent.orNull());
    }
}
