package sample;

import com.github.greengerong.ConditionRun;

public class MockAspectedClass {

    @ConditionRun(MockRunnerWithEqualRun.class)
    @EqualCondition(value = 3, defaultValue = 1)
    public int Add1(int arg) {
        return ++arg;
    }
}
