package test.mybatis.junit4;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.runner.RunWith;

@RunWith(MyBatisJUnitRunner.class)
public class MyBatisJUnitTest extends Assert {

    protected SqlSession sqlSession;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

}
