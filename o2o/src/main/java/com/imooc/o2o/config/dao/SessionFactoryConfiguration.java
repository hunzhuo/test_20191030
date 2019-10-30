package com.imooc.o2o.config.dao;

import java.io.IOException;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//@Configuration注解的意思：配置datasource写入spring的ioc容器里面
@Configuration
public class SessionFactoryConfiguration {
	//mybatis-config.xml配置文件的路径
	//private	static String mybatisConfigFile="mybatis-config.xml";
	private static String mybatisConfigFile;
	@Value("${mybatis_config_file}")
	public void setMybatisConfigFile(String mybatisConfigFile) {
		SessionFactoryConfiguration.mybatisConfigFile = mybatisConfigFile;
	}
	//mybatis mapper文件所在路径
	//private	static String mapperPath="/mapper/**.xml";
	private static String mapperPath;
	@Value("${mapper_path}")
	public void setMapperPath(String mapperPath) {
		SessionFactoryConfiguration.mapperPath = mapperPath;
	}

	//实体类所在的package
	//private String typeAliasPackage="com.imooc.entity";	
    @Value("${type_alias_package}")
	private String typeAliasPackage;
	
	//自动注入datasource
	@Autowired
	private DataSource dataSource;
	
	/*创建sqlSessionFactoryBean实例 并设置configtion 设置mapper映射路径*/
	@Bean(name="sqlSessionFactory")
		public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
			SqlSessionFactoryBean sqlSessionFactoryBean=new SqlSessionFactoryBean();
			//设置mybatis configuration扫描路径
			sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigFile));
			//添加mapper扫描路径
			PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver
			  =new PathMatchingResourcePatternResolver();
			String packageSearchPath=ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX+mapperPath;
			sqlSessionFactoryBean.setMapperLocations
			(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
			//设置dataSource
			sqlSessionFactoryBean.setDataSource(dataSource);
			//设置typeAlias包扫描路径
			sqlSessionFactoryBean.setTypeAliasesPackage(typeAliasPackage);
			return sqlSessionFactoryBean;
		}
}

