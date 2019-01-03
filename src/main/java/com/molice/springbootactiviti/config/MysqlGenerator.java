package com.molice.springbootactiviti.config;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 ┏┓　　　┏┓
 ┏┛┻━━━┛┻┓
 ┃　　　　　　　┃
 ┃　　　━　　　┃
 ┃　┳┛　┗┳　┃
 ┃　　　　　　　┃
 ┃　　　┻　　　┃
 ┃　　　　　　　┃
 ┗━┓　　　┏━┛
 　　┃　　　┃神兽保佑
 　　┃　　　┃代码无BUG！
 　　┃　　　┗━━━┓
 　　┃　　　　　　　┣┓
 　　┃　　　　　　　┏┛
 　　┗┓┓┏━┳┓┏┛
 　　　┃┫┫　┃┫┫
 　　　┗┻┛　┗┻┛
 *
 * @ClassName: MysqlGenerator
 * @Description: TODO
 * @author: SYF
 * @date: 2018年9月14日 上午10:04:34
 */
public class MysqlGenerator {

    private static String driverName = "com.mysql.jdbc.Driver";
    private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&charaterEncoding=utf8&useSSL=false";
    private static String userName = "root";
    private static String password = "root";
    private static String[] tableName = {"test"};

    public static void main(String[] args) {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //gc.setOutputDir("H://");
        gc.setOutputDir("F://project_code//springboot-activiti//src//main//java");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("mlc");
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("%sService");
        gc.setServiceImplName("%sServiceImpl");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(driverName);
        dsc.setUrl(dbUrl);
        dsc.setUsername(userName);
        dsc.setPassword(password);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略，选择下划线转驼峰命名
        strategy.setInclude(tableName); // 需要生成的表
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.molice.springbootactiviti");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        mpg.setPackageInfo(pc);

        // 关闭默认 xml 生成，调整生成 至 根目录
//        TemplateConfig tc = new TemplateConfig();
//        tc.setXml(null);
//        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
    }
}
