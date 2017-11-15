package com.wenbin.base.jvm;

/**
 * Created by wenbin on 2017/11/16.
 * 此代码演示了两点:
 * 1.对象可以在被GC时自我拯救
 * 2. 这种自救的机会只有一次,因为一个对象的finalize()方法只会被系统自动调用一次
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOME = null;

    public void isAlive() {
        System.out.println("yes, i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finallze method executed !");
        FinalizeEscapeGC.SAVE_HOME = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOME = new FinalizeEscapeGC();

        // 对象第一次成功拯救自己
        SAVE_HOME = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOME != null) {
            SAVE_HOME.isAlive();
        } else {
            System.out.println("no , i am dead :(");
        }

        // 下面这段代码与上面的完全相同,但是这次却失败了
        SAVE_HOME = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOME != null) {
            SAVE_HOME.isAlive();
        } else {
            System.out.println("no , i am dead :(");
        }
    }
}
