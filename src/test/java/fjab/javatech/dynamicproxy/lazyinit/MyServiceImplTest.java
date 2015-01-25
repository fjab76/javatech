package fjab.javatech.dynamicproxy.lazyinit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Proxy;

import static org.junit.Assert.*;

public class MyServiceImplTest {

    private MyService myService;

    @Before
    public void setUp() throws Exception {
        myService = MyServiceFactory.getInstance();

    }

    @Test
    public void testMethod1() throws Exception {

        MyService realObject = ((MyServiceFactory.MyServiceHandler)Proxy.getInvocationHandler(myService)).getMyService();
        Assert.assertNull(realObject);

        Assert.assertEquals("method1", myService.method1());

        realObject = ((MyServiceFactory.MyServiceHandler)Proxy.getInvocationHandler(myService)).getMyService();
        Assert.assertNotNull(realObject);

    }
}