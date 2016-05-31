package test.mybatis.runner;

import org.apache.ibatis.plugin.*;
import org.junit.Assert;
import org.junit.Test;
import test.mybatis.interceptor.CallableInterceptor;
import test.mybatis.interceptor.ResultCallable;

import java.util.concurrent.Callable;

public class InterceptorTest {

    @Test
    public void test() throws Exception {
        InterceptorChain chain = new InterceptorChain();
        chain.addInterceptor(new CallableInterceptor());
        Callable<String> callable = (Callable<String>) chain.pluginAll(new ResultCallable());
        String result = callable.call();
        Assert.assertEquals("callable", result);
    }

}
