package fjab.javatech.dynamicproxy.interception.case1;

/**
 * Created by fjab on 24/01/15.
 */
class MyServiceImpl implements MyService {

    public void method1(){
        System.out.println("running method1");
    }

    public String method2(){
        System.out.println("running method2");
        return "hello";
    }
}
