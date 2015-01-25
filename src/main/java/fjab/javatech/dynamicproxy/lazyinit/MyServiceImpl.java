package fjab.javatech.dynamicproxy.lazyinit;

/**
 * Created by fjab on 25/01/15.
 */
class MyServiceImpl implements MyService{

    MyServiceImpl(){
        System.out.println("Constructing MyService object...");
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Object created!!");
    }

    @Override
    public String method1() {
        return "method1";
    }
}
