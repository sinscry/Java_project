# SpringBoot教程
记录:98页3.3.3,卡在bundle语言切换上

0. 依赖:
	```
	<!--指定父级依赖-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.5.9.RELEASE</version>
    </parent>
    <!--添加依赖-->
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
    </dependencies>
	```


1. main函数实行(package a_Hello_World):
	```
		package a_Hello_World;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		
		@SpringBootApplication
		public class AppApplication {
			public static void main(String[] args){
				SpringApplication.run(AppApplication.class,args);
			}
		}
	```
2. Controller自动装配(package a_Hello_World):
	1. 注解设置成直接返回文字:`@ResponseBody`
	```
	package a_Hello_World.controller;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.ResponseBody;

	@Controller
	public class HelloController {
		@RequestMapping("/")
		@ResponseBody
		public String hello(){
			return "Hello, world!";
		}
	}
	```
	2. 访问html界面:
		1. 创建文件
			* 在resources下创建`static.pages`, 把html放进去
			* 在resources下创建`application.properties`写入:
				```
				spring.mvc.view.prefix=/pages/
				spring.mvc.view.suffix=.html
				```
		2. Controller:
			```
			@Controller
			public class IndexController {
				@RequestMapping("/")
				public String index(Model model){
					return "Index";
				}
			}
			```
	
	
	
	
	
	3. 传递参数页面
		* 当访问"http://localhost:8080/"他会自动关联到resultPage.html
		* resultPage.html设置:
		```
		<!DOCTYPE html>
		<html xmlns:th="http://www.thymeleaf.org">
		<head lang="en" >
			<meta charset="UTF-8"/>
			<title>Hello thymeleaf</title>
		</head>
		<body>
			<span th:text="${message}">Hello html</span>
		</body>
		</html>
		```
		* Controller设置:
		```
		@Controller
		public class HelloController {
			@RequestMapping("/")
			public String hello(Model model){
				model.addAttribute("message","Hello from the controller");
				return "resultPage";
			}
		}
		```
		* 传递参数的方式:
			1. url传参
				* url `localhost:8080/?name=sinscry`
				* Controller: 
					若没有name参数则直接userName默认为"default"
					`public String hello(@RequestParam(value="name",defaultValue = "default") String userName, Model model)`
			2. post传参如下
			3. 用直接controller添加属性:
				```
				@ModelAttribute("dateFormat")
				public String localeFormat(Locale locale){
				   return USLocalDateFormatter.getPattern(locale);
				}
				```
3. 模板页面(package b_Search)
	* default.html:
	
	```
	<html xmlns:th="http://www.thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
  
	<section layout:fragment="content">
		<p>Page content goes here</p>
	</section>
	```
	* resultPage.html:
	```
	<html xmlns:th="http://www.thymeleaf.org"
	xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
	layout:decorator="layout/default">
	
	<div layout:fragment="content">
		<span th:text="${message}">Hello html</span>
	</div>
	```
4. 表单发送(package b_Search)
	1. get方式
		* html:
		```
		<form action="/result" method="get">
			<input id="search" name="search" type="text"/>
			<label for="search">b_Search</label><br/>
			<input type="submit" value="Submit"/>
		</form>
		```
		* controller同2.2 url传参
		* <input>中的name对应contrller中的value
	2. post方式
		* html:
		```
		<form action="/postSearch" method="post">
		<input id="post_search" name="search" type="text"/>
		<label for="post_search">Post方式</label><br/>
		<input type="submit" value="Post"/>
		</form>
		```
		* controller:
		```
		@RequestMapping(value = "/postSearch", method = RequestMethod.POST)
		public String postSearch(HttpServletRequest request, RedirectAttributes redirectAttributes){
			String search = request.getParameter("search");
			if(search.toLowerCase().contains("struts")){
				redirectAttributes.addFlashAttribute("error","Try using spring instead!");
				return "redirect:/";
			}
			redirectAttributes.addAttribute("search",search);
			return "redirect:result";
		}
		```
		
5. 配置icon
	* 生成图标网站:https://tool.lu/favicon/
	* 必须重命名为favicon.ico
	* 放在 main/resources/static下