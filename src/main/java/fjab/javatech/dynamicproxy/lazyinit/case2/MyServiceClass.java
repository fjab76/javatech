package fjab.javatech.dynamicproxy.lazyinit.case2;

/**
 * Created by fjab on 30/01/15.
 */
class MyServiceClass {

    /**
     * Costly constructor to be called on the callback
     */
    MyServiceClass(){

        //Complex logic to create the object
        System.out.println("creating object");
        MutableInteger objectCreated = MutableInteger.getInstance();
        objectCreated.add(1);
    }

    /**
     * Cheap constructor to create the proxy when creating the Enhancer
     * @param anyObject
     */
    MyServiceClass(String anyObject){

        //No logic
    }

    public String method1() {
        return "method1";
    }

    public String method2() {
        return "method2";
    }
}
