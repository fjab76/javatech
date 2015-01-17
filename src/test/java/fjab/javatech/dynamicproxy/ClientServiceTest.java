package fjab.javatech.dynamicproxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClientServiceTest {

    private ClientService clientService;

    @Before
    public void setUp() throws Exception {
        clientService = new ClientService();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void clientIsCreated() throws Exception {

        //given
        DAOClient daoClient = DAOClientMock.createMock();
        clientService.setDaoClient(daoClient);

        //when
        boolean clientCreated = clientService.createClient(new Client("ok","bar"));

        //then
        assertTrue(clientCreated);

    }

    @Test
    public void clientIsNotCreated() throws Exception {

        //given
        DAOClient daoClient = DAOClientMock.createMock();
        clientService.setDaoClient(daoClient);

        //when
        boolean clientCreated = clientService.createClient(new Client("ko","bar"));

        //then
        assertFalse(clientCreated);

    }
}