package com.springboot.jdbc.demo.aop.transaction;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;

/**
 * Scope("prototype")申明为多例,解决线程安全问题。
 * spring中bean的scope属性，有如下5种类型：
 *
 * singleton 表示在spring容器中的单例，通过spring容器获得该bean时总是返回唯一的实例
 * prototype表示每次获得bean都会生成一个新的对象
 * request表示在一次http请求内有效（只适用于web应用）
 * session表示在一个用户会话内有效（只适用于web应用）
 * globalSession表示在全局会话内有效（只适用于web应用）
 */
@Slf4j
@Component
@Scope("prototype")
public class TransactionUtil {
    // 全局接受事务状态
    private TransactionStatus transactionStatus;
    // 获取事务源
    @Autowired
    private DataSourceTransactionManager dataSourceTransactionManager;

    // 开启事务
    public TransactionStatus begin() {
        log.info("-------开启事务----------");
        transactionStatus = dataSourceTransactionManager.getTransaction(new DefaultTransactionAttribute());
        return transactionStatus;
    }

    // 提交事务
    public void commit(TransactionStatus transaction) {
        log.info("-------------提交事务--------------");
        if(dataSourceTransactionManager != null) dataSourceTransactionManager.commit(transaction);
    }

    // 回滚事务
    public void rollback(TransactionStatus transaction) {
        log.info("............回滚事务.............");
        if(dataSourceTransactionManager != null) dataSourceTransactionManager.rollback(transaction);
    }
}
