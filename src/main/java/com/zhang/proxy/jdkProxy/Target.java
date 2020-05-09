package com.zhang.proxy.jdkProxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/09/17:42
 * @Description: 需要被代理的目标对象
 */
public class Target implements TargetInterface {

    public void say() {
        System.out.println("我是中国人...");
    }
}
