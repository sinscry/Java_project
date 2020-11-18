# SpringMVC 是前后端交接框架

`说在开头这里主要是心法理论，部署教程在https://github.com/sinscry/Web/tree/main/SpringMVC`

![springMVC结构图](/photo/Spring_MVC_工作原理图.png)
			
1. DIspathcerServlet在web.xml中定义

2. HelloMVC-servlet.xml设置自动装配controller:`<context:component-scan base-package="control"/>`

3. 页面访问问题：
	* 放在webapp下的index.jsp能直接访问		
	* WEB-INF下的内容是不能通过request请求得到的，因此我们需要在HelloMVC-servlet.xml设置InternalResourceView服务器跳转访问
		```
		<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
			<!--    /WEB-INF/page/意为页面的路径，.jsp为页面格式-->
			<property name="prefix" value="/WEB-INF/page/"/>
			<!--        <property name="suffix" value=".jsp"/>-->
		</bean>
		```

4. jsp传参教程:http://c.biancheng.net/view/4397.html
			
			
			
			
			
			
			
			