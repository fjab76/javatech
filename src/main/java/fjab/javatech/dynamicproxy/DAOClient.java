package fjab.javatech.dynamicproxy;

/**
 * Created by fjab on 16/01/15.
 */
interface DAOClient {

    Boolean insertClient(Client client);
    Boolean deleteClient(Client client);
    Client findByName(String name);
}
