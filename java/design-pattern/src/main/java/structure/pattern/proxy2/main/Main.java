package structure.pattern.proxy2.main;

import structure.pattern.proxy2.ProxyClass;
import structure.pattern.proxy2.SayInterface;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Main {
//
    public static void main(String[] args) {
//        proxyTest1();
        proxyTest2();
    }

    /**
     * 第二种实现方式
     */
    private static void proxyTest2() {
        ProxyClass<SayInterface> proxyClass = new ProxyClass(SayInterface.class);
        SayInterface proxyObject = proxyClass.getProxy();
        proxyObject.say("好样的");
        proxyObject.say(2019);
    }


    /**
     * 第一种实现方式，实现失败
     */
    private static void proxyTest1() {
        System.out.println("开始");
        Object object = Proxy.newProxyInstance(SayInterface.class.getClassLoader(), SayInterface.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println(o);
                System.out.println(method);
                System.out.println(objects);
                Object invoke = method.invoke(o, objects);
                return invoke;
            }
        });
//        System.out.println(object);
        if(object instanceof SayInterface){
            SayInterface sayInterface = (SayInterface)object;
            sayInterface.say("好样的！！");
        }



    }
}
