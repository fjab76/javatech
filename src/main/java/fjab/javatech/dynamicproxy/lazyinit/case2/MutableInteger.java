package fjab.javatech.dynamicproxy.lazyinit.case2;

/**
 * Created by fjab on 31/01/15.
 */
public class MutableInteger {

    private int var = 0;

    public int getVar() {
        return var;
    }

    public void setVar(int var) {
        this.var = var;
    }

    public void add(int i) {
        System.out.println("adding 1");
        this.var += i;
    }

    private static MutableInteger ourInstance = new MutableInteger();

    public static MutableInteger getInstance() {
        return ourInstance;
    }

    private MutableInteger() {
    }
}
