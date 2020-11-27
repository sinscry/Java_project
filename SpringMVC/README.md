# SpringMVC 是前后端交接框架

`说在开头这里主要是心法理论，部署教程在https://github.com/sinscry/Web/tree/main/SpringMVC`

![springMVC结构图](/photo/Spring_MVC_工作原理图.png)
			
			
课程记录:`http://c.biancheng.net/view/4420.html`			

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
			1. 设置自动装配控制器:`context:component-scan base-package="a_Hello_World.simple_control0"/>`
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
			package a_Hello_World.simple_control0;

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
	1. pojo类(UserForm)设置setter和get函数:
	```
	package control.control1.pojo;

	public class UserForm {
		private String uname;
		private String upass;
		private String reupass;

		public String getUname(){
			return this.uname;
		}
		public String getUpass(){
			return this.upass;
		}
		public String getReupass(){
			return this.reupass;
		}
		public void setUname(String uname){
			this.uname=uname;
		}
		public void setUpass(String upass){
			this.upass=upass;
		}
		public void setReupass(String reupass){
			this.reupass=reupass;
		}
	}
	```
	2. controller设置适用的pojo类:
	```
	@RequestMapping("/login")
    public String login(UserForm user, HttpSession session, Model model){
        if("zhangsan".equals(user.getUname())
                && "123456".equals(user.getUpass())){
            session.setAttribute("u", user);
            logger.info("成功");
            return "control1/main.jsp"; //跳转成功页面
        }else{
            logger.info("失败");
            model.addAttribute("messageError","用户名或密码错误");
            return "control1/login.jsp";
        }
    }
	```
	3. html中的name对应pojo:
	```
		<form action="${pageContext.request.contextPath }/user/login" method="post">
    <table>
        <tr>
            <td colspan="2">
            </td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td>
                <input type="text" name="uname" class="textSize">
            </td>
        </tr>
        <tr>
            <td>密码：</td>
            <td>
                <input type="password" name="upass" class="textsize">
            </td>
        </tr>
        <tr>
            <td colspan="2">
			<input type="submit" value="提交">
            </td>
        </tr>
    </table>
    ${messageError}
	</form>
	```
4. 转发和重定向
	1. 转发：
		* 服务器行为，用户端感知不到
		* `return "register.jsp";`
	2. 重定向: 
		* Web服务器发送302给客户端，客户端再根据提示地址发送新的请求
		* `return "redirect:/register`;

5. 绑定请求参数
	* @ModelAttribute（"user"）UserForm user功能:
		1. 将请求参数的输入封装到 user 对象中。
		2. 创建 UserForm 实例。
	* 和`model.addAttribute（"user"，user）`一样
	* `@ModelAttribute UserForm user = model.addAtttribute（"userForm", user）`

6. 自动类型转换器:
	1. html:
	```
	<form action="./converter" method= "post">
		请输入商品信息（格式为apple, 10.58,200）:
		<input type="text" name="goods" /><br>
		<input type="submit" value="提交" />
	</form>	
	```
	2. controller:
	```
	@RequestMapping("/converter")
	public String myConverter(@RequestParam("goods") GoodsModel gm, Model model){
		model.addAttribute("goods",gm);
		return "c_type_conversion/showGoods.jsp";
	}
	```
		* 解释: 从表单获取的goods为string类型，要自动转成GoodsModel类型
	3. 此时触发自动类型转化器
		1. 设置自动类型转换器:
		```
		package c_type_conversion.converter;
		import c_type_conversion.pojo.GoodsModel;
		import org.springframework.core.convert.converter.Converter;
		import org.springframework.stereotype.Component;

		public class GoodsConverter implements Converter<String, GoodsModel> {
			public GoodsModel convert(String source) {
				// 创建一个Goods实例
				GoodsModel goods = new GoodsModel();
				// 以“，”分隔
				String stringvalues[] = source.split(",");
				if (stringvalues != null && stringvalues.length == 3) {
					// 为Goods实例赋值
					goods.setGoodsname(stringvalues[0]);
					goods.setGoodsprice(Double.parseDouble(stringvalues[1]));
					goods.setGoodsnumber(Integer.parseInt(stringvalues[2]));
					return goods;
				} else {
					throw new IllegalArgumentException(String.format(
							"类型转换失败， 需要格式'apple, 10.58,200 ',但格式是[% s ] ", source));
				}
			}
		}
		```
		2. 注册自动类型转换器:
		```
		<!--   设置使用类型转换器  -->
		<mvc:annotation-driven conversion-service="conversionService"/>
		<bean id="conversionService"
			  class="org.springframework.context.support.ConversionServiceFactoryBean">
			<property name="converters">
				<list>
					<bean class="c_type_conversion.converter.GoodsConverter"/>
				</list>
			</property>
		</bean>
		```
		
		3. 教程中的formatter格式化有问题跳过
		```
		<bean id="conversionService" class="org.springframework.context.support.ConversionServiceFactoryBean">
        <property name="formatters">
				<list>
					<bean class="formatter.MyFormatter"/>
				</list>
			</property>
		</bean>
		<mvc:annotation-driven conversion-service="conversionService"/>
		```
			
			
			
			
			