package com.molice.springbootactiviti.config;

import org.activiti.engine.impl.persistence.deploy.Deployer;
import org.activiti.engine.impl.rules.RulesDeployer;
import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * activiti工作流配置
 *
 * @author molice
 * @date 2018-05-02
 */
@Configuration
public class ActivitiConfiguration extends AbstractProcessEngineAutoConfiguration {

    @Resource
    private DataSource druidDataSource;
    @Resource
    private PlatformTransactionManager transactionManager;

    /**
     * 注入数据源和事务管理器
     *
     * @param springAsyncExecutor
     * @return
     */
    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(
            SpringAsyncExecutor springAsyncExecutor) {
        SpringProcessEngineConfiguration processEngineConfiguration = new SpringProcessEngineConfiguration();
        processEngineConfiguration.setDataSource(druidDataSource);
        processEngineConfiguration.setDatabaseSchemaUpdate("true");
        processEngineConfiguration.setDatabaseType("mysql");

        processEngineConfiguration.setTransactionManager(transactionManager);
        processEngineConfiguration.setAsyncExecutor(springAsyncExecutor);

        // 流程图字体
        processEngineConfiguration.setActivityFontName("宋体");
        processEngineConfiguration.setAnnotationFontName("宋体");
        processEngineConfiguration.setLabelFontName("宋体");

        // 禁用身份模块功能 启用自己新建的视图身份模块
        // processEngineConfiguration.setDbIdentityUsed(false);

        // 添加规则解析器
        List<Deployer> deployers = new ArrayList<>();
        deployers.add(new RulesDeployer());
        processEngineConfiguration.setCustomPostDeployers(deployers);

        return processEngineConfiguration;
    }
}
