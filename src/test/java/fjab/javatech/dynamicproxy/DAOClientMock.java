package fjab.javatech.dynamicproxy;

import java.lang.reflect.Proxy;

/**
 * Created by fjab on 17/01/15.
 */
class DAOClientMock {

    static DAOClient createMock(){

        return (DAOClient) Proxy.newProxyInstance(DAOClient.class.getClassLoader(),new Class[] {DAOClient.class}, new DAOClientHandler());
    }
}
