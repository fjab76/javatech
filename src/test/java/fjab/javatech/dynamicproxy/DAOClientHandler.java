package fjab.javatech.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by fjab on 16/01/15.
 */
class DAOClientHandler implements InvocationHandler{


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if(proxy instanceof DAOClient) {
            if ("insertClient".equals(method.getName())) {
                Client client = (Client) args[0];
                if ("ok".equals(client.getName())) {
                    return true;
                } else if ("ko".equals(client.getName())) {
                    return false;
                }
            }
        }
        return null;
    }
}
