package fjab.javatech.dynamicproxy;

/**
 * Created by fjab on 16/01/15.
 */
public class Client {

    private String name;
    private String lastName;


    public Client(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }
}
