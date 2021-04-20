package garbageCollection;

/**
 * testGC(),objA和objB会不会被回收呢
 */
public class ReferenceCountingGC {
    public Object instance=null;
    private static final int _1MB=1024*1024;
    /**
     * 这个成员属性唯一意义是占内存，以便能在GC日志中看清楚是否有回收过.
     */
    private byte[] bigSize = new byte[2*_1MB];
    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        //假设在这行发生GC，objA和objB能被回收吗?
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
