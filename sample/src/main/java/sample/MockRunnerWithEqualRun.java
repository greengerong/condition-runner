package sample;

import com.github.greengerong.Result;
import com.github.greengerong.Runner;
import org.aspectj.lang.reflect.MethodSignature;

public class MockRunnerWithEqualRun implements Runner {

    @Override
    public Result exec(MethodSignature signature, Object[] args) {
        final EqualCondition annotation = signature.getMethod().getAnnotation(EqualCondition.class);
        return new Result(Integer.valueOf(annotation.value()).equals(args[0]), annotation.defaultValue());
    }
}
