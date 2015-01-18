package fjab.javatech.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by fjab on 17/01/15.
 */
class MockGenerator {

    static <T> T createMock(Class<T> tClass,InvocationHandler invocationHandler){

        return (T) Proxy.newProxyInstance(tClass.getClassLoader(),new Class[] {tClass}, invocationHandler);
    }
}
