package fjab.javatech.dynamicproxy.interception;

import org.junit.Assert;
import org.junit.After;
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
        Assert.assertEquals(Long.valueOf(1),(Long)MyServiceFactory.getTime().get("method1"));

    }

    @Test
    public void testMethod2() throws Exception {

        Assert.assertEquals("hello",myService.method2());
        Assert.assertEquals(Long.valueOf(2),(Long)MyServiceFactory.getTime().get("method2"));

    }
}