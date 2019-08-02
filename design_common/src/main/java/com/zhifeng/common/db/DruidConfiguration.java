package com.zhifeng.common.db;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;


@Configuration
@EnableConfigurationProperties({DruidDataSourceProperties.class, DruidDataSourceProperties2.class, MybatisSourceProperties.class})
public class DruidConfiguration {

    private static final Logger log = LoggerFactory.getLogger(DruidConfiguration.class);

    @Autowired
    private DruidDataSourceProperties properties;

    @Autowired
    private DruidDataSourceProperties2 properties2;

    @Autowired
    private MybatisSourceProperties mybatisSourceProperties;

    @ConditionalOnMissingBean
    @Bean(name = "dynamicDataSource")
    public DynamicDataSource dynamicDataSource() {
        DynamicDataSource dynamicDataSource = DynamicDataSource.getInstance();
        Map<Object, Object> map = new HashMap<>();

        DruidDataSource targetDruidDataSource = null;

        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(properties.getDriverClassName());
        druidDataSource.setUrl(properties.getUrl());
        druidDataSource.setUsername(properties.getUsername());
        druidDataSource.setPassword(properties.getPassword());
        druidDataSource.setInitialSize(properties.getInitialSize());
        druidDataSource.setMinIdle(properties.getMinIdle());
        druidDataSource.setMaxActive(properties.getMaxActive());
        druidDataSource.setMaxWait(properties.getMaxWait());
        druidDataSource.setTimeBetweenEvictionRunsMillis(properties.getTimeBetweenEvictionRunsMillis());
        druidDataSource.setMinEvictableIdleTimeMillis(properties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(properties.getValidationQuery());
        druidDataSource.setTestWhileIdle(properties.isTestWhileIdle());
        druidDataSource.setTestOnBorrow(properties.isTestOnBorrow());
        druidDataSource.setTestOnReturn(properties.isTestOnReturn());
        druidDataSource.setPoolPreparedStatements(properties.isPoolPreparedStatements());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(properties.getMaxPoolPreparedStatementPerConnectionSize());
        druidDataSource.setConnectionProperties(properties.getConnectionProperties());
        List<Filter> filterList = new ArrayList<>();
        filterList.add(wallFilter());
        druidDataSource.setProxyFilters(filterList);
        try {
            druidDataSource.setFilters(properties.getFilters());
            druidDataSource.init();
        } catch (SQLException e) {
            log.error(".....初始化数据库连接池错误，" + e.getMessage(), e);
        }
        map.put(properties.getDatabaseName() == null ? "default" : properties.getDatabaseName(), druidDataSource);

        if (properties.getIsMaster() == null || properties.getIsMaster().equals("true")) {
            targetDruidDataSource = druidDataSource;
        }

        if (properties2 == null || properties2.getDriverClassName() != null) {
            //jdbc配置
            DruidDataSource rdataSource = new DruidDataSource();
            rdataSource.setDriverClassName(properties2.getDriverClassName());
            rdataSource.setUrl(properties2.getUrl());
            rdataSource.setUsername(properties2.getUsername());
            rdataSource.setPassword(properties2.getPassword());
            rdataSource.setInitialSize(properties2.getInitialSize());
            rdataSource.setMinIdle(properties2.getMinIdle());
            rdataSource.setMaxActive(properties2.getMaxActive());
            rdataSource.setMaxWait(properties2.getMaxWait());
            rdataSource.setTimeBetweenEvictionRunsMillis(properties2.getTimeBetweenEvictionRunsMillis());
            rdataSource.setMinEvictableIdleTimeMillis(properties2.getMinEvictableIdleTimeMillis());
            rdataSource.setValidationQuery(properties2.getValidationQuery());
            rdataSource.setTestWhileIdle(properties2.isTestWhileIdle());
            rdataSource.setTestOnBorrow(properties2.isTestOnBorrow());
            rdataSource.setTestOnReturn(properties2.isTestOnReturn());
            rdataSource.setPoolPreparedStatements(properties2.isPoolPreparedStatements());
            rdataSource.setMaxPoolPreparedStatementPerConnectionSize(properties2.getMaxPoolPreparedStatementPerConnectionSize());
            rdataSource.setConnectionProperties(properties2.getConnectionProperties());
            try {
                rdataSource.setFilters(properties2.getFilters());
                rdataSource.init();
            } catch (SQLException e) {
                log.error(".....初始化数据库连接池错误，" + e.getMessage(), e);
            }
            map.put(properties2.getDatabaseName(), rdataSource);
            if (properties2.getIsMaster() != null && properties2.getIsMaster().equals("true")) {
                targetDruidDataSource = rdataSource;
            }
        }

        if (targetDruidDataSource == null) {
            dynamicDataSource.setDefaultTargetDataSource(druidDataSource);
        } else {
            dynamicDataSource.setDefaultTargetDataSource(targetDruidDataSource);
        }

        dynamicDataSource.setTargetDataSources(map);
        return dynamicDataSource;
    }

//    @Bean
//    public PageHelper pageHelper() {
//        PageHelper pageHelper = new PageHelper();
//        Properties properties = new Properties();
//        properties.setProperty("offsetAsPageNum", "true");
//        properties.setProperty("rowBoundsWithCount", "true");
//        properties.setProperty("reasonable", "true");
//        properties.setProperty("dialect", "mysql");    //配置mysql数据库的方言
//        pageHelper.setProperties(properties);
//        return pageHelper;
//    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

    //    @Bean(name = "sqlSessionFactory")
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dynamicDataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dynamicDataSource);
        sessionFactory.setTypeAliasesPackage(mybatisSourceProperties.getTypeAliasesPackage());

        String sourceMapperLocations = mybatisSourceProperties.getMapperLocations();
        sourceMapperLocations = sourceMapperLocations.replaceAll(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX, "");
        String[] sourceMapperLArr = sourceMapperLocations.split(",");
        Resource[] dtRes = new Resource[20];
        List<Resource> dtResList = new ArrayList<Resource>();
        for (int i = 0; i < sourceMapperLArr.length; i++) {
            Resource[] dt = new PathMatchingResourcePatternResolver().getResources(sourceMapperLArr[i]);
            dtResList.addAll(Arrays.asList(dt));
        }
        dtRes = dtResList.toArray(dtRes);
        sessionFactory.setMapperLocations(dtRes);


        //分页插件
        Interceptor interceptor = new PageInterceptor();
        Properties properties = new Properties();
        //数据库
        properties.setProperty("helperDialect", "mysql");
        //是否将参数offset作为PageNum使用
        properties.setProperty("offsetAsPageNum", "true");
        //是否进行count查询
        properties.setProperty("rowBoundsWithCount", "true");
        //是否分页合理化
        properties.setProperty("reasonable", "false");
        properties.setProperty("autoRuntimeDialect","true");
        interceptor.setProperties(properties);
        sessionFactory.setPlugins(new Interceptor[] {interceptor});

        return sessionFactory.getObject();
    }

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<String, String>();
        initParameters.put("loginUsername", "admin");// 用户名
        initParameters.put("loginPassword", "admin");// 密码
        initParameters.put("resetEnable", "false");// 禁用HTML页面上的“Reset All”功能
        initParameters.put("allow", ""); // IP白名单 (没有配置或者为空，则允许所有访问)
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

//    @Bean
//    @ConditionalOnMissingBean
//    public ServletRegistrationBean druidServlet() {
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
//        //添加初始化参数：initParams
//        //白名单：
//        //servletRegistrationBean.addInitParameter("allow","127.0.0.1");
//        //IP黑名单 (存在共同时，deny优先于allow) : 如果满足deny的话提示:Sorry, you are not permitted to view this page.
//        //servletRegistrationBean.addInitParameter("deny","192.168.1.73");
//        //登录查看信息的账号密码.
//        servletRegistrationBean.addInitParameter("loginUsername", "admin");
//        servletRegistrationBean.addInitParameter("loginPassword", "admin");
//        //是否能够重置数据.
//        servletRegistrationBean.addInitParameter("resetEnable", "true");
//        return servletRegistrationBean;
//
//    }

    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    @Bean(name = "wallConfig")
    WallConfig wallFilterConfig() {
        WallConfig wallConfig = new WallConfig();
        wallConfig.setMultiStatementAllow(true);
        wallConfig.setNoneBaseStatementAllow(true);
        return wallConfig;
    }

    @Bean(name = "wallFilter")
    @DependsOn("wallConfig")
    WallFilter wallFilter() {
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallFilterConfig());
        return wallFilter;
    }

}