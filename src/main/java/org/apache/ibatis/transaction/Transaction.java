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
package org.apache.ibatis.transaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Wraps a database connection.
 * Handles the connection lifecycle that comprises: its creation, preparation, commit/rollback and close. 
 *
 * @author Clinton Begin
 */

// 源码解析: 事务, 包装一个数据库连接, 处理数据库连接的生命周期, 包括创建 预编译 提交 回滚 关闭
public interface Transaction {

  /**
   * Retrieve inner database connection
   * @return DataBase connection
   * @throws SQLException
   */

  // 源码解析: 获取内部的数据库连接
  Connection getConnection() throws SQLException;

  /**
   * Commit inner database connection.
   * @throws SQLException
   */

  // 源码解析: 提交事务
  void commit() throws SQLException;

  /**
   * Rollback inner database connection.
   * @throws SQLException
   */

  // 源码解析: 回滚事务
  void rollback() throws SQLException;

  /**
   * Close inner database connection.
   * @throws SQLException
   */

  // 源码解析: 关闭数据库连接
  void close() throws SQLException;

  /**
   * Get transaction timeout if set
   * @throws SQLException
   */

  // 源码解析: 获取事务超时时间
  Integer getTimeout() throws SQLException;
  
}
