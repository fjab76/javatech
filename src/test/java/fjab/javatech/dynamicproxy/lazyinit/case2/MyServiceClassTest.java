package fjab.javatech.dynamicproxy.lazyinit.case2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by fjab on 30/01/15.
 */
public class MyServiceClassTest {

    private MyServiceClass myService;

    @Before
    public void setUp() throws Exception {
        myService = MyServiceFactory.getInstance();

    }

    @Test
    public void testObjectCreation() throws Exception {

        //The real object is not created. myService is just a proxy created with a dummy constructor
        Assert.assertTrue(MutableInteger.getInstance().getVar()==0);

        //The proxy intercepts calls to the methods of the real object and creates the  real object, created
        //with the real constructor
        Assert.assertEquals("method1",myService.method1());
        Assert.assertTrue(MutableInteger.getInstance().getVar()==1);

        //The second time a method is invoked on the proxy, no new object is created and the previous one is used
        Assert.assertEquals("method2",myService.method2());
        Assert.assertTrue(MutableInteger.getInstance().getVar()==1);
    }
}
