# SpringMVC 是前后端交接框架

`说在开头这里主要是心法理论，部署教程在https://github.com/sinscry/Web/tree/main/SpringMVC`

![springMVC结构图](/photo/Spring_MVC_工作原理图.png)
			
			
课程记录:`http://c.biancheng.net/view/4399.html`			

1. DIspathcerServlet在web.xml中定义：
	* 项目流程: 
		1. web.xml指定用HelloMVC-servlet.xml配置：
			```
			<?xml version="1.0" encoding="UTF-8"?>
			<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
					 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
					 xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
					 version="4.0">
			<!-- 部署DispatcherServlet -->
			  <servlet>
				<!--        两个HelloMVC必须一样，随意自己取名-->
				<servlet-name>HelloMVC</servlet-name>
				<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
				<!-- 表示容器在启动时立即加载servlet   -->
				<load-on-startup>1</load-on-startup>
			  </servlet>

			  <servlet-mapping>
				<servlet-name>HelloMVC</servlet-name>
				<!--        <url-pattern>*.form</url-pattern>-->
				<!--  处理所有URL  -->
				<url-pattern>/</url-pattern>
			  </servlet-mapping>
			   <!--  允许访问html  -->
			  <servlet-mapping>
				<servlet-name>default</servlet-name>
				<url-pattern>*.html</url-pattern>
			  </servlet-mapping>
			</web-app>
			```
		2. HelloMVC-servlet装配控制器配置:
			1. 设置自动装配控制器:`context:component-scan base-package="control.simple_control0"/>`
			2. 设置InternalResourceView服务器跳转访问WEB-INF下内容：
				```
				<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
					<!--    /WEB-INF/page/意为页面的路径，.jsp为页面格式-->
					<!--    这样在控制器中可省略页面路径    -->
					<property name="prefix" value="/WEB-INF/page/"/>
					<!--        <property name="suffix" value=".jsp"/>-->
				</bean>
				```
			3. 开放路径访问:
				`xmlns:mvc="http://www.springframework.org/schema/mvc"`
				`http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd`
				```
				<!-- 允许images目录下的所有文件可见 -->
				<mvc:resources location="/images/" mapping="/images/**" />
				```
				
		3. Controller控制器通过域名返还页面文件(html,jsp):
			```
			package control.simple_control0;

			import org.springframework.stereotype.Controller;
			import org.springframework.ui.Model;
			import org.springframework.web.bind.annotation.RequestMapping;
			import javax.servlet.http.HttpServletRequest;
			import javax.servlet.http.HttpSession;

			@Controller
			@RequestMapping("/test")
			public class TestController {
				@RequestMapping("/login")
				public String login(HttpSession session, HttpServletRequest request) {
					session.setAttribute("skey", "session范围的值");
					session.setAttribute("rkey", "request范围的值");
					return "login.jsp";
				}
				@RequestMapping("/register")
				public String register(Model model) {
					/*在视图中可以使用EL表达式${success}取出model中的值*/
					model.addAttribute("success", "注册成功");
					return "register.jsp";
				}
			}
			```
			

2. 页面访问问题：
	* 默认路径`/`在webapp下
	* 放在webapp下的index.jsp能直接访问		
	* WEB-INF下的内容是不能通过request请求得到的，因此我们需要在HelloMVC-servlet.xml设置InternalResourceView服务器跳转访问
	* 想直接访问静态文件，需要在web.xml允许访问文件，再在HelloMVC-servlet设置路径开放:
		1. web.xml:
			```
			<!--  允许访问html  -->
			  <servlet-mapping>
				<servlet-name>default</servlet-name>
				<url-pattern>*.jpg</url-pattern>
			  </servlet-mapping>
			```
		2. HelloMVC-servlet:
			```
				<!-- 允许images目录下的所有文件可见 -->
				<mvc:resources location="/images/" mapping="/images/**" />
			```

3. jsp传参教程:http://c.biancheng.net/view/4397.html
			
			
			
			
			
			
			
			