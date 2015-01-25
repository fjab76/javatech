package fjab.javatech.dynamicproxy.interception.case2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyServiceClassTest {

    private MyServiceClass myService;

    @Before
    public void setUp() throws Exception {
        myService = MyServiceFactory.getInstance();

    }

    @Test
    public void testMethod1() throws Exception {

        myService.method1();
        Assert.assertEquals(Long.valueOf(1), (Long) MyServiceFactory.getTime().get("method1"));

    }

    @Test
    public void testMethod2() throws Exception {

        Assert.assertEquals("hello",myService.method2());
        Assert.assertEquals(Long.valueOf(2),(Long) MyServiceFactory.getTime().get("method2"));

    }

    @Test
    /**
     * Object.toString() is dispatched to invocation handler
     */
    public void testToString(){

        System.out.println("myService.toString():"+myService.toString());
        Assert.assertNotNull(MyServiceFactory.getTime().get("toString"));
    }

    /**
     * Object.getClass() is not dispatched to invocation handler since it is final
     */
    @Test
    public void testGetClass(){

        System.out.println("myService.getClass():"+myService.getClass());
        Assert.assertNull(MyServiceFactory.getTime().get("getClass"));
    }
}