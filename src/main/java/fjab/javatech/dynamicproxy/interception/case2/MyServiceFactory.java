package fjab.javatech.dynamicproxy.interception.case2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fjab on 25/01/15.
 */
public class MyServiceFactory {

    private static Map<String,Long> time = new HashMap<String,Long>();

    private MyServiceFactory(){}

    static MyServiceClass getInstance(){

        return createProxy(MyServiceClass.class);
    }

    private static <T> T createProxy(Class<T> tClass){

        MethodInterceptor methodInterceptor = (Object o, Method method, Object[] args, MethodProxy methodProxy) -> {
            long t = System.currentTimeMillis();
            Object object  = methodProxy.invokeSuper(o,args);
            long timeElapsed = (System.currentTimeMillis()-t)/1000;
            time.put(method.getName(),timeElapsed);

            return object;
        };

        Enhancer enhancer = new Enhancer();
        return (T) enhancer.create(tClass,methodInterceptor);
    }


    static Map<String, Long> getTime() {
        return time;
    }
}
