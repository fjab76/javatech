package fjab.javatech.dynamicproxy.lazyinit.case2;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.LazyLoader;

/**
 * Created by fjab on 30/01/15.
 */
class MyServiceFactory {

    private MyServiceFactory(){}

    static MyServiceClass getInstance(){

        return createProxy(MyServiceClass.class);
    }

    private static <T> T createProxy(Class<T> tClass){

        LazyLoader lazyLoader = () -> {
            return new MyServiceClass();
        };

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(tClass);
        enhancer.setCallback(lazyLoader);
        return (T) enhancer.create(new Class[]{String.class},new Object[]{"anyString"});
    }
}
