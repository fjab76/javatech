package fjab.javatech.dynamicproxy.interception;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fjab on 24/01/15.
 */
public class MyServiceFactory {

    private static Map<String,Long> time = new HashMap();

    static MyService getInstance(){

        return createProxy(MyService.class,new MyServiceHandler());
    }

    private static <T> T createProxy(Class<T> tClass,InvocationHandler invocationHandler){

        return (T) Proxy.newProxyInstance(tClass.getClassLoader(), new Class[]{tClass}, invocationHandler);
    }

    private static class MyServiceHandler implements InvocationHandler{

        MyService myService = new MyServiceImpl();

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
