package fjab.javatech.dynamicproxy;

/**
 * Created by fjab on 16/01/15.
 */
public class ClientService {

    private DAOClient daoClient;

    public boolean createClient(Client client){

        System.out.println("running logic to create a client");

        if(!daoClient.insertClient(client)){
            return false;
        }

        System.out.println("running remaining logic");

        return true;
    }

    public void setDaoClient(DAOClient daoClient) {
        this.daoClient = daoClient;
    }
}
