package com.weidai.study.parttendesign.singleton;


/**
 * @描述
 * @author nic 
 * @time：2018年8月5日 下午6:41:05
 */
public class Singleton {

    private static class LazyHolder {    
        private static final Singleton INSTANCE = new Singleton();    
     }    
     private Singleton (){}
     // 只有调用该方法时 才会调用实例化
     public static final Singleton getInstance() {    
        return LazyHolder.INSTANCE;    
     }  
}
