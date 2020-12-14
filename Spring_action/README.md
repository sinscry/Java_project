# spring教程

## 该项目为spring实战第四版的实现，附带了本书电子版


1. 自动装配2.2:
	* package : Automatic_assembly
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
	* package : Profile
	1. 选择装配:
		* 逻辑:根据profile选择性装配beans（在Profile包里）
		* 知识点：
			1. 可以用javaConfig和Beans.xml两种方式设置Bean的profile
			2. 在DataSourceConfig.class通过@Profile("prod")设置环境
			3. 在PersistenceTest.class设置@@ActiveProfiles("prod")激活prod环境
	2. 条件装配:
		* 逻辑: 通过@Conditional判断是否装配bean
		* 知识点：重写Conditional的matches函数
	3. 限定自动装配的bean(解决歧义)：
		* 逻辑:利用@Qualifier注解决定自动装配哪个
		* 知识点：
			1. 通过@Autowired下设置@Qualifier("Bean名")能直接取到想要的bean
			2. 在@Bean下可以自定义@Qualifier名
	4. 作用域：
		* 逻辑：根据需要设置bean的实例是否相同
		* 知识点:
			0. 在@Bean下通过@Scope设置作用域
			1. 默认为单例(Singleton):整个应用仅有一个实例
			2. 原型(Prototype):
				* 每次注入时新建bean实例
				* @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
			3. 会话域(Session):
				* 在Web应用中，为每个会话创建一个bean实例
				* @Scope(value=WebApplicationContext.SCOPE_SESSION,
						proxyModel=ScopedProxyMode.INTERFACES)