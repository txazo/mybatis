package test.mybatis.junit4;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;

import java.lang.reflect.Method;

public class MyBatisJUnitRunner extends BlockJUnit4ClassRunner {

    private boolean isMyBatisTest = false;
    private Method setSqlSessionMethod;

    public MyBatisJUnitRunner(Class<?> clazz) throws InitializationError {
        super(clazz);
        initRunner(clazz);
    }

    private void initRunner(Class<?> clazz) {
        isMyBatisTest = MyBatisJUnitTest.class.isAssignableFrom(clazz);
        if (isMyBatisTest) {
            try {
                setSqlSessionMethod = clazz.getMethod("setSqlSession", SqlSession.class);
            } catch (Exception e) {
                throw new MyBatisJUnitException("MyBatisJUnitRunner init failed", e);
            }
        }
    }

    @Override
    protected Statement methodInvoker(FrameworkMethod method, Object test) {
        injectSqlSession(method, test);
        return super.methodInvoker(method, test);
    }

    private void injectSqlSession(FrameworkMethod method, Object test) {
        if (isMyBatisTest) {
            MyBatis myBatisTest = method.getAnnotation(MyBatis.class);
            if (myBatisTest != null) {
                try {
                    SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(myBatisTest.resource()));
                    if (myBatisTest.openSession()) {
                        setSqlSessionMethod.invoke(test, factory.openSession());
                    }
                } catch (Exception e) {
                    throw new MyBatisJUnitException("MyBatisJUnitRunner injectSqlSession failed", e);
                }
            }
        }
    }

}
