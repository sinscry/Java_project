# SpringBoot教程
记录:73页post

1. main函数实行(package Hello_World):
	```
		package Hello_World;
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		
		@SpringBootApplication
		public class AppApplication {
			public static void main(String[] args){
				SpringApplication.run(AppApplication.class,args);
			}
		}
	```
2. Controller自动装配(package Hello_World):
	1. 注解设置成直接返回文字:`@ResponseBody`
	```
	package Hello_World.controller;
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
	2. 传递参数页面
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
3. 模板页面(package Search)
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
4. 表单发送(package Search)
	1. get方式
	```
	<form action="/result" method="get">
		<input id="search" name="search" type="text"/>
		<label for="search">Search</label><br/>
		<input type="submit" value="Submit"/>
	</form>
	```
		* controller同2.2 url传参
		* <input>中的name对应contrller中的value
	2. post方式
		* 更改<form method="post">
		* 通过post处理数据再:
			`return "redirect:result"`;
		
		
		