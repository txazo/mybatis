package test.mybatis.runner;

import org.junit.Test;
import test.mybatis.junit4.MyBatis;
import test.mybatis.junit4.MyBatisJUnitTest;

public class MyBatisConfigTest extends MyBatisJUnitTest {

    @Test
    @MyBatis(resource = "config/mybatis-settings.xml", openSession = false)
    public void testSettings() {
    }

}
