package test.mybatis.runner;

import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.type.JdbcType;
import org.junit.Test;
import test.mybatis.entity.Mobile;
import test.mybatis.factory.MyBatisObjectFactory;
import test.mybatis.factory.MyBatisObjectWrapperFactory;
import test.mybatis.junit4.MyBatis;
import test.mybatis.junit4.MyBatisJUnitTest;
import test.mybatis.mapper.MobileMapper;
import test.mybatis.plugin.MyBatisInterceptor;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @see org.apache.ibatis.builder.xml.XMLConfigBuilder#parseConfiguration(XNode)
 */
public class MyBatisConfigurationTest extends MyBatisJUnitTest {

    @Test
    @MyBatis(resource = "config/mybatis-settings.xml", openSession = false)
    public void testSettings() {
        assertFalse(getConfiguration().isCacheEnabled());
        assertTrue(getConfiguration().getLogImpl() == org.apache.ibatis.logging.log4j.Log4jImpl.class);
    }

    @Test
    @MyBatis(resource = "config/mybatis-properties.xml", openSession = false)
    public void testProperties() {
        Properties variables = getConfiguration().getVariables();
        assertEquals("root", variables.getProperty("user"));
        assertEquals("root", variables.getProperty("passwd"));
        assertEquals("127.0.0.1", variables.getProperty("ip"));
    }

    @Test
    @MyBatis(resource = "config/mybatis-typeAliases.xml", openSession = false)
    public void testTypeAliases() {
        Map<String, Class<?>> typeAliases = getConfiguration().getTypeAliasRegistry().getTypeAliases();
        assertSame(Mobile.class, typeAliases.get("mobile"));
        assertSame(Mobile.class, typeAliases.get("mobile1"));
        assertNotSame(Mobile.class, typeAliases.get("mobile2"));
    }

    @Test
    @MyBatis(resource = "config/mybatis-plugins.xml", openSession = false)
    public void testPlugins() {
        List<Interceptor> interceptors = getConfiguration().getInterceptors();
        for (Interceptor interceptor : interceptors) {
            if (interceptor instanceof MyBatisInterceptor) {
                assertTrue(true);
                return;
            }
        }
        assertTrue(false);
    }

    @Test
    @MyBatis(resource = "config/mybatis-objectFactory.xml", openSession = false)
    public void testObjectFactory() {
        ObjectFactory objectFactory = getConfiguration().getObjectFactory();
        if (!(objectFactory instanceof MyBatisObjectFactory)) {
            assertTrue(false);
        }
        MyBatisObjectFactory myBatisObjectFactory = (MyBatisObjectFactory) objectFactory;
        assertEquals("root", myBatisObjectFactory.getProperties().getProperty("user"));
    }

    @Test
    @MyBatis(resource = "config/mybatis-objectWrapperFactory.xml", openSession = false)
    public void testObjectWrapperFactory() {
        assertTrue(getConfiguration().getObjectWrapperFactory() instanceof MyBatisObjectWrapperFactory);
    }

    @Test
    @MyBatis(resource = "config/mybatis-databaseIdProvider.xml")
    public void testDatabaseIdProvider() {
        assertEquals("mysql", getConfiguration().getDatabaseId());
    }

    @Test
    @MyBatis(resource = "config/mybatis-typeHandlers.xml", openSession = false)
    public void testTypeHandlers() {
        assertTrue(getConfiguration().getTypeHandlerRegistry().hasTypeHandler(Map.class, JdbcType.VARCHAR));
    }

    @Test
    @MyBatis(resource = "config/mybatis-mappers.xml", openSession = false)
    public void testMappers() {
        assertTrue(getConfiguration().getMapperRegistry().getMappers().contains(MobileMapper.class));
    }

}
