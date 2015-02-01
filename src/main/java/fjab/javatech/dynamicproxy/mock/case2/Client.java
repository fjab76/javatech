package fjab.javatech.dynamicproxy.mock.case2;

/**
 * Created by fjab on 16/01/15.
 */
public class Client {

    private String name;
    private String lastName;

    public Client(){
        super();
    }

    public Client(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }
}
