package test.mybatis.factory;

import org.apache.ibatis.reflection.factory.DefaultObjectFactory;

import java.util.List;
import java.util.Properties;

public class MyBatisObjectFactory extends DefaultObjectFactory {

    private static final long serialVersionUID = 8753324717264665423L;

    private Properties properties;

    @Override
    public <T> T create(Class<T> type) {
        return super.create(type);
    }

    @Override
    public <T> T create(Class<T> type, List<Class<?>> constructorArgTypes, List<Object> constructorArgs) {
        return super.create(type, constructorArgTypes, constructorArgs);
    }

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Properties getProperties() {
        return properties;
    }

}
