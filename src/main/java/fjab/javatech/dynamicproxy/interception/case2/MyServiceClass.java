package fjab.javatech.dynamicproxy.interception.case2;

/**
 * Created by fjab on 25/01/15.
 */
public class MyServiceClass {

    public void method1(){
        System.out.println("running method1");
    }

    public String method2(){
        System.out.println("running method2");
        return "hello";
    }
}
