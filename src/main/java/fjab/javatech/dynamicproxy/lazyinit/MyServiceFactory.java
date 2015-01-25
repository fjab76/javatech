package fjab.javatech.dynamicproxy.lazyinit;

import fjab.javatech.dynamicproxy.interception.*;
import fjab.javatech.dynamicproxy.lazyinit.MyServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by fjab on 25/01/15.
 */
public class MyServiceFactory {

    static MyService getInstance(){

        return createProxy(MyService.class,new MyServiceHandler());
    }

    private static <T> T createProxy(Class<T> tClass,InvocationHandler invocationHandler){

        return (T) Proxy.newProxyInstance(tClass.getClassLoader(), new Class[]{tClass}, invocationHandler);
    }

    static class MyServiceHandler implements InvocationHandler{

        private MyService myService;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

            if (myService == null) {
                myService = new MyServiceImpl();
            }

            return method.invoke(myService,args);
        }

        public MyService getMyService() {
            return myService;
        }
    }
}
