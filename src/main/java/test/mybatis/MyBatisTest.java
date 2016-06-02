package test.mybatis;

import org.apache.ibatis.mapping.MappedStatement;
import org.junit.Test;
import test.mybatis.junit4.MyBatis;
import test.mybatis.junit4.MyBatisJUnitTest;

import java.sql.Statement;

public class MyBatisTest extends MyBatisJUnitTest {

    /**
     * SqlSession的增删改操作的流程
     */
    @Test
    @MyBatis
    public void testInsertDeleteUpdateProcess() {
        /**
         * SqlSession的insert()、delete()、update()都是调用DefaultSqlSession#update(String, Object)
         *
         * @see org.apache.ibatis.session.defaults.DefaultSqlSession#update(String, Object)
         */

        /**
         * DefaultSqlSession#update(String, Object)
         *
         * 1) 查询MappedStatement
         * 2) 封装参数
         * 3) 调用Executor#update(MappedStatement, Object)
         *
         * @see org.apache.ibatis.executor.Executor#update(MappedStatement, Object)
         */

        /**
         * Executor#update(MappedStatement, Object)
         *
         * Executor的直接子类有CachingExecutor和BaseExecutor
         *
         * 1) cacheEnabled=true, 调用CachingExecutor#update(MappedStatement, Object), 清除缓存
         *    cacheEnabled=false, 直接到2)
         * 2) 调用BaseExecutor#update(MappedStatement, Object), 先清除本地缓存, 然后调用BaseExecutor#doUpdate(MappedStatement, Object)
         * 3) BaseExecutor的doUpdate()是一个抽象方法, 实现doUpdate()的类有下面三个
         *
         * @see org.apache.ibatis.executor.SimpleExecutor#doUpdate(MappedStatement, Object)
         * @see org.apache.ibatis.executor.ReuseExecutor#doUpdate(MappedStatement, Object)
         * @see org.apache.ibatis.executor.BatchExecutor#doUpdate(MappedStatement, Object)
         */

        /**
         * SimpleExecutor#doUpdate(MappedStatement, Object)
         *
         * 1) 创建StatementHandler
         * 2) 创建java.sql.Statement
         * 3) 调用StatementHandler#update(Statement)
         *
         * @see org.apache.ibatis.executor.statement.StatementHandler#update(Statement)
         * @see org.apache.ibatis.executor.statement.SimpleStatementHandler#update(Statement)
         * @see org.apache.ibatis.executor.statement.PreparedStatementHandler#update(Statement)
         * @see org.apache.ibatis.executor.statement.CallableStatementHandler#update(Statement)
         */

        /**
         * SimpleStatementHandler#update(Statement)
         *
         * 1) 调用Statement的execute()执行更新操作
         * 2) 调用Statement的getUpdateCount()获取更新成功数
         *
         * @see java.sql.Statement#execute(String)
         * @see java.sql.Statement#getUpdateCount()
         */
    }

    /**
     * SqlSession的查询操作的流程
     */
    @Test
    @MyBatis
    public void testSelectProcess() {

    }

}
