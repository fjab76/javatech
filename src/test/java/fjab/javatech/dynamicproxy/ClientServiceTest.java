package fjab.javatech.dynamicproxy;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

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
        DAOClient daoClient = MockGenerator.createMock(DAOClient.class, (Object proxy, Method method, Object[] args) -> {
            return null;
        });
        clientService.setDaoClient(daoClient);

        //when
        boolean clientCreated = clientService.createClient(new Client());

        //then
        assertTrue(clientCreated);

    }

    @Test
    public void clientIsNotCreated() throws Exception {

        //given
        DAOClient daoClient = MockGenerator.createMock(DAOClient.class, (Object proxy, Method method, Object[] args) -> {

            if ("findByName".equals(method.getName())) {
                return new Client();
            }
            //any other method returns null
            else {
                return null;
            }

        });
        clientService.setDaoClient(daoClient);

        //when
        boolean clientCreated = clientService.createClient(new Client());

        //then
        assertFalse(clientCreated);

    }

    @Test
    public void insertClientIsCalledOnce() throws Exception {

        //given
        MutableInteger counter = new MutableInteger();
        DAOClient daoClient = MockGenerator.createMock(DAOClient.class, (Object proxy, Method method, Object[] args) -> {

            if ("insertClient".equals(method.getName())) {
                counter.increment();
            }

            return null;
        });
        clientService.setDaoClient(daoClient);

        //when
        boolean clientCreated = clientService.createClient(new Client());

        //then
        assertEquals(1,counter.getValue());

    }

    private class MutableInteger{

        private int value;

        int getValue() {
            return value;
        }

        void setValue(int value) {
            this.value = value;
        }

        void increment(){
            this.value += 1;
        }

    }
}