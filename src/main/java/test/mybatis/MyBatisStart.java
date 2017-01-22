package test.mybatis;

import org.apache.ibatis.builder.BuilderException;
import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.exceptions.ExceptionFactory;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.parsing.XNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class MyBatisStart {


    private native int readBytes(byte b[], int off, int len) throws IOException;

    private native void open(String name) throws FileNotFoundException;

    public Configuration parse() {
        if (parsed) {
            throw new BuilderException("Each XMLConfigBuilder can only be used once.");
        }
        parsed = true;
        parseConfiguration(parser.evalNode("/configuration"));
        return configuration;
    }

    private void parseConfiguration(XNode root) {
        try {
            // 解析settings配置
            Properties settings = settingsAsPropertiess(root.evalNode("settings"));

            // 解析properties配置
            propertiesElement(root.evalNode("properties"));

            // 加载自定义的文件系统
            loadCustomVfs(settings);

            // 解析类型别名配置
            typeAliasesElement(root.evalNode("typeAliases"));

            // 解析插件配置
            pluginElement(root.evalNode("plugins"));

            // 解析对象工厂
            objectFactoryElement(root.evalNode("objectFactory"));

            // 解析对象包装工厂
            objectWrapperFactoryElement(root.evalNode("objectWrapperFactory"));

            // 解析反射工厂
            reflectionFactoryElement(root.evalNode("reflectionFactory"));

            // 设置自定义的settings配置到Configuration中
            settingsElement(settings);

            // 解析数据库环境配置
            environmentsElement(root.evalNode("environments"));

            // 解析数据库ID提供者
            databaseIdProviderElement(root.evalNode("databaseIdProvider"));

            // 解析类型转换
            typeHandlerElement(root.evalNode("typeHandlers"));

            // 解析Mapper映射
            mapperElement(root.evalNode("mappers"));
        } catch (Exception e) {
            throw new BuilderException("Error parsing SQL Mapper Configuration. Cause: " + e, e);
        }
    }

}


public class TypeAliasRegistry {

    private final Map<String, Class<?>> TYPE_ALIASES = new HashMap<String, Class<?>>();

    public TypeAliasRegistry() {
        registerAlias("string", String.class);
        registerAlias("byte", Byte.class);
        registerAlias("long", Long.class);
        registerAlias("short", Short.class);
        registerAlias("int", Integer.class);
        registerAlias("integer", Integer.class);
        registerAlias("double", Double.class);
        registerAlias("float", Float.class);
        registerAlias("boolean", Boolean.class);
    }

}
