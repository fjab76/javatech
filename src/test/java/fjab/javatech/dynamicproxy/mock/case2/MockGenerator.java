package fjab.javatech.dynamicproxy.mock.case2;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.CallbackFilter;
import net.sf.cglib.proxy.CallbackHelper;
import net.sf.cglib.proxy.Enhancer;

/**
 * Created by fjab on 01/02/15.
 */
public class MockGenerator {

    static <T> T createMock(Class<T> tClass,CallbackHelper callbackHelper){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(tClass);
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        return (T) enhancer.create();
    }

    static <T> T createMock(Class<T> tClass,Callback callback){

        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(tClass);
        enhancer.setCallback(callback);
        return (T) enhancer.create();
    }
}
