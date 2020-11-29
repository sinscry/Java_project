# spring教程

## 该项目为spring实战第四版的实现，附带了本书电子版


1. 自动装配2.2:
	* 逻辑：用CD形象化表现spring自动装配的流程
	* 知识点：
		1. @Component:注解表明组件类，自动创建bean
		2. @ComponentScan:注解表明启用组件扫描，在配置类设置
		3. @ContextConfiguration(classes=CDPlayerConfig.class):
			* 表明这是配置类
		4. @Autowired:自动注入带属性的bean
			* 注解在函数上会自动寻找合适的bean去进行构造
			* 假如没有匹配的bean会抛出异常,因此需要@Autowired(required=false)规避
		
	* 三种装配方式
		1. 自动装配:
			* package Automatic_assembly.soundsystem
			* 通过@ComponentScan和@Component自动装配bean
		2. Java显式配置：
			* package Automatic_assembly.java_config
			* @Bean配置
		3. xml配置：
			* Beans.xml记得放在resources文件夹

2. 高级装配
	* 逻辑:根据profile选择性装配beans（在Profile包里）
	* 知识点：
		1. 可以用javaConfig和Beans.xml两种方式设置Bean的profile
		2. 在DataSourceConfig.class通过@Profile("prod")设置环境
		3. 在PersistenceTest.class设置@@ActiveProfiles("prod")激活prod环境