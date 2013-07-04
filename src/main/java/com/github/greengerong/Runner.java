package com.github.greengerong;

import org.aspectj.lang.reflect.MethodSignature;

public interface Runner {
    Result exec(MethodSignature signature, Object[] args);
}
