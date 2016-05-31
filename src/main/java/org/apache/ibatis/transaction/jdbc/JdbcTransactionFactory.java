/**
 *    Copyright 2009-2016 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.transaction.jdbc;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.TransactionIsolationLevel;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.TransactionFactory;

/**
 * Creates {@link JdbcTransaction} instances.
 *
 * @author Clinton Begin
 *
 * @see JdbcTransaction
 */

// 源码解析: JDBC事务工厂, 依赖于Connection的commit()和rollback()机制
public class JdbcTransactionFactory implements TransactionFactory {

  @Override
  public void setProperties(Properties props) {
  }

  @Override
  public Transaction newTransaction(Connection conn) {
    // 源码解析: 返回JDBC事务
    return new JdbcTransaction(conn);
  }

  @Override
  public Transaction newTransaction(DataSource ds, TransactionIsolationLevel level, boolean autoCommit) {
    // 源码解析: 返回JDBC事务
    return new JdbcTransaction(ds, level, autoCommit);
  }
}
