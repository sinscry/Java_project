##### JAVA常见面试题

* 链接:https://mp.weixin.qq.com/s?__biz=MzIwMTY0NDU3Nw==&mid=504458938&idx=1&sn=37f6f80073a4a50838e8697e5dcf7275&chksm=0d0f01f43a7888e2ae2f67c884664482c8fb5fc930cfa188e39346eda7c51a983bb7f4deb1f6#rd
* 当前:https://mp.weixin.qq.com/s?__biz=MzIwMTY0NDU3Nw==&mid=504458946&idx=1&sn=536fb5dfff90c8ef49f2f56dfba75aa8&chksm=0d0f018c3a78889a20056ef4c0a4c85fd22d149b3419ec4f63f843dd1b21e3ed322f2c3257b6#rd
# Java基础
	1. JDK 和 JRE有什么区别:
		* JDK: Java Development Kit，java工具开发包，提供java的开发环境和运行环境
		* JRE：Java Runtime Environment，java运行环境，为java运行提供所需环境
	2. == 和 equals 的区别：
		* equals本质等于==
		* equals函数在String和Integer中被重写了，使其变成值比较
		```
		//String的equals方法
		public boolean equals(Object anObject) {
		if (this == anObject) {
			return true;
		}
		if (anObject instanceof String) {
			String anotherString = (String)anObject;
			int n = value.length;
			if (n == anotherString.value.length) {
				char v1[] = value;
				char v2[] = anotherString.value;
				int i = 0;
				while (n-- != 0) {
					if (v1[i] != v2[i])
						return false;
					i++;
				}
				return true;
			}
		}
		return false;
		}
		```
	3. 两对象hashCode()相同，则equals()一定为true?
		* 错
		* 例子:"通话"和"重地"的hashCode()相同
	4. final在java中有什么用?
		* 修饰最终类，不能被继承
		* 不能被重写
		* 修饰的变量叫常量，常量必须初始化，初始化后值不能被修改
	5. java中Math.round(-1.5)等于多少?
		* 等于-1，因为在数轴上取值时，中间值(0.5)向右取整，Math.round(0.5)=1而Math.round(-1.5)=-1
	6. String属于基础的数据类型吗?
		* String不属于基础类型,属于对象
		* 基础类型:
			* byte：1（字节）
			* boolean：1或4
			* char：2
			* short：2
			* int：4
			* float：4
			* long：8
			* double：8
	7. java操作字符串有哪些类，有什么区别？
		* 不可变对象：String
		* 可变对象：
			* StringBuffer：线程安全---适合多线程
			* StringBuilder：非线程安全(性能高)---适合单线程
	8. String str="i"与String str=new String("i")一样吗?
		* 内存分配不一样：
			* String str="i"：分配到常量池
			* String str=new String("i")：分配到堆内存
	9. 字符反转
		* 使用StringBuilder或StringBuffer的reverse函数：
		```
		// StringBuffer reverse
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("abcdefg");
		System.out.println(stringBuffer.reverse()); // gfedcba
		// StringBuilder reverse
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("abcdefg");
		System.out.println(stringBuilder.reverse()); // gfedcba
		```
	10. String类的常用方法：
		* indexOf()：指定字符的索引
		* charAt()：返回指定索引处的字符
		* replace()：字符串替换
		* trim()：去除字符串两端空白
		* split()：分割字符串，返回分割后的字符串数组
		* getBytes()：返回字符串的byte类型数组
		* length()：返回字符串的长度
		* toLowerCase()：将字符串转为小写
		* toUpperCase()：将字符串转为大写
		* substring()：截取字符串
		* equals()：字符串比较
	11. 抽象类必须要有抽象方法?
		* 不需要
		```
		abstract class Cat {
			public static void sayHi() {
				System.out.println("hi~");
			}
		}
		```
	12. 普通类和抽象类的区别?
		* 普通类不含抽象方法，抽象类可含抽象方法
		* 抽象类不能直接实例化，普通类可以直接实例化
	13. 抽象类能使用final修饰吗?
		* 不能，final不能继承，抽象类需要继承，矛盾
	14. 接口和抽象类有什么区别
		* 实现: 抽象类的子类用extends，接口用implements
		* 构造函数：抽象类可有构造函数，接口不能
		* 实现数量：类可有多个接口，但只能有继承一个抽象类
		* 访问修饰符：接口方法默认用public,抽象类可以是任意修饰符
	15. java中IO流分为几种?
		* 功能：输入流(input)、输出流(output)
		* 类型：字节流和字符流
		* 区别：
			* 字节流：按8位传输以字节为单位输入输出
			* 字符流：按16位以字符为单位
	16. BIO、NIO、AIO有什么区别?
		* BIO：Block IO同步阻塞式IO，传统IO，使用简单并发处理弱
		* NIO：New IO同步非阻塞式IO，升级IO，客户端和服务器端通过Channel(通道)通讯，实现多路复用
		* AIO：Asynchronous IO异步非阻塞IO，NIO升级，基于事件和回调机制
	17. Files的常用方法:
		* Files.exists():检测文件路劲是否存在
		* Files.createFile()：创建文件
		* Files.createDirectory：创建文件夹
		* Files.delete()：删除文件或目录
		* Files.copy()：复制文件
		* Files.move()：移动文件
		* Files.size()：查看文件个数
		* Files.read()：读取文件
		* Files.write()：写入文件
	
	
		
		
		
			