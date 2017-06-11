package com;

import com.seeu.filesystem.service.StorageProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * Created by neo on 08/01/2017.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
//@EnableTransactionManagement
@SpringBootApplication
@MapperScan(basePackages = {
        "com.seeu.demo",
        })
@ServletComponentScan
@PropertySources(value = {@PropertySource("classpath:application.properties")})
@EnableConfigurationProperties(StorageProperties.class)
public class SEEUApplication {
    private Logger logger = Logger.getLogger(SEEUApplication.class);

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        logger.info(">> DataSource.method was used. ( SEEUApplication.class )");
        return new DataSource();
    }

    //    提供SqlSeesion
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        logger.info(">> SqlSessionFactory.method was used. ( SEEUApplication.class )");
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());

//        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

//        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/**/*.xml"));

        return sqlSessionFactoryBean.getObject();
    }

    //
    @Bean
    public PlatformTransactionManager transactionManager() {
        logger.info(">> PlatformTransactionManager.method was used. ( SEEUApplication.class )");
        return new DataSourceTransactionManager(dataSource());
    }

    public static void main(String[] args) {
        SpringApplication.run(SEEUApplication.class, args);
    }

}
