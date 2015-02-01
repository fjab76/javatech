package fjab.javatech.dynamicproxy.mock.case2;

/**
 * Created by fjab on 16/01/15.
 */
class DAOClient {

    Boolean insertClient(Client client){
        //logic to access the database
        return true;
    }

    Boolean deleteClient(Client client){
        //logic to access the database
        return true;
    }

    Client findByName(String name){
        //logic to access the database
        return new Client();
    }
}
