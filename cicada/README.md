### 项目使用

- 导入项目，完善jar包

  导入cicada项目，使用maven下载完对应的jar包

- 修改配置文件db.properties 、 applicationContext.xml 和 springmvc.xml

  `db.properties`

  填上你的数据库信息

  ```properties
  // mysql 7版本驱动
  jdbc.driver=com.mysql.cj.jdbc.Driver
  
  // 本地数据库url
  jdbc.url=jdbc:mysql://localhost:3306/cicada?serverTimezone=UTC&&useUnicode=true&&characterEncoding=UTF-8
  
  // 数据库用户
  jdbc.username=root
  
  // 密码
  jdbc.password=123456
  ```

  `applicationContext.xml`

  Sprint框架使用配置,需要修改SqlSessionFactory Config 和 mapper扫描路径

  - [mapperLocations](https://mp.baomidou.com/config/#mapperLocations)  91行  Mapper 所对应的 XML 文件位置```classpath*:mapper/cicada/*.xml```
  - basePackage 109行 mapper接口的路径```[cn.shafish.cicada]xxx项目根目录.mapper```

  `springmvc.xml`

  - context:component-scan：Spring注解注入 ```[cn.shafish.cicada]xxx项目根目录.*``` ,spring可以自动去扫描base-pack下面或者子包下面的java文件，如果扫描到有@Component @Controller@Service等这些注解的类，则把这些类注册为bean

- 配置Mybatis-plus代码生成器

  /cicada/src/main/java/generator/BeanGenerator.java,看注释基本会明白，需要注意的几点:

  - 全局配置globalConfig `%s` 对应数据库表名
  - 数据库源配置填对
  - 包配置中模块名是指包名:cn.shafish下的包名
  - 最重要的tableNames，填入需要生成类代码的表名

- 项目结构

  ```
  --------src/main/java
  
  |
  
  -------------cn.shafish.cicada.controller
  
  |
  
  -------------cn.shafish.cicada.entity
  
  |
  
  -------------cn.shafish.cicada.mapper
  
  |
  
  -------------cn.shafish.cicada.service
  
  |
  
  -------------cn.shafish.cicada.service.impl
  
  
  --------src/main/resources
  |
  -------------mapper
  |
  ----------------cicada
  
  ```

  