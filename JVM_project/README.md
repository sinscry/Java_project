# 记录
* 注意:
    1. 常量池:
        * JDK7后原本放在永久代的字符串常量池被移至Java堆，常量池记录首次出现的实例的引用

* 基础知识
    1. 虚拟机栈: 局部变量表，操作数栈，动态连接，方法出口
        * 局部变量表：基本数据类型boolean,int,reference
    2. 本地方法栈：虚拟机使用到的本地方法(Native)服务
    3. Java堆栈：对象
    4. 方法栈：已被加载的类型信息，常量，静态变量
    5. 并发和并行：
        1. 并行(Parallel): 多条垃圾收集器线程之间的关系,用户线程处于等待
        2. 并发(Concurrent)：垃圾收集器线程与用户线程的关系,用户线程未冻结

1. HeapOOM: 堆内存溢出异常测试
    * 对象太多导致内存溢出

2. 栈溢出
    1. JavaVMStackSOF: StackOverflowError 线程分配好的栈内存被撑爆
    2. JavaVMStackOOM: OutOfMemoryError 创建线程太多系统2G内存被瓜分完

3. 直接溢出
    1. DirectMemoryOOM: 通过申请本机内存导致内存溢出
    
4. 垃圾回收
    * 实战:
        * 循环引用：ReferenceCountingGC
        * 自我拯救: FinalizeEscapeGC
        * 对象优先在Eden分配: testAllocation //java  -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 testAllocation
        * 大对象直接进入老年代: testPretenureSizeThreshold
        * 长期存活的对象将进入老年代：testTenuringThreshold
        * 动态对象判定: testTenuringThreshold2
        * 空间分配担保: testHandlePromotion
    * 可达性分析算法：当前主流
        * 固定GC Roots对象: 
            1. 虚拟机栈引用的对象， 
            2. 方法区类静态属性引用对象和常量引用对象， 
            3. 本地方法栈中JNI(常说的Native方法)引用对象
            4. 虚拟机内部引用，如基本数据类型对应Class对象，一些常驻的异常对象，系统加载器
            5. 所有同步锁(synchronized关键字)持有对象
            6. 反映JVM内部的JMXBean、JVMTI中注册的回调、本地代码缓存
        * 引用：
            1. 强引用：程序代码普遍引用赋值，只要存在关系就不会回收引用对象
            2. 软引用：还有用但非必须。在系统将要发生内存溢出异常前，会将对象列进回收范围进行二次回收
            3. 弱引用：非必须对象，垃圾收集器会回收无论是否内存够用
            4. 虚引用：目的为了能在这对象被收集器回收时收到一个系统通知，PhantomReference类实现虚引用
    * 分代收集理论：
        1. 弱分代假说（Weak Generational Hypothesis）：绝大多数对象都是朝生夕灭的
        2. 强分代假说（Strong Generational Hypothesis）：熬过越多次垃圾收集器过程的对象越难消亡
        3. 跨代引用假说（Intergenerational Reference Hypothesis): 跨代引用相对于同代引用来说仅占极少数
        * Java堆按年龄分配到不同区域存储：
            1. 新生代(Young Generation): 新生代在垃圾收集器存活进化为老年代
            1.1 记忆集: 在新生代上建立全局数据结构记忆集(Remember Set)，标识出老年代那一块存在跨代引用
            2. 老年代(Old Generation)
    * 算法：
        1. 标记-消除法(Mark-Sweep)：标记所有需要回收对象，再统一回收
            * 缺点：效率不稳定，随对象数量增长而降低；内存空间碎片化。
        2. 标记-复制法：Appel回收
            * 实现方法：新生代分为一块大的Eden和两小Survivor，每次分配内存只使用Eden和其中一个Survivor。GC后存活对象复制到另一个Survivor，然后直接清除Eden和当前Survivor
            * Eden：Survivor -> 8:1
            * 超过10%则从老年代借位置
        3. 标记-整理法(Mark-Compat)：老年代算法
            * 标记清除后移动对象并清楚边界外内存
    * 垃圾回收器实现
        1. HotSpot虚拟机
            1. 根节点枚举: 准确式垃圾收集，OopMap再类加载时存好根节点
            2. 安全点: 只计算安全点OopMap:
                1. 抢先式中断：先中断所有线程，再恢复未到安全点的线程运行到安全点
                2. 主动式中断：线程执行时不停检查是否要中断，要中断就到最近安全点中断
                3. 安全区域：确保代码片段引用关系不改变 
        2. 经典收集器
            1. 新生代
                1. Serial收集器(标记-复制算法)
                    * 单线程：垃圾收集时停掉所有工作线程
                    * 优点：简单高效，对于客户端模式虚拟机是很好选择
                2. ParNew收集器(Serial多线程版)
                    * 除Serial外唯一能与CMS老年代收集器配合工作
                3. Parallel Scavenge收集器(标记-复制算法)
                    * 特点: 吞吐量优先，使垃圾收集时间占比最少，而不是缩短垃圾收集时线程的停顿时间
            2. 老年代
                1. Serial Old收集器(标记-整理算法)
                    * 单线程
                2. Parallel Old(JDK 6标记-整理法)
                    * 多线程并发
                    * Parallel Scavenge老年版，搭配使用释放机能
                3. CMS(Concurrent Mark Sweep)收集器(标记-清除法)
                    * 特点：获取最短回收停顿时间
                    1. 初始标记：标记GC Roots (Stop the world)
                    2. 并发标记: 并发标记GC Roots关联对象(与垃圾收集线程一起并发)
                    3. 重新标记：修正并发间变动的对象(Stop the world比1久)
                    4. 并发清除：并发清理删除标记阶段判读死亡对象
                    * 缺点：
                        1. 占CPU资源：回收线程数=(处理器核心数+3)/4
                            * 增量式并发收集器(JDK 9发布后被完全抛弃)：运行时收集器线程与用户线程交替运行
                        2. 无法处理浮动垃圾：用户线程在标记过程结束后产生垃圾
                        3. 空间碎片问题
                4. Garbage First(G1)
                    * 面向局部收集和基于Region的内存布局形式(整体看是标记-整理法，局部是标记-复制法)
                    * JDK 9后成服务端下默认垃圾收集器
                    * 面向堆内存组成回收集(Collection Set)：哪块内存垃圾数量多，回收收益大回收哪个，Mixed GC
                    * 分代收集理论：把Java堆分成大小相同region，每一region都可根据需要扮演Eden空间、Survivor空间或者老年代空间
                        * Humongous区域：专门存储大对象，超过region容量一半则为大对象
                    * 过程：
                        1. 初始标记：暂停用户线程，标记GC Roots直接关联对象，修改TAMS指针值，让下一阶段用户线程并发运行
                        2. 并发标记：GC Root延申对象，扫描完后，重新处理SATB记录下并发时有引用变动对象
                        3. 最终标记：对用户线程短暂暂停，处理并发阶段后剩下少量的SATB记录
                        4. 筛选回收：并发根据期望构建回收集。把决定回收Region里的存活对象到空的Region，清除旧Region，过程暂停用户线程
                        * 除了2外都暂停用户线程，目标：延迟可控下尽可能获得高吞吐量
                        * 期望停顿时间：100-300毫秒
                * CMS vs G1: 小应用CMS，大应用G1，平衡点通常在6GB-8GB
        3. 低延迟收集器
            1. Shenandoah收集器
                * JDK 12：只有OpenJDK支持,RedHat公司研发
                * 目标：在任何堆内存大小下都可以把垃圾收集停顿控制在10毫秒内，并发清理垃圾
                * 发展：由G1演变来，不使用分代采集，将记忆集改成连接矩阵
                * 实现：转发指针
            2. ZGC(Z Garbage Collector):
                * 与Shenandoah高度相似
                * 特征：基于Region内存布局的，(暂时)不设分代的，使用读屏障，染色指针和内存多重映射实现的可并发的标记-整理算法的，低延迟收集器
                * 动态Region:小2MB:小于256KB小对象， 中32MB：256kb<x<4MB对象，大不固定2MB倍数：4MB以上对象
                * 实现：染色指针：转发指针带信息
        4. 垃圾收集器选择
            * 落后JDK和软硬件，4GB到6GB以下堆内存:CMS，更大堆内存:G1
            1. 数据分析，科学计算：吞吐量优先
            2. SLA应用，停顿时间影响服务质量：延迟优先->ZGC,稳定:Shenandoah
            3. 客户端应用或嵌入式应用：内存占用优先
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            