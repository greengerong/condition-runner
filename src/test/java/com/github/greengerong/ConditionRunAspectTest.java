package com.github.greengerong;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ConditionRunAspectTest {
    @Test
    public void shouldNotRunWhenNotEqual() {
        final int i = new MockAspectedClass().Add1(1);
        assertThat(i, is(1));
    }

    @Test
    public void shouldRunWhenEqual() {
        final int i = new MockAspectedClass().Add1(3);
        assertThat(i, is(4));
    }

    class MockAspectedClass {

        @ConditionRun(MockRunnerWithEqualRun.class)
        @EqualCondition(value = 3, defaultValue = 1)
        public int Add1(int arg) {
            return ++arg;
        }
    }
}
