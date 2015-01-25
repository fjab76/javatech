package fjab.javatech.dynamicproxy.interception.case2;

import fjab.javatech.dynamicproxy.interception.case2.MyServiceClass;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fjab on 25/01/15.
 */
public class MyServiceFactory {

    private static Map<String,Long> time = new HashMap<String,Long>();

    private MyServiceFactory(){}

    static MyServiceClass getInstance(){

        return createProxy(MyServiceClass.class,new MyServiceHandler());
    }

    private static <T> T createProxy(Class<T> tClass,InvocationHandler invocationHandler){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(MyServiceClass.class);
        enhancer.setCallback(invocationHandler);
        return (T) enhancer.create();
    }

    private static class MyServiceHandler implements InvocationHandler{

        MyServiceClass myService = new MyServiceClass();

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long t = System.currentTimeMillis();
            Object object  = method.invoke(myService,args);
            long timeElapsed = (System.currentTimeMillis()-t)/1000;
            time.put(method.getName(),timeElapsed);

            return object;
        }
    }

    static Map<String, Long> getTime() {
        return time;
    }
}
