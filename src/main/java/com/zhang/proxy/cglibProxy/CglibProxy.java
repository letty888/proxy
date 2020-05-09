package com.zhang.proxy.cglibProxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: zhangHuan
 * @date: 2020/05/09/17:59
 * @Description: cglib动态代理的核心类+核心方法
 */
public class CglibProxy {

    public static void main(final String[] args) {

        final Goal goal = new Goal();
        //1.创建增强器
        Enhancer enhancer = new Enhancer();
        //2.设置父类
        enhancer.setSuperclass(goal.getClass());
        //3.设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                //进行前置
                System.out.println("我是前置增强...");
                //执行目标方法
                Object invoke = method.invoke(goal, objects);
                //进行后置
                System.out.println("我是后置增强...");
                return invoke;
            }
        });
        //4.创建代理对象
        /**
         * 注意:cglib代理技术生成的代理对象和目标对象是子父关系,所以这里需要采用多态形式用目标对象接受
         */
        Goal proxy = (Goal) enhancer.create();
        proxy.study();
    }
}
