package structure.pattern.proxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * �ӿڴ�����
 * @param <T>
 */
public class ProxyClass<T> implements InvocationHandler {

    private Class<T> proxyInterface;


    public ProxyClass(Class<T> proxyInterface){
        this.proxyInterface = proxyInterface;
    }


    /**
     * @Author xiangning
     * @Description //TODO
     * @Date 16:15 2019/11/28
     * @Param [proxy, method, args]
     * @return java.lang.Object
     **/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(this.proxyInterface);
        System.out.println("��ʼ����");
        System.out.println(args);
        if("say".equals(method.getName())){
//            String str = (String)method.invoke(proxy, args);
            System.out.println("���óɹ�");
            System.out.println(method);
            Class<?>[] parameterTypes = method.getParameterTypes();
            if(args[0] instanceof String){
                System.out.println("�������ַ��� --> " + args[0].toString());
            }else if(args[0] instanceof Integer){
                System.out.println("���������ַ��� --> " + args[0].toString());
            }
//            System.out.println(proxy);
        }

        return null;
    }


    public T getProxy(){
        return (T) Proxy.newProxyInstance(
                proxyInterface.getClassLoader(),new Class[]{proxyInterface},this);
    }









}
