package test.mybatis.junit4;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(MyBatisJUnitRunner.class)
public class MyBatisJUnitTest extends Assert {

    protected SqlSession sqlSession;
    protected SqlSessionFactory sqlSessionFactory;

    @After
    public void close() {
        if (sqlSession != null) {
            sqlSession.close();
        }
    }

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
