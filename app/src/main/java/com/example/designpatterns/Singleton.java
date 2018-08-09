package com.example.designpatterns;

/**
 * Author: Administrator
 * Time: 2018/8/9/009 22
 * This is Singleton
 * 单例模式
 * 缺点：扩展困难，单例如果持有Content容易引发内存泄漏，如果需要传，最好是App Content
 */
public class Singleton {
    private static Singleton singleton = null;

    public Singleton() {
    }

    public void doSomething() {
        System.out.println("do sth.");
    }

    /**
     * 懒汉模式
     * 优点：只有在使用到时才实例化，在一定程度上节约了资源
     * 缺点：第一次加载时要及时进行实例化，但最大的问题是每次调用getSingleton（）时都会进行同步，造成不必要的同步开销，不建议使用
     */
   /* public static synchronized Singleton getSingleton(){
        if(singleton==null){
            singleton  = new Singleton();
        }
        return singleton;
    }*/

    /**
     * 使用最多的单例，在高并发的条件下有可能会出错，这个问题被称为 双重检查锁定失效，
     */
  /*  public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }*/

    /**
     * 使用静态内部类：SingletonHolder
     * 建议使用的代码替代，（不过上面的已经够平时使用了）
     * 当第一次加载Singleton类时并不会初始化sSingleton，只有在第一次调用Singleton的getSingleton()方法时才会导致Singleton被初始化
     */
    public static Singleton getSingleton() {
        return SingletonHolder.sSingleton;
    }

    /**
     * 静态内部类
     */
    private static class SingletonHolder {
        private static final Singleton sSingleton = new Singleton();
    }
}
