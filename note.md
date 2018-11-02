[TOC]

# cloud shop 开发笔记

## 服务组成目录

### common-util  常用

### common-db 数据库常用

### common-web web常用

### server-login 登录服务

### server-main cloud主服务

### server-goods 商品服务

### server-sell 销售服务

### server-customer 顾客服务

### server-kc 库存服务

### server-tj 统计服务

### server-print 打印服务

### server-ribbon 负载服务

### pom.xml  主pom 做为所有子项目的父pom



## 学习笔记

### spring boot pom 

主pom 说明

pom 主要作用就是jar包依赖

在project节点下添加继承的父pom这样会省很多事

使用1.5.3是因为新的版本兼容性不好，测试过spring boot 2.1 与spring cloud ,总是出错，主要是学习不到位

```xml

 <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.3.RELEASE</version>
        <!--<version>2.1.0.RELEASE</version>-->
 </parent>
 
```

```xml
<!-- spring boot 构建工具 -->
<build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

```

```xml
<!--引用spring mvn库 -->
<repositories>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>
```



```xml
<!-- 项目通用jar包版本统一管理 -->
<dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Dalston.RC1</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.hibernate</groupId>
                <artifactId>hibernate-core</artifactId>
                <version>${v.hibernate}</version>
            </dependency>
            <dependency>
                <groupId>org.hibernate</groupId>
                <artifactId>hibernate-ehcache</artifactId>
                <version>${v.hibernate}</version>
            </dependency>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>5.1.38</version>
                <!--<version>8.0.11</version>-->
            </dependency>
            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger-ui</artifactId>
                <version>2.2.2</version>
            </dependency>
            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger2</artifactId>
                <version>2.2.2</version>
            </dependency>
        </dependencies>
    </dependencyManagement>
```

#### 完整主pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>club.luke.cloud.shop</groupId>
    <artifactId>shop</artifactId>
    <packaging>pom</packaging>
    <version>1.0-SNAPSHOT</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.3.RELEASE</version>
        <!--<version>2.1.0.RELEASE</version>-->
    </parent>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
        <java.version>1.8</java.version>
        <v.hibernate>5.3.5.Final</v.hibernate>
    </properties>

    <repositories>
        <repository>
            <id>spring-milestones</id>
            <name>Spring Milestones</name>
            <url>https://repo.spring.io/milestone</url>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
    </repositories>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>Dalston.RC1</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
            <dependency>
                <groupId>org.hibernate</groupId>
                <artifactId>hibernate-core</artifactId>
                <version>${v.hibernate}</version>
            </dependency>
            <dependency>
                <groupId>org.hibernate</groupId>
                <artifactId>hibernate-ehcache</artifactId>
                <version>${v.hibernate}</version>
            </dependency>
            <dependency>
                <groupId>mysql</groupId>
                <artifactId>mysql-connector-java</artifactId>
                <version>5.1.38</version>
                <!--<version>8.0.11</version>-->
            </dependency>
            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger-ui</artifactId>
                <version>2.2.2</version>
            </dependency>
            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger2</artifactId>
                <version>2.2.2</version>
            </dependency>
        </dependencies>



    </dependencyManagement>

    <dependencies>

    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>



    <modules>
        <module>server-login</module>
        <module>common-db</module>
    </modules>


</project>
```



#### server-login

##### pom.xml 主要依赖jar

```xml
<dependencies>
    <!-- jpa 使用hibernate 实现 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
    <!-- mysql 连接jar -->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
    <!-- web项目支持 spring mvc，只是后端 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    <!-- 页面api测试 访问地址  swagger-ui.html -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
        </dependency>
    <!-- jpa validator的hibernate实现 -->
    <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-validator</artifactId>
        </dependency>
</dependencies>
```

##### 完整pom.xml

``` xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>shop</artifactId>
        <groupId>club.luke.cloud.shop</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>server-login</artifactId>


    <dependencies>


        <!-- jpa 使用hibernate 实现 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!-- web项目支持，只是后端 -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <!-- 访问地址  swagger-ui.html -->
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger-ui</artifactId>
        </dependency>
        <dependency>
            <groupId>io.springfox</groupId>
            <artifactId>springfox-swagger2</artifactId>
        </dependency>

        <!--<dependency>-->
            <!--<groupId>org.springframework.boot</groupId>-->
            <!--<artifactId>spring-boot-starter-thymeleaf</artifactId>-->
        <!--</dependency>-->

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <!--<dependency>-->
            <!--<groupId>org.hibernate</groupId>-->
            <!--<artifactId>hibernate-ehcache</artifactId>-->
        <!--</dependency>-->
        <dependency>
            <groupId>org.hibernate</groupId>
            <artifactId>hibernate-validator</artifactId>
        </dependency>
    </dependencies>
</project>
```

##### 完整application.properties

意思就看名字吧

```
#debug=true
spring.application.name=server-login
server.port=20110

# 日志
# 日志级别 
logging.level:club.luke:info
#数据源属性
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/lukedb?useUnicode=true&characterEncoding=utf8&autoReconnect=true&failOverReadOnly=false&useSSL=true
#spring.datasource.url=jdbc:mysql://106.12.10.163:13366/eshop2?useSSL=false
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.dbcp2.driver=com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource
#spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.dbcp2.min-idle=5
spring.datasource.dbcp2.max-idle=60
spring.datasource.dbcp2.initial-size=10
spring.datasource.dbcp2.max-wait-millis=100

# hibernate 属性
spring.jpa.database=MYSQL
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true

spring.jpa.hibernate.ddl-auto=update
#spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57InnoDBDialect
spring.jpa.properties.hibernate.connection.autocommit=false
spring.jpa.properties.hibernate.jdbc.batch_size=50
spring.jpa.properties.hibernate.packagesToScan=club.luke.cloud.shop.app.model
spring.jpa.properties.hiernate.current_session_context_class=org.springframework.orm.hibernate5.SpringSessionContext



```



##### java code

###### 程序主入口

``` java
package club.luke.cloud.shop.app;

import org.hibernate.SessionFactory;
import org.hibernate.ejb.HibernateEntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;

/**
 * Created by luke on 2018/11/1.
 */
@SpringBootApplication   //标记为程序主入口
@EnableAutoConfiguration //标记程序可以自动配置	
@EnableJpaRepositories	//标记程序可以用jpa
public class AppLogin  {
    private static final Logger log = LoggerFactory.getLogger(AppLogin.class) ;
    public static void main(String[] args) {
        SpringApplication.run(AppLogin.class,args) ;
        log.info("====================login-server-started============================");
    }

	/*使用注入的jpa类HibernateJpaSessionFactoryBean 生成hibernate 的SessionFactory*/
    @Bean
    public SessionFactory sessionFactory(HibernateJpaSessionFactoryBean factory){
        return factory.getObject() ;
    }
	/*定义jpa生成HibernateSessionFactory*/
    @Bean
    public HibernateJpaSessionFactoryBean sessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }

}

```



 

```
注意：使用自动配置时，自己写的所有的类都要在程序主入口类所在包下
├─login
│  ├─action
│  │  └─impl
│  ├─dao
│  │  └─impl
│  ├─service
│  │  └─impl
│  └─vo
├─model
└─swagger
    └─config
AppLogin.java
```



###### 页面api (swagger2)测试 配置

``` java
package club.luke.cloud.shop.app.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Created by luke on 2018/11/1.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                // 指定构建api文档的详细信息的方法：apiInfo()
                .apiInfo(apiInfo())
                .select()
                        // 指定要生成api接口的包路径，这里把controller作为包路径，生成controller中的所有接口
                .apis(RequestHandlerSelectors.basePackage("club.luke.cloud.shop.app.login"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 构建api文档的详细信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 设置页面标题cl
                .title("cloud-shop-server-login")

                        // 设置接口描述
                .description("登录服务")
                        // 设置联系方式
                .contact("luke，" + "tel:18613806246")
                        // 设置版本
                .version("1.0")
                        // 构建
                .build();
    }
}

```

###### swagger2 使用

包括 

public interface ILoginAction

先看代码，注意这个是LoginAction Controller的接口ILoginAction

所有的io.swagger.annotations 标记都可以标在接口方法中，接口的注解也要写在接口上，这样做可以使得实现代码整洁，不那么乱，我喜欢这么做



public interface ILoginAction  //controller接口

public class LoginAction implements ILoginAction //controller实现类

VOInLogin  //页面传参封装类

VOOutUser  //请求结束返回类型



``` java
package club.luke.cloud.shop.app.login.action;

import club.luke.cloud.shop.app.login.vo.VOInLogin;
import club.luke.cloud.shop.app.login.vo.VOOutUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by luke on 2018/11/1.
 */
@Api(value = "login server api") //显示在页面这个类的功能
public interface ILoginAction {

    /**
     * 用户登录 
     * @param request
     * @param response
     * @param vo
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @ApiOperation("用户登录")//显示在测试页面的请求目地
    @ResponseBody			//返回方式
    @RequestMapping(path = "login.act",method = RequestMethod.POST)
    VOOutUser login(HttpServletRequest request ,HttpServletResponse response ,
                    @ApiParam 显示测试页面中的请求参数
                    @RequestBody //请求参数方式
                    @Valid   //jpa验证
                 VOInLogin vo,BindingResult bindingResult) throws Exception ;


}

```

public class LoginAction implements ILoginAction

```java
package club.luke.cloud.shop.app.login.action.impl;

import club.luke.cloud.shop.app.login.action.ILoginAction;
import club.luke.cloud.shop.app.login.service.ILoginService;
import club.luke.cloud.shop.app.login.vo.VOInLogin;
import club.luke.cloud.shop.app.login.vo.VOOut;
import club.luke.cloud.shop.app.login.vo.VOOutUser;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by luke on 2018/11/1.
 */
@Controller
public class LoginAction implements ILoginAction {

    private static final Logger log = LoggerFactory.getLogger(LoginAction.class) ;

    @Resource
    private ILoginService loginService ;

    @Override
    public VOOutUser login(HttpServletRequest request, HttpServletResponse response,
                            @Valid @RequestBody
                           VOInLogin vo, BindingResult bindingResult) throws Exception {
        VOOutUser voOutUser  = new VOOutUser() ;
        BeanUtils.copyProperties(vo,voOutUser);
        return voOutUser;
    }
}

```

参数 VOInLogin

``` java
package club.luke.cloud.shop.app.login.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * Created by luke on 2018/11/1.
 */
@ApiModel   //标记这是个参数类
public class VOInLogin implements VOIn {

    @ApiModelProperty(value = "id",required = true)  //参数属性意义和是否必须
    @NotNull(message = "id不能为空")
    private Long id ;

    @ApiModelProperty(value = "姓名")
    @NotEmpty(message = "姓名不能为空")
    private String name ;

    @ApiModelProperty(value = "性别")
    private String sex ;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}

```







