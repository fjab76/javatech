package fjab.javatech.dynamicproxy.mock.case2;

/**
 * Created by fjab on 16/01/15.
 */
public class ClientService {

    private DAOClient daoClient;

    public boolean createClient(Client client){

        System.out.println("running logic to create a client");

        if(daoClient.findByName(client.getName())==null){
            daoClient.insertClient(client);

            System.out.println("running remaining logic");
            return true;
        }
        else{
            System.out.println("WARNING: client already exists!!");
            return false;
        }
    }

    public void setDaoClient(DAOClient daoClient) {
        this.daoClient = daoClient;
    }
}
