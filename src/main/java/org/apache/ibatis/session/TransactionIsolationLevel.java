/**
 *    Copyright 2009-2015 the original author or authors.
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
package org.apache.ibatis.session;

import java.sql.Connection;

/**
 * @author Clinton Begin
 */

// 源码解析: 事务隔离级别
public enum TransactionIsolationLevel {

  // 源码解析: 无事务, 不支持事务
  NONE(Connection.TRANSACTION_NONE),

  // 源码解析: 读提交, 不允许脏读, 允许不可重复读、允许幻读
  READ_COMMITTED(Connection.TRANSACTION_READ_COMMITTED),

  // 源码解析: 读未提交, 允许脏读 不可重复读、允许幻读
  READ_UNCOMMITTED(Connection.TRANSACTION_READ_UNCOMMITTED),

  // 源码解析: 重复读, 不允许脏读、不可重复读, 允许幻读, MySQL的默认隔离级别
  REPEATABLE_READ(Connection.TRANSACTION_REPEATABLE_READ),

  // 源码解析: 序列化, 不允许脏读、不可重复读、幻读
  SERIALIZABLE(Connection.TRANSACTION_SERIALIZABLE);

  private final int level;

  private TransactionIsolationLevel(int level) {
    this.level = level;
  }

  public int getLevel() {
    return level;
  }
}
