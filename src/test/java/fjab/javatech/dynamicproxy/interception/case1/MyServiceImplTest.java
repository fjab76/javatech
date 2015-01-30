package fjab.javatech.dynamicproxy.interception.case1;

import fjab.javatech.dynamicproxy.interception.case1.MyService;
import fjab.javatech.dynamicproxy.interception.case1.MyServiceFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MyServiceImplTest {

    private MyService myService;

    @Before
    public void setUp() throws Exception {
        myService = MyServiceFactory.getInstance();

    }

    @Test
    public void testMethod1() throws Exception {

        myService.method1();
        Assert.assertNotNull(MyServiceFactory.getTime().get("method1"));

    }

    @Test
    public void testMethod2() throws Exception {

        Assert.assertEquals("hello",myService.method2());
        Assert.assertNotNull(MyServiceFactory.getTime().get("method2"));

    }

    @Test
    /**
     * Object.toString() is dispatched to invocation handler
     */
    public void testToString(){

        System.out.println(myService.toString());
        Assert.assertNotNull(MyServiceFactory.getTime().get("toString"));
    }

    /**
     * Object.getClass() is not dispatched to invocation handler (since only hashCode, equals and toString are
     * dispatched)
     */
    @Test
    public void testGetClass(){

        System.out.println(myService.getClass());
        Assert.assertNull(MyServiceFactory.getTime().get("getClass"));
    }
}