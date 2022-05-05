package com.jiangjian.study.java.advanced.jvm.basic.callstack;

public class LoggerImpl implements Logger{
    @Override
    public void logRecord(String message, int logRecordType) {
        logMessage(message, logRecordType, (new Throwable()).getStackTrace()[1]);
    }

    @Override
    public void logProblem(Throwable throwable) {
        logMessage(throwable.getMessage(), ERROR, (new Throwable()).getStackTrace()[1]);
    }


    public void logMessage(String message, int logRecordType, StackTraceElement ste) {
        String callerClassName = ste.getClassName();
        String callerMethodName = ste.getMethodName();
        int callerLineNum = ste.getLineNumber();
    }
}
