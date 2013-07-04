package com.github.greengerong;

public class Result {

    private boolean exec;
    private Object defaultValue;

    public Result(boolean exec, Object defaultValue) {
        this.exec = exec;
        this.defaultValue = defaultValue;
    }

    public boolean isExec() {
        return exec;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }
}
