package sample;

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

}
