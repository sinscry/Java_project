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
3. [模块三:多线程](https://mp.weixin.qq.com/s?__biz=MzIwMTY0NDU3Nw==&mid=2651938314&idx=2&sn=31a724f4ee550e4d39f50d5f1b962d39&chksm=8d0f3144ba78b8528688547efe6ff8a06d78a0c8d1f1f3870bc2847d55907df53722e316a47e&scene=21#wechat_redirect)
	35. 并行和并发有什么区别:
		* 并行是指两个或多个事件在同一时刻发生，而并发是指两个或多个事件在同一时间间隔发生
		* 并行是在不同实体上的多个事件，并发是在同一实体上的多个事件
		* 在一台处理器"同时"处理多个任务，在多台处理器同时处理多个任务。如hadoop分布式集群
		* 并发编程的目标是充分利用处理器每一个核，以达到最高的处理性能
	36. 线程和进程的区别?
		* 简而言之，进程是程序运行和资源分配的基本单位，一个程序至少有一个进程，一个进程至少有一个线程。进程在执行过程中拥有独立的内存单元，而多个线程共享内存资源，减少切换次数，从而效率更高。线程是进程的一个实体，是cpu调度和分派的基本单位，是比程序更小的能独立运行的基本单位。同一进程中的多个线程之间可以并发执行。
	37. 守护线程是什么?
		* 守护线程(即daemon thread), 是个服务线程，准确说是服务其他的线程
	38. 创建线程有哪几种方式?
		1. 继承Thread类创建线程类
			* 定义Thread类的子类，并重写run()方法,该方法同样是该线程的执行体
			* 创建Thread子类的实例，即创建了线程对象
			* 调用线程对象的start()来启动该线程
		2. 通过RUnnable接口创建线程类	
			* 定义runnable接口实现类，并重写该接口的run(),同样是线程执行体
			* 创建Runnable实现类的实例，并依此实例作为Thread的target来创建Thread对象，该Thread对象才是真正的线程对象
			* 调用线程对象的start()方法来启动该线程
		3. 通过Callable和Future创建线程
			* 创建Callable接口的实现类，并实现call()方法，该call()方法为线程执行体，且有返回值
			* 创建Callable实现类的实例，使用FutureTask类来包装Callable对象，该FutureTask对象封装了该Callable对象的call()方法的返回值
			* 使用FutureTask对象作为Thread对象的target创建并启动新线程
			* 调用FutureTask对象作为Thread对象的target创建并启动新线程
			* 调用FutureTask对象的get()方法来获得子线程执行结束后的返回值
	39. 说一下runnable和callable有什么区别?
		* Runnable接口中的run()返回void,它只是纯粹执行run()代码
		* Callable接口中的call()有返回值的
	40. 线程有哪些状态?
		* 创建状态:生成线程对象未执行start()时
		* 就绪状态:调用start()，但此时线程调度程序未设置此线程未当前线程，此时处于就绪状态
		* 运行状态:线程调度程序将处于就绪状态的线程设置为当前线程，此时线程就进入了运行状态，开始运行run函数当中的代码
		* 阻塞状态：线程正在运行被暂停，通常是为了等待某个时间的发生(比如说某资源就绪)之后再继续进行。sleep,suspend,wait等方法都可以导致线程阻塞
		* 死亡状态: 如果一个线程的run方法执行结束或调用stop()，该线程就会死亡。对于已经死亡的线程，无法使用start()使其就绪
	41. sleep()和wait()有什么区别?
		* sleep()：该方法是线程类(Thread)的静态方法，让调用线程进入睡眠状态，让出执行机会给其他线程，等休眠时间结束后，线程进入就绪状态和其他线程一起竞争cpu的执行时间。因为sleep()是static静态的方法，它不能改变对象的机锁，当一个synchronized块中的调用了sleep()方法，虽然线程休眠，但对象的机锁没有释放，其他线程依然无法访问这个对象
		* wait():wait()是Object类的方法，当一个线程执行到wait方法时，它就进入到一个和该对象相关的等待池，同时释放对象的机锁，使其他线程能访问，可以通过notify，notifyAll来唤醒等待的线程
	42. notify()和notifyAll()有什么区别?
		* 如果线程调用对象的wait()方法，那么线程会处于该对象的等待池中，等待池中的线程不会去竞争该对象的锁
		* 当有线程调用对象的notifyAll()方法(唤醒所有wait线程)或notify()方法(只随机唤醒一个wait线程),被唤醒的线程便会进入该对象的锁池中，锁池中的线程会去竞争该对象的锁。也就是说，调用notify后只要一个线程会由等待池进入锁池，而notifyAll会将该对象等待池内所有的线程移动到锁池中，等待锁池竞争
		* 优先级高的线程竞争到对象锁的概率大，假若某线程没有竞争到该对象锁，它还会留在锁池中，唯有线程再次调用wait()方法，它才会重新回到等待池中。而竞争到对象锁的线程则继续往下执行，直到执行完synchronized代码块，它会释放掉该对象锁，这是锁池中的线程会继续竞争该对象锁。
	43. 线程的run()和start()的区别?
		* 每个线程都是通过某特定的Thread对象所对应的方法run()来完成其操作的，方法run()称为线程体。通过调用Thread类的start()方法来启动一个线程
		* start()方法启动一个线程，真正实现了多线程运行。这时无需等待run方法体代码执行完毕，可以直接继续执行下面代码；这是此线程是处于就绪状态，并没有运行。然后通过此Thread类调用方法run()来完成其运行状态，这里方法run()称为线程体，它包含了要执行的这个线程的内容，Run方法运行结束，此线程终止。然后CPU再调度其他线程。
		* run()方法是在本线程里的，只是线程里的一个函数，而不是多线程的。如果直接调用run(),其实就相当于调用了一个普通函数而已，直接调用run()方法必须等待run()方法执行完毕才能执行下面的代码，所以执行路径还是只有一条，根本没有线程的特征，所以在多线程执行时要使用start()方法而不是run()方法
	44. 创建线程池有哪几种方法?
		1. newFixedThreadPool(int nThreads)
			* 创建一个固定大小的线程池，每提交一次任务就创建一个线程，直到达到线程池的最大数量，这时线程规模不再变化，当线程发生未预期的错误而结束时，线程池会补充一个新的线程
		2. newCachedThreadPool()
			* 创建一个可缓存的线程池，如果线程池的规模超过了处理需求，将自动回收空闲线程，而当需求增加时，则可以自动添加新线程，线程池的规模不存在任何限制。
		3. newSingleThreadExecutor()
			* 这是一个单线程的Excutor,它创建单个工作线程来执行任务，如果这个线程异常结束，会创建一个新的来替代它，它的特点是能确保任务在队列中的顺序来执行
		4. newScheduledThreadPool(int corePoolSize)
			* 创建一个固定长度的线程池，而且以延迟或定时的方式来执行任务，类似于Timer
	45. 线程池都有哪些状态?
		* 线程池有5种状态: Running, ShutDown, Stop, Tidying, Terminated
	46. 线程池中submit()和execute()方法有什么区别?
		* 接收的参数不一样
		* submit()有返回值,execute没有
		* submit方便Exception处理
	47. 在java程序中怎么保证多线程的运行安全?
		* 原子性: 提供互斥访问，同一时刻只能有一个线程对数据进行操作(atomic,synchronized)
		* 可见性: 一个线程对主内存的修改可以及时地被其他线程看到(synchronized,volatile)
		* 有序性: 一个线程观察其他线程中的指令执行顺序，由于指令重排序，该观察结果一般杂乱无序(happens-before原则)
	48. 多线程锁的升级原理是什么?
		* 在Java中，锁有4种状态，级别从低到高依次为:无状态锁，偏向锁，轻量级锁和重量级锁状态，这几个状态会随着竞争情况逐渐升级。锁可以升级但不能降级
	49. 什么是死锁?
		* 死锁是指两个或两个以上的进程在执行过程中，由于竞争资源或由于彼此通信而造成的一种阻塞的现象，若无外力作用，它将无法推进下去。此时系统处于死锁状态，这些永远在等待的进程称为死锁进程。是操作系统层面的一个错误，是进程死锁的简称，最早在1965年由Dijkstra在研究银行家算法时提出的,它是计算机操作系统乃至整个并发程序设计领域最难处理的问题之一。
	50. 如何防止死锁?
		* 死锁的四个必要条件
			1. 互斥条件: 进程对所分配的资源不允许其他进程进行访问，若其他进程访问该资源，只能等待，直至占有该资源的进程使用完成后释放该资源
			2. 请求和保持条件: 进程获得一定的资源后，又对其他资源发出请求，但是该资源可能被其他进程占有，此时请求阻塞，但又对自己获得的资源保持不放
			3. 不可剥夺条件: 进程已获得的资源，在未完成之前，不可剥夺，只能在使用完后自己释放
			4. 环路等待条件: 是指进程发生死锁后，若干进程之间形成一种头尾相接的循环等待资源关系
	51. ThreadLocal是什么?有哪些使用场景?
		* 线程局部变量是局限于线程内部的变量，是属于线程自身所有，不在多个线程间共享。Java提供ThreadLocal类来支持线程局部变量，是一种实现线程安全的方式。但是在管理环境下(web)使用线程局部变量要特别小心，在这种情况下，工作线程的生命周期比任何应用变量的生命周期都要长。任何线程局部变量一旦在工作完后没释放，Java应用存在内存泄漏的风险。
	52. 说一下synchronized底层实现原理?
		* synchronized可以保证方法或代码块在运行时，同一时刻只有一个方法可以进入到临界区，同时可以保证共享变量内存可见性
		* Java每一个对象都可以作为锁，这是synchronized实现同步的基础
			* 普通同步方法，锁是当前实例对象
			* 静态同步方法，锁是当前类的class对象
			* 同步方法块，锁是括号里面的对象
	53. synchronized和volatile的区别?
		* volatile本资是告诉jvm当前变量在寄存器(工作内存)中的值是不确定的，需要从主存中读取，synchronized则是锁定当前变量，只有当前线程可以访问该变量，其他线程被阻塞
		* volatile只能使用变量级别，synchronized则可以使用在变量、方法和类级别的
		* volatile仅能实现变量的修改可变性，不能保证原子性，synchronized则可以保证变量的修改可变性和原子性。
		* volatile不会造成线程的阻塞；synchronized可能会造成线程的阻塞
		* volatile标记的变量不会被编译器优化，synchronized标记的变量可以被编译器优化
	54. synchronized和Lock有什么区别?
		* synchronized是java内置关键字，在jvm层面，Lock是java类
		* synchronized无法判断是否获取锁的状态，Lock可以判断是否获取到锁
		* synchronized会自动释放锁(a 线程执行完同步代码会释放锁；b线程执行过程中发生异常会释放锁),Lock需在finally中手工释放锁(unlock()方法释放),否则容易造成线程死锁
		* 用synchronized关键字的两个线程1和线程2，如果当前线程1获得锁，线程2线程等待。如果线程1阻塞，线程2会一直等待下去，而Lock锁不一定会等待下去，如果尝试获取不到锁，线程可以不用一直等待就结束了
		* synchronized的锁可重入、不可中断、非公平，而Lock锁可重入、可判断、可公平(两者皆可)
		* Lock锁适合大量同步的代码的同步问题，synchronized锁适合代码少量的同步问题
	55. synchronized和ReentrantLock区别是什么?
		* synchronized是和if、else、for、while一样的关键字，ReentrantLock是类，这是二者的本质区别。既然ReentrantLock是类，那么它就提供了比synchronized更多更灵活的特性，可以被继承、可以有方法、可以有各种各样的类变量，ReentrantLock比synchronized的扩展性体现在几点上
			1. ReentrantLock可以对获取锁的等待时间进行设置，这样就避免了死锁
			2. ReentrantLock可以获取各种锁的信息
			3. ReentrantLock可以灵活地实现多路通知
		* 另外二者的锁机制也不一样：ReentrantLock底层调用的是Unsafe的park方法加锁，synchronized操作的应该是对象头中mark word
	56. 说一下atomic的原理?
		* Atomic包中的类基本的特性就是在多线程环境下，当有多个线程同时对单个(包括基本类型及引用类型)变量进行操作时，具有排他性，即多个线程对该变量的值进行更新时，仅有一个线程能成功，而未成功的线程可以像自旋锁一样，继续尝试，一直等到执行成功
		* Atomic系列的类中的核心方法都会调用unsafe类中的几个本地方法。我们需要先知道一个东西就是Unsafe类，全名:sun.misc.Unsafe，这个类包括大量对C代码的操作，包括很多直接内存分配以及原子操作的调用，而它之所以标记为非安全的，是告诉你这个里面大量的方法调用都会存在安全隐患，需要小心操作，否则会导致严重的后果。例如在通过unsafe分配内存的时候，如果自己指定某些区域可能会导致一些类似C++一样的指针越界到其他进程的问题
4. 模块四: 反射
	57. 什么是反射?
		* 反射是指程序可以访问、检测和修改它本身状态或行为的一种能力
		* java反射:
			* 在Java运行时环境中，对于任意一个类，能否知道这个类有哪些属性喝方法?对任意一个类，能否知道这个类有哪些属性和方法?对于任意一个对象，能否调用它的任意一个方法
			* Java反射机制主要提供了以下功能:
				1. 在运行时构造任意一个对象所属的类
				2. 在运行时构造任意一个类的对象
				3. 在运行时判断任意一个类所具有的成员变量和方法
				4. 在运行时调用任意一个对象的方法
	58. 什么是java序列化?什么情况下需要序列化?
		* 为保存内存中各对象的状态(也就是实例变量，不是方法),并且可以把保存的对象状态再读出来。虽然你可以用你自己的各种各样的方法来保存object states，但是Java给你提供一种应该比你自己好的保存对象状态的机制，那就是序列化
		* 什么情况下需要序列化:
			1. 当你想把内存中的对象状态保存在一个文件或者数据库中时候
			2. 当你想用套接字在网络上传送对象的时候
			3. 当你想通过RMI传输对象的时候
	59. 动态代理是什么? 有哪些应用?
		* 当想要给实现了某个接口的类中的方法，加一些额外的处理。比如说加日志，加事务等。可以给这个类创建一个代理，顾名思义就是创建一个新的类，这个类不仅包含原来类的功能，而且还在原来的基础上添加了额外处理的新类。这个代理类并不是定义好的，是动态生成的。具有解耦意义，灵活，扩展性强。
		* 动态代理应用:
			* Spring的AOP
			* 加事务
			* 加权限
			* 加日志
	60. 怎么实现动态代理?
		* 首先必须定义一个接口，还要有一个InvocationHandler(将实现接口的类的对象传递给它)处理类。再有一个工具类Proxy(习惯性将其称为代理类，因为调用她的newInstatnce()可以产生代理对象，其实他只是一个产生代理对象的工具类)。利用到InvocationHandler,拼接代理类源码，将其编译生成代理类的二进制码，利用加载器加载，并将其实例化产生代理对象，最后返回。
5. 模块五：对象拷贝
	61. 为什么要使用克隆?
		* 想对一个对象进行处理，又想保留原有的数据进行接下来的操作，就需要克隆了，Java语言中克隆针对的是类的实例。
	62. 如何实现克隆?
		1. 实现Cloneable接口并重写Object类中的clone()方法
		2. 实现Serializable接口，通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆
		```
		
		public class MyUtil{
			private MyUtil(){
				throw new AssertionError();
			}
			
			@SuppressWarnings("unchecked")
			public static<T extends Serilizable> T clone(T obj) throws Exception{
				ByteArrayOutputStream bout = new ByteArrayOutoutStream();
				ObjectOutputStream oos = new ObjectOutputStream(bout);
				oos.writeObject(obj);
				
				ByteArrayInputStream bin = new ByteArrayInputStream(bout,toByteArray());
				ObjectInputStream ois = new ObjectInputStream(bin);
				return (T) ois.readObject();
			
			}
		
		}
		```
	63. 深拷贝和浅拷贝区别是什么?
		1. 浅拷贝只是复制了对象的引用地址，两个对象指向同一个内存地址，所以修改其中任意的值，另一个值都会随之变化，这就是浅拷贝(例如:assign())
		2. 深拷贝是将对象及值复制过来，两个对象修改其中任意的值另一个值不会改变，这就是深拷贝(例:JSON.parse()和JSON.stringify(),但是此方法无法复制函数类型)
			
   		
   		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
		
		
		
			