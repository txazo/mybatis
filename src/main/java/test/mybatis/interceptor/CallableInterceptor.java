package test.mybatis.interceptor;

import org.apache.ibatis.plugin.*;

import java.util.Properties;
import java.util.concurrent.Callable;

@Intercepts(value = {
        @Signature(type = Callable.class, method = "call", args = {})})
public class CallableInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        Object target = invocation.getTarget();
        if (target instanceof Callable) {
            return "callable";
        }
        return invocation.proceed();
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
    }

}
