package com.sample.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * <p>
 * <p>
 * <p>
 * <p>
 * @author
 * @version
 * @since JDK1.8
 * @see
 *
 */
@Configuration
@MapperScan("com.sample.db.mybatis.mapper")
public class MyBatisConfiguration {

	@Resource(name="dataSource")
	private DataSource dataSource;

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource);
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		//sqlSessionFactoryBean.setTypeHandlersPackage(LocalDateTimeTypeHandler.class.getPackage().getName());
		sqlSessionFactoryBean.setDataSource(dataSource);
		sqlSessionFactoryBean.setConfigLocation((new ClassPathResource("mybatis-config.xml")));
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBean.getObject();
		sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
		sqlSessionFactory.getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
		return sqlSessionFactoryBean;
	}

}
