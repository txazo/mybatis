package test.mybatis.runner;

import org.junit.Test;
import test.mybatis.junit4.MyBatis;
import test.mybatis.junit4.MyBatisJUnitTest;

public class SqlSessionFactoryTest extends MyBatisJUnitTest {

    @Test
    @MyBatis(openSession = false)
    public void test() {
        assertNotNull(sqlSessionFactory);
        assertNotNull(sqlSessionFactory.getConfiguration());
    }

}
