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

1. HeapOOM: 堆内存溢出异常测试
    * 对象太多导致内存溢出

2. 栈溢出
    1. JavaVMStackSOF: StackOverflowError 线程分配好的栈内存被撑爆
    2. JavaVMStackOOM: OutOfMemoryError 创建线程太多系统2G内存被瓜分完

3. 直接溢出
    1. DirectMemoryOOM: 通过申请本机内存导致内存溢出