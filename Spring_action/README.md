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

3. 面向切面编程
	* package Aop
	1. 定义切面:
		* 逻辑: 使用注解@Aspect表明是切面
		* 知识点：
			1. 调用时段：
				* @After：通知方法在目标返回或抛出异常后调用
				* @AfterReturing：通知方法在目标方法返回后调用
				* @AfterThrowing：通知方法在目标方法抛出异常后调用
				* @Around：通知方法会将目标方法封装起来
				* @Before：通知方法会在目标方法调用前执行
			2. 表达式:
				0. 参数表达式:
					1. 无参:
						1. 逻辑:在Aop.concert包下Performance类的方法perform执行前执行 
						2. `"execution(** Aop.concert.Performance.perform(..))"`
					2. 有参:
						1. 逻辑:接受int类型参数，指定参数为trackNumber
						2. `"execution(* soundsystem.CompactDisc.playTrack(int))&& args(trackNumber)"`
				1. @Before示例:
					* 逻辑:
					* 直接使用: 
						```
						@Before("execution(** Aop.concert.Performance.perform(..))")
						public void silenceCellPhones(){
							System.out.println("Silencing cell phones");
						}
						```
					* 定义切点:
						1. 定义:
							```
							@Pointcut("execution(** Aop.concert.Performance.perform(..))")
							public void performance(){}
							```
						2. 使用:
							```
							@Before("performance()")
							public void takeSeats(){
								System.out.println("Taking seats");
							}
							```
				2. @Around示例:
					1. 逻辑: 通过jp.proceed实现@Before和@After结合
						```
						@Around("performance()")
						public void watchPerformance(ProceedingJoinPoint jp){
							try{
								System.out.println("Silencing cell phones");
								System.out.println("taking seats");
								jp.proceed();
								System.out.println("CLAP CLAP CLAP!!!");
							}catch (Throwable e){
								System.out.println("Demanding a refund");
							}
						}
						```
					2. 知识点: jp.proceed()如果不调用会阻塞对被通知方法的访问
			3. JavaConfig启用Aspect注解自动代理:
				```
				@Configuration
				@EnableAspectJAutoProxy
				public class AopConfig {
					@Bean
					public Dance Dancer(){
						return new Dance();
					}

					@Bean
					public Audience audience(){
						return new Audience();
					}
				}
				```
			4. 注解引入新方法:
				1. 使DefaultEncoreable拥有Performance.perform()方法
				```
				@Aspect
				public class EncoreableIntroducer {
					@DeclareParents(value = "Aop.concert.Performance+",
									defaultImpl = DefaultEncoreable.class)
					public static Encoreable encoreable;
				}
				```
				2. 使用时得强转类型:
				```
					encoreable.performEncore();
					Performance p2 = (Performance) encoreable;
					p2.perform();
				```
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		