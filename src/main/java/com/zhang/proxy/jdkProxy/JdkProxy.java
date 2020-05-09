package com.zhang.proxy.jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/09/17:42
 * @Description: 动态代理核心类+核心方法
 */
public class JdkProxy {

    public static void main(String[] args) {
        final Target target = new Target();
        Class<? extends Target> targetClass = target.getClass();
       /* 参数:  1.目标对象的类加载器
                 2.与目标对象相同的接口字节码文件
                 3.代理的核心方法
          注意: jdk动态代理生成的对象和目标对象是兄弟关系,所以代理后的返回值需要用他们共同的父接口采用多台的方式接收
       */
        TargetInterface targetInterface = (TargetInterface) Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(), new InvocationHandler() {
            //不论执行目标对象的那个方法,实质上执行的都是这里的invoke方法
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //进行前置增强
                System.out.println("前置增强...");
                Object invokeResult = method.invoke(target,args);
                //进行后置增强
                System.out.println("后置增强...");
                return invokeResult;
            }
        });

        targetInterface.say();
    }
}
