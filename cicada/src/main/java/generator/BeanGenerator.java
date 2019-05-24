package generator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.FileOutConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;


public class BeanGenerator {
	/**
	 * 示例代码生成
	 */
	
	public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }
	
	 @SuppressWarnings("deprecation")
	public static void main(String[] args) {
	        // 代码生成器
	        AutoGenerator mpg = new AutoGenerator();

	        // 全局配置
	        GlobalConfig globalConfig = new GlobalConfig();
	        final String projectPath = System.getProperty("user.dir");
	        globalConfig.setOutputDir(projectPath + "/src/main/java"); //生成文件的输出目录
	        globalConfig.setAuthor("shafish"); //开发人员
	        globalConfig.setFileOverride(false); //是否覆盖已有文件
	        globalConfig.setServiceName("%sService"); //设置生成的service接口名称首字母是否为I
	        globalConfig.setEntityName("%sDao");
	        globalConfig.setMapperName("%sMapper");
	        //globalConfig.setXmlName("%sDao");
	        globalConfig.setServiceImplName("%sServiceImpl");
	        globalConfig.setControllerName("%sController");
	        globalConfig.setActiveRecord(true); //开启 ActiveRecord 模式
	        globalConfig.setIdType(IdType.ID_WORKER); //主键策略
	        //globalConfig.setIdType(IdType.ID_WORKER);/
	        globalConfig.setBaseResultMap(true); // 数据库查询结果返回基本类型
	        globalConfig.setBaseColumnList(true); //生成sql片段，方便使用
	        globalConfig.setOpen(false);//是否打开输出目录
	        mpg.setGlobalConfig(globalConfig);

//数据源配置
	        DataSourceConfig dataSourceConfig = new DataSourceConfig();
	        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/cicada?useUnicode=true&useSSL=false&serverTimezone=GMT%2B8&characterEncoding=utf8");
	        // dsc.setSchemaName("public");
	        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
	        dataSourceConfig.setUsername("root");
	        dataSourceConfig.setPassword("123456");
	        mpg.setDataSource(dataSourceConfig);

// 包配置
	        final PackageConfig pc = new PackageConfig();
	        pc.setModuleName(scanner("模块名"));
	        pc.setParent("cn.shafish");
	        mpg.setPackageInfo(pc);

// 自定义配置
	        InjectionConfig cfg = new InjectionConfig() {
	            @Override
	            public void initMap() {
	                // to do nothing
	            }
	        };

	        // 如果模板引擎是 freemarker
	        String templatePath = "/templates/mapper.xml.ftl";
	        // 如果模板引擎是 velocity
	        // String templatePath = "/templates/mapper.xml.vm";

	        // 自定义输出配置
	        List<FileOutConfig> focList = new ArrayList();
	        // 自定义配置会被优先输出
	        focList.add(new FileOutConfig(templatePath) {
	            @Override
	            public String outputFile(TableInfo tableInfo) {
	                // 自定义输出文件名
	                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
	                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
	            }
	        });

	        cfg.setFileOutConfigList(focList);
	        mpg.setCfg(cfg);

	        // 配置模板
	        TemplateConfig templateConfig = new TemplateConfig();

	        // 配置自定义输出模板
	        // templateConfig.setEntity();
	        // templateConfig.setService();
	        // templateConfig.setController();
	        
	        templateConfig.setXml(null);
	        mpg.setTemplate(templateConfig);

	        // 策略配置
	        StrategyConfig strategy = new StrategyConfig();
	        String[] tableNames = new String[]{"cicadasubcomment"}; //需要初始化生成的表"cicadaauths","cicadacontent","cicadamember",cicadauser,cicadauser
	        strategy.setCapitalMode(true);//全局大写命名
	        strategy.setSkipView(true);//跳过视图
	        strategy.setColumnNaming(NamingStrategy.underline_to_camel);//字段驼峰命名
	        strategy.setTablePrefix(pc.getModuleName() + "_"); //数据库表前缀
	        //strategy.setFieldPrefix(""); //字段前缀
	        //strategy.setSuperEntityClass("cn.shafish.mp.common.BaseEntity");//自定义继承的Entity类全称，带包名
	        //strategy.setSuperEntityColumns("");//自定义基础的Entity类，公共字段
	        //strategy.setSuperMapperClass("");//自定义继承的Mapper类全称，带包名
	        //strategy.setSuperServiceClass("");//自定义继承的Service类全称，带包名
	        //strategy.setSuperServiceImplClass("");//自定义继承的ServiceImpl类全称，带包名
	        //strategy.setSuperControllerClass("cn.shafish.mp.common.BaseController");//自定义继承的Controller类全称，带包名
	        //strategy.setExclude("");//需要排除的表名，允许正则表达式
	        strategy.setNaming(NamingStrategy.underline_to_camel); //数据库表映射到实体的命名--驼峰命名
	        strategy.setEntityLombokModel(true);//lombok模型
	        strategy.setRestControllerStyle(true);//生成 @RestController 控制器
	        strategy.setInclude(tableNames); //生成的表
	        //strategy.entityTableFieldAnnotationEnable(true);//是否生成实体时，生成字段注解
	        //strategy.setSuperEntityColumns("id"); //自定义基础的Entity类，公共字段
	        strategy.setControllerMappingHyphenStyle(true);//驼峰转连字符
	        
	        mpg.setStrategy(strategy);
	        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
	        mpg.execute();
	    }
	 
}

