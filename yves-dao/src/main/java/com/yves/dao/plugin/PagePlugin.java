/*
package com.yves.dao.plugin;

import com.dongnaoedu.mybatis.utils.PageInfo;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;

import javax.xml.bind.PropertyException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Properties;

*/
/**
 * 自定义分页插件
 * 
 * @author allen
 *
 *//*

@Intercepts({
		@Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class, Integer.class }) })
public class PagePlugin implements Interceptor {

	// 数据库类型
	private static String dialect = "";
	// 分页关键字
	private static String pageSqlId = "";

	*/
/**
	 * 拦截器要执行的方法
	 *//*

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		// 从invocation中提取StatementHandler
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		// 引入Mybatis已经实现了的对象：MetaObject,把StatementHandler的实例，变为MetaObject的实例
		MetaObject metaObject = MetaObject.forObject(statementHandler,
				SystemMetaObject.DEFAULT_OBJECT_FACTORY,
				SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY,
				new DefaultReflectorFactory());
		// 获取MappedStatement
		MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");

		// mapper文件中sql语句的唯一id
		String id = mappedStatement.getId();

		// 根据自定义标识匹配需要分页方法[以ByPage字符串结尾]
		if (id.matches(pageSqlId)) {
			// 获取sql的包装类BoundSql
			BoundSql boundSql = statementHandler.getBoundSql();
			Map<String, Object> params = (Map<String, Object>) boundSql.getParameterObject();
			if (params == null) {
				throw new NullPointerException("parameterObject error");
			} else {
				// 获取自定义分页参数对象
				PageInfo pageInfo = (PageInfo) params.get("page");
				
				// 获取原始sql语句
				String sql = boundSql.getSql();
				String countSql = "select count(0) from (" + sql + ") a";
				System.out.println("总数sql 语句:" + countSql);
				
				// mybatis执行查询总数sql
				Connection connection = (Connection) invocation.getArgs()[0];
				PreparedStatement countStatement = connection.prepareStatement(countSql);
				// 获取查询条件的参数
				ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
				// 经过set方法，就可以正确的执行sql语句
				parameterHandler.setParameters(countStatement);
				ResultSet rs = countStatement.executeQuery();
				// 当结果集中有值时，表示页面数量大于等于1 
				if (rs.next()) {
					pageInfo.setTotalNumber(rs.getInt(1));
				}
				rs.close();
				countStatement.close();
				
				// 拼装分页sql
				String pageSql = generatePageSql(sql, pageInfo);
				System.out.println("分页sql 语句:" + pageSql);
				// MetaObject对象来替换原来的查询语句
				metaObject.setValue("delegate.boundSql.sql", pageSql);
			}
		}
		// 将程序的控制权交还给Mybatis
		return invocation.proceed();
	}

	*/
/**
	 * 拦截器需要拦截的对象
	 *//*

	public Object plugin(Object target) {
		// 拦截器需要拦截的对象:target, this:当前类的实例
		return Plugin.wrap(target, this);
	}

	*/
/**
	 * 设置初始化的属性值
	 *//*

	@Override
	public void setProperties(Properties properties) {
		dialect = properties.getProperty("dialect");
		if (dialect == null || dialect.equals("")) {
			try {
				throw new PropertyException("dialect property is not found!");
			} catch (PropertyException e) {
				e.printStackTrace();
			}
		}
		pageSqlId = properties.getProperty("pageSqlId");
		if (dialect == null || dialect.equals("")) {
			try {
				throw new PropertyException("pageSqlId property is not found!");
			} catch (PropertyException e) {
				e.printStackTrace();
			}
		}
	}

	*/
/**
	 * 生成分页sql
	 * 
	 * @param sql
	 * @param page
	 * @return
	 *//*

	private String generatePageSql(String sql, PageInfo page) {
		if (page != null && (dialect != null || !dialect.equals(""))) {
			StringBuffer pageSql = new StringBuffer();
			if ("mysql".equals(dialect)) {
				pageSql.append(sql);
				pageSql.append(" limit " + page.getStartIndex() + "," + page.getTotalSelect());
			}
			*/
/**
			 * 适配多种数据库 else if ("oracle".equals(dialect)) { pageSql.append("select * from
			 * (select tmp_tb.*,ROWNUM row_id from ("); pageSql.append(sql);
			 * pageSql.append(") tmp_tb where ROWNUM<=");
			 * pageSql.append(page.getCurrentResult() + page.getShowCount());
			 * pageSql.append(") where row_id>"); pageSql.append(page.getCurrentResult()); }
			 * else if ("其他db".equals(sialect)){
			 * 
			 * }
			 *//*

			return pageSql.toString();
		} else {
			return sql;
		}
	}

}
*/
