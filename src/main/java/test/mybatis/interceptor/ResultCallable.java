package test.mybatis.interceptor;

import java.util.concurrent.Callable;

public class ResultCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "call";
    }

}
