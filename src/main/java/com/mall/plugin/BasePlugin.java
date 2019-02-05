package com.mall.plugin;

import com.mall.dao.pojo.BasePojo;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.*;

import java.time.LocalDateTime;
import java.util.Properties;

/**
 * mybatis基类插件 用于修改create_time和update_time
 *
 * @author suiguozhen on 19/01/30 11:47
 */
@Intercepts({@Signature(
        type = Executor.class,
        method = "update",
        args = {MappedStatement.class, Object.class})})
public class BasePlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
        // sql执行的类型增 删 改 查
        SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
        switch (sqlCommandType) {
            case UPDATE:
                update(invocation.getArgs()[1]);
                break;
            default:
                break;
        }
        return invocation.proceed();
    }

    /**
     * 实现plugin方法时判断一下目标类型，是本插件要拦截的对象才执行Plugin.wrap方法，
     * 否者直接返回目标本省，这样可以减少目标被代理的次数
     *
     * @param target 目标
     * @return object
     */
    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {

    }

    /**
     * 修改操作 必须map中必须传递实体才可以修改时间
     *
     * @param obj 目标对象
     */
    private void update(Object obj) {
        if (obj instanceof BasePojo) {
            BasePojo entity = (BasePojo) obj;
            entity.setUpdateTime(LocalDateTime.now());
        }
    }
}
