package test.mybatis.junit4;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(MyBatisJUnitRunner.class)
public class MyBatisJUnitTest extends Assert {

    protected SqlSession sqlSession;
    protected SqlSessionFactory sqlSessionFactory;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public Configuration getConfiguration() {
        return sqlSessionFactory.getConfiguration();
    }

}
