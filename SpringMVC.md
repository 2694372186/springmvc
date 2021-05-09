# SpringMVC

ssm:	mybatis + spring + springMVC 	**MVC三层架构**

*SpringMVC:	SpringMVC的执行流程！

*SpringMVC:	SSM框架整合！



父项目可能需导入的依赖：

```xml
<dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.13.2</version>
        </dependency>

        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.3.5</version>
        </dependency>

        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>4.0.1</version>
        </dependency>

        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.2</version>
        </dependency>

        <dependency>
            <groupId>javax.servlet.jsp.jstl</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
```

子项目可能需导入的依赖

```xml
<!--        导入servlet依赖-->
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>2.5</version>
        </dependency>
<!--        导入jsp依赖-->
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.2</version>
        </dependency>
```



## 1.搭建环境

1. 确定项目中有SpringMVC依赖

   ![image-20210508203510439](C:\Users\GENMINI\AppData\Roaming\Typora\typora-user-images\image-20210508203510439.png)

2. 确认项目中有lib文件

   ![image-20210508203542073](C:\Users\GENMINI\AppData\Roaming\Typora\typora-user-images\image-20210508203542073.png)

![image-20210508203601045](C:\Users\GENMINI\AppData\Roaming\Typora\typora-user-images\image-20210508203601045.png)



1. **将项目设置为web项目**

   ![image-20210508180412574](C:\Users\GENMINI\AppData\Roaming\Typora\typora-user-images\image-20210508180412574.png)

**2.注册DispatcherServlet 在 web.xml中**

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">

<!--   注册DispatcherServlet:前端控制器  请求分发器-->
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>

<!--        绑定springmvc配置文件-->
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:springmvc-servlet.xml</param-value>
        </init-param>

<!--        启动级别：-->
        <load-on-startup>1</load-on-startup>
    </servlet>
<!--
        /: 只匹配所有的请求，不匹配jsp页面
        /*: 匹配所有的请求，包括jsp页面
-->
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    
</web-app>
```

**3.springmvc-servlet 配置文件 【springmvc-servlet.xml】**  

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd">

<!--    配置处理器映射器-->
    <bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"/>

<!--    配置处理器适配器-->
    <bean class="org.springframework.web.servlet.mvc.SimpleControllerHandlerAdapter"/>

<!--    配置视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="InternalResourceViewResolver">
<!--        前缀-->
        <property name="prefix" value="/WEB-INF/jsp/"/>
<!--        后缀-->
        <property name="suffix" value=".jsp"/>
    </bean>

    <bean id="/hello" class="com.springmvc.controller.HelloController"/>

</beans>
```

**4.编写Controller类**

```java
public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();

        //视图层
        String result="Hello SpringMVC";


        //视图跳转
        mv.addObject("msg",result);
        mv.setViewName("hello");
        return mv;
    }

```

## 2.SpringMVC执行流程

![image-20210508210742058](C:\Users\GENMINI\AppData\Roaming\Typora\typora-user-images\image-20210508210742058.png)



## 3.使用注解开发

1. 新建web项目

2. 导入相关jar包

   ![image-20210508213706258](C:\Users\GENMINI\AppData\Roaming\Typora\typora-user-images\image-20210508213706258.png)

   将项目设置为web项目

   ![image-20210508213741794](C:\Users\GENMINI\AppData\Roaming\Typora\typora-user-images\image-20210508213741794.png)

3. 编写web.xml  注册DispatcherServlet

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
            xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
            xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
            version="4.0">
   
       <!--   注册DispatcherServlet:前端控制器  请求分发器-->
       <servlet>
           <servlet-name>springmvc</servlet-name>
           <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
   
           <!--        绑定springmvc配置文件-->
           <init-param>
               <param-name>contextConfigLocation</param-name>
               <param-value>classpath:springmvc-servlet.xml</param-value>
           </init-param>
   
           <!--        启动级别：-->
           <load-on-startup>1</load-on-startup>
       </servlet>
       <!--
               /: 只匹配所有的请求，不匹配jsp页面
               /*: 匹配所有的请求，包括jsp页面
       -->
       <servlet-mapping>
           <servlet-name>springmvc</servlet-name>
           <url-pattern>/</url-pattern>
       </servlet-mapping>
   </web-app>
   ```

4. 编写springmvc配置文件

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:context="http://www.springframework.org/schema/context"
          xmlns:mvc="http://www.springframework.org/schema/mvc"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd
          http://www.springframework.org/schema/context
          http://www.springframework.org/schema/context/spring-context.xsd
          http://www.springframework.org/schema/mvc
          http://www.springframework.org/schema/mvc/spring-mvc.xsd">
   
   <!--    自动扫描包，让指定包下的注解生效，由IOC容器统一管理-->
       <context:component-scan base-package="com.springmvc.controller"/>
       <mvc:default-servlet-handler/>
       <mvc:annotation-driven/>
   
   <!--    视图解析器-->
       <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="internalResourceViewResolver">
           <property name="prefix" value="/WEB-INF/jsp/"/>
           <property name="suffix" value=".jsp"/>
       </bean>
   
   
   </beans>
   ```

5. 创建控制类  controller

   ```java
   @Controller
   public class HelloController {
       @RequestMapping("/hello")
       public String hello(Model model){
           //封装数据
           model.addAttribute("msg","hello springmvc");
           return "hello";
       }
   }
   
   ```

6. 完善前端视图和controller之间的对应

7. 测试运行调试





不同的提交方式: GET POST

```java

    @GetMapping("/t1/{a}/{b}")
    public String test1(@PathVariable int a,@PathVariable int b, Model model){
        int res=a+b;
        model.addAttribute("msg","get:"+res);
        return "test";
    }

    @PostMapping("/t1/{a}/{b}")
    public String test2(@PathVariable int a,@PathVariable int b, Model model){
        int res=a+b;
        model.addAttribute("msg",res);
        return "test";
    }
```

当在url地址直接输入：/t1/1/1  则方式为 get 提交 

当表单中提交方式为

```jsp
<form action="/t1/1/1" method="post">
    <input type="submit">
</form>
```

则在点击按钮后，提交方式为POST 

两者结果都为：localhost:8080/t1/1/1  但提交方式不同  



## 4.乱码问题

在前台请求与后台交互时，可能会产生乱码

解决方式1：

- 在web.xml 文件中 配置springmvc的乱码过滤

  ```xml
  <!--    配置springmvc的乱码过滤-->
      <filter>
          <filter-name>encoding</filter-name>
          <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
          
          <init-param>
              <param-name>encoding</param-name>
              <param-value>utf-8</param-value>
          </init-param>
      </filter>
      <filter-mapping>
          <filter-name>encoding</filter-name>
          <url-pattern>/*</url-pattern>
      </filter-mapping>
  ```

解决方式2：

- 大佬设计的乱码过滤类（encodingFilter）



## 5.JSON

什么是JSON?

- JSON（JavaScript Object Notation，JS对象标记）是一种轻量级的数据交换格式，目前使用特别广泛
- 采用完全独立于编程语言的**文本格式**来存储和表示数据。
- 简洁和清晰的层次结构使得JSON成为理想的数据交换语言。
- 易于人阅读和编写，同时也易于机器解析和生成，并有效地提升网络传输效率。



要求及语法格式：

- 对象表示为键值对，数据由逗号分隔
- 花括号保存对象
- 方括号保存数组



JSON 键值对是用来保存JavaScript 对象的一种方式，和JavaScript对象的写法也大同小异，键/值对组合中的键名写在前面并用双引号””包裹，使用冒号：分隔，然后紧接着值：

```json
{"name": "张三"}
{"age": "18"}
{"sex": "男"}
```

例子:		**JSON 与 javascript 对象 的互相转化**

```javascript
        <script type="text/javascript">

            //编写一个javascript对象
            var user = {
                name:"张三",
                age:18,
                sex:"男"
            };
            //将javascript转换为json对象
              var json=  JSON.stringify(user);
              console.log(json);

              console.log("======================")

            //将json转换为javascript对象
            var obj=JSON.parse(json);
            console.log(obj);

        </script>
```

结果:

![image-20210509170307054](C:\Users\GENMINI\AppData\Roaming\Typora\typora-user-images\image-20210509170307054.png)



### Controller返回JSON数据

工具：

- Jackson应该是目前比较好的json解析工具
- 当然工具不止这一个，比如还有阿里巴巴的 fastjson等





- 我们这里使用Jackson，使用它需要导入它的jar包；

```xml
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.12.3</version>
</dependency>

```

### 编写流程

1. #### **配置web.xml文件**

2. **配置springmvc-servlet.xml文件（此处 要配置 解决json 乱码方案）**

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xmlns:context="http://www.springframework.org/schema/context"
          xmlns:mvc="http://www.springframework.org/schema/mvc"
          xsi:schemaLocation="http://www.springframework.org/schema/beans
          http://www.springframework.org/schema/beans/spring-beans.xsd
          http://www.springframework.org/schema/context
          http://www.springframework.org/schema/context/spring-context.xsd
          http://www.springframework.org/schema/mvc
          http://www.springframework.org/schema/mvc/spring-mvc.xsd">
   
       <context:component-scan base-package="com.springmvc.controller"/>
   <!--    JSON乱码问题配置-->
       <mvc:annotation-driven>
           <mvc:message-converters>
               <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                   <constructor-arg value="utf-8"/>
               </bean>
               <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
                   <property name="objectMapper">
                       <bean class="org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean">
                           <property name="failOnEmptyBeans" value="false"/>
                       </bean>
                   </property>
               </bean>
           </mvc:message-converters>
       </mvc:annotation-driven>
       <mvc:default-servlet-handler/>
   
   
   
   
       <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="internalResourceViewResolver">
           <property name="prefix" value="/WEB-INF/jsp/"/>
           <property name="suffix" value=".jsp"/>
       </bean>
   
   </beans>
   ```

3. **controller类**

   ```java
   
   @RestController  //使用RestController注解 这个类下面的方法就不会走视图解析器
   //@Controller
   public class UserController {
   
   
   //    @ResponseBody//使用ResponseBody 注解 就不会走视图解析器，会直接返回一个字符串
       @RequestMapping("/t1")
       public String json1() throws JsonProcessingException {
           //创建一个对象
           User user = new User("张三",18,"男");
           return JsonUtils.getJson(user);
       }
   
       @RequestMapping("/t2")
       public String json2() throws JsonProcessingException {
           //创建一个对象
           User users[]={
                   new User("张三", 18, "男"),
                   new User("张三", 18, "男"),
                   new User("张三", 18, "男"),
                   new User("张三", 18, "男")
           };
           return JsonUtils.getJson(users);
       }
   
       @RequestMapping("/t3")
       public String json3() throws JsonProcessingException {
           return JsonUtils.getJson(new Date(),"yyyy-MM-dd HH:mm:ss");
       }
   
   
   }
   
   ```

   - 使用**@RestController**注解 这个类下面的方法就不会走视图解析器
   - 使用**@ResponseBody** 注解 就不会走视图解析器，会直接返回一个字符串

   用法:

   		1.	@Controller(**类**)  @ResponseBody(**方法**)	@RequestMapping(**方法**)
     		2.	@RestController(**类**)        @RequestMapping(方法)  **此时方法不必再用@ResponseBody**

   

4. **JsonUtils 工具类**     **User****实体类**

   ```java
   package com.springmvc.utils;
   
   import com.fasterxml.jackson.core.JsonProcessingException;
   import com.fasterxml.jackson.databind.ObjectMapper;
   import com.fasterxml.jackson.databind.SerializationFeature;
   
   import java.text.SimpleDateFormat;
   
   public class JsonUtils {
   
       public static String getJson(Object object){
           return getJson(object,"yyyy-MM-dd HH:mm:ss");
       }
   
       public static String getJson(Object object,String dataFormat){
           ObjectMapper mapper = new ObjectMapper();
           //不使用时间戳的方式
           mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
           //自定义日期的格式
           SimpleDateFormat sdf = new SimpleDateFormat(dataFormat);
           mapper.setDateFormat(sdf);
           try {
               return mapper.writeValueAsString(object);
           } catch (JsonProcessingException e) {
               e.printStackTrace();
           }
           return null;
       }
   }
   
   ```

   此处用了一些框架源码的思想

   ```java
   package com.springmvc.pojo;
   
   import lombok.AllArgsConstructor;
   import lombok.Data;
   import lombok.NoArgsConstructor;
   
   @Data   
   @AllArgsConstructor
   @NoArgsConstructor
   public class User {
       private String name;
       private int age;
       private String sex;
   }
   
   ```

   实体类使用 @Data 时 要导入lombok 依赖:

   ```xml
   
           <dependency>
               <groupId>org.projectlombok</groupId>
               <artifactId>lombok</artifactId>
               <version>1.18.20</version>
           </dependency>
       </dependencies>
   ```

   





