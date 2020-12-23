##### JAVA常见面试题

* [目录链接](https://mp.weixin.qq.com/s/rkYk318HDSiLC4HZIGx1Zg)
* [当前进度](https://mp.weixin.qq.com/s?__biz=MzIwMTY0NDU3Nw==&mid=504458946&idx=1&sn=536fb5dfff90c8ef49f2f56dfba75aa8&chksm=0d0f018c3a78889a20056ef4c0a4c85fd22d149b3419ec4f63f843dd1b21e3ed322f2c3257b6#rd)
# Java基础
1. [模块一(基础)](https://mp.weixin.qq.com/s?__biz=MzIwMTY0NDU3Nw==&mid=504458938&idx=1&sn=37f6f80073a4a50838e8697e5dcf7275&chksm=0d0f01f43a7888e2ae2f67c884664482c8fb5fc930cfa188e39346eda7c51a983bb7f4deb1f6#rd)
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
   9.  字符反转
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
   11. String类的常用方法：
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
2. [模块二(容器)](https://mp.weixin.qq.com/s?__biz=MzIwMTY0NDU3Nw==&mid=504458946&idx=1&sn=536fb5dfff90c8ef49f2f56dfba75aa8&chksm=0d0f018c3a78889a20056ef4c0a4c85fd22d149b3419ec4f63f843dd1b21e3ed322f2c3257b6#rd)
	18.   Java容器有哪些:
        * Collection
        	1. List:
        		* vector->stack
        		* ArrayList
        		* LinkedList
        	2. Queue:
        		* LinkedList
        		* PriorityQueue
        	3. Set:
        		* HashSet->LinkHashSet
              		* TreeSet
         * Map:
         	1. HashMap
         	2. TreeMap
	19.  Collection 和 Collections有什么区别?
       * java.util.Collection是一个集合接口(集合类的一个顶级接口)。它提供了对集合对象进行基本操作的通用接口方法。Collection接口在Java类库中有很多具体的实现。Collection接口的意义是为各种具体的集合提供了最大化的统一操作方式，其直接继承接口有List和Set。
	   * Collections则是集合类的一个工具类/帮助类，其中提供了一系列静态方法，用于对集合元素进行排序、搜索以及线程安全等各种操作。
	20. List、Set、Map之间的区别是什么?
		1. List:
			* 继承接口: Collection
			* 常见实现类:AbstractList(其常见子类ArrayList、LinkedList、Vector)
			* 常见方法:add(),remove(),clear(),get(),contains(),size()
			* 元素:可重复
			* 顺序:有序
			* 线程安全:Vector线程安全
		2. Set:
			* 继承接口: Collection
			* 常见实现类:AbstractSet(其常见子类HashSet、LinkedHashSet、TreeSet)
			* 常见方法:add(),remove(),clear(),get(),contains(),size()
			* 元素:不可重复(用equals()判断)
			* 顺序:无序(实际是用HashCode()判断)
			* 线程安全:
		3. Map:
			* 继承接口:
			* 常见实现类:HashMap,HashTable
			* 常见方法:put(),get(),clear(),containsKey(),containValue(),KeySet(),values(),size()
			* 元素:不可重复
			* 顺序:
			* 线程安全:HashTable线程安全
	21. HashMap 和 HashTable有什么区别?
		* hashMap去掉HashTable的contains方法，但加上containsValue()和containsKey()方法
		* hashTable同步的,而HashMap是非同步的，效率比hashTable高
		* hashMap允许空键值，而hashTable不允许
	22. 如何决定是使用HashMap还是TreeMap?
		* 对于在Map中插入、删除和定位元素这类操作，HashMap是最好的选择。然而，假如你需要对一个有序的key集合进行遍历，TreeMap是更好的选择。基于你的collection的大小，也许向HashMap中添加元素会更快，将map换位TreeMap进行有序key的遍历
	23. 说一下HashMap的实现原理?
		* 概述: HashMap是基于哈希表的Map接口的非同步实现。此实现提供所有可选的映射操作，并允许使用null值和null键。此类不保证映射的顺序，特别是它不保证该顺序恒久不变。
		* 数据结构:在java中，最基本的结构就数组和模拟指针(引用),所有的数据结构都可用这两个基本结构造，HashMap也是。HashMap实际上是链表散列，即数组和链表的结合体
		* 过程:当往Hashmap put元素时，首先根据key的hashcode重新计算hash值，根据hash值得到这个元素在数组中的位置，若已有元素则通过链表存放，新加入元素放链头，最先的元素在链尾
		* 注意:jdk1.8中对HashMap实现优化，当链表节点数据超过8后，该链表会转为红黑树，从O(n)到O(logn)
	24. 说一下HashSet的实现原理?
		* HashSet底层由HashMap实现
		* HashSet的值存放在HashMap的key上
		* HashMap的value统一为PRESENT
	25. ArrayList和LinkedList的区别是什么?
		* 最明显的区别是ArrayList底层数据结构是数组，支持随机访问，而LinkedList的底层是双向循环链表，不支持随机访问，使用下标访问一个元素，ArrayList是O(1),LinkedList是O(n)
	26. 如何实现数组和List之间的转换?
		* List->数组:调用ArrayList的toArray()方法
		* 数组->List:调用Arrays的asList方法
	27. ArrayList和Vector的区别是什么?
		* vector是同步的，ArrayList不是。然而如果你寻求在迭代时对列表改变，应使用CopyOnWriteArrayList
		* ArrayList比vector快，因为它有同步，不会过载
		* ArrayList更加通用，因为我们可以使用Collections工具类轻易获取同步列表和只读列表
	28. Array和ArrayList有什么区别?
		* Array可以容纳基本类型和对象，ArrayList只能容纳对象
		* Array是指定大小的，ArrayList大小是固定的
		* Array没有提供ArrayList那么多功能，比如addAll、removeAll、iterator
	29. 在Queue中poll()和remove()有什么区别？
		* poll()和remove()都是从队列中取出一个元素，但是poll()在获取元素失败的时候会返回空，但是remove()失败的时候会抛出异常
	30. 哪些集合是线程安全的?
		* vector: 比ArrayList多个同步化机制(线程安全),因为效率低，以及不建议使用。在web应用中，特别是前台页面，往往效率(页面响应速度)是优先考虑的
		* stack: 堆栈类，先进后出
		* hashtable: 就比hashMap多个线程安全
		* enumerator:枚举，相当迭代器
	31. 迭代器Iterator是什么?
		* 迭代器是一种设计模式，是一个对象，可遍历并选择序列中的对象，而开发人员不需要了解该序列的底层结构。迭代器被称为轻量型对象，因为创建它的代价小
	32. Iterator怎么使用?有什么特点?
		* Java中的Iterator功能简单，且只能单向移动:
			* 使用iterator()要求容器返回与1个Iterator，第一次调用Iterator.next()方法，返回序列的第一个元素。注意:iterator()方法是java.lang.Iterable接口，被Collection继承
			* 使用next()获得序列中的下一个元素
			* hasNext()检查序列是否还有元素
			* remove()将迭代器返回的元素删除
		* Iterator是Java迭代器最简单的实现，为List涉及的ListIterator具有更多功能，它可从两个方向遍历List,也可以从List插入和删除元素
	33. Iterator和ListIterator有什么区别?
		* Iterator可用来遍历Set和List集合,ListIterator只能遍历List
		* Iterator对集合只能是前向遍历,ListIterator既可以前向也可以后向
		* ListIterator实现了Iterator接口，并包含其他功能，比如怎加元素，替换元素，获取前一个和后一个元素的索引
		
   		
   		
   		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
		
		
		
			