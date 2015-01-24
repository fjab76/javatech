package fjab.javatech.dynamicproxy.interception;

/**
 * Created by fjab on 24/01/15.
 */
class MyServiceImpl implements MyService {

    public void method1(){
        System.out.println("running method1");
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String method2(){
        System.out.println("running method2");
        try {
            Thread.currentThread().sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }
}
