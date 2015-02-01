package fjab.javatech.dynamicproxy.mock.case2;

import net.sf.cglib.proxy.*;
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
        FixedValue callback = () -> {return null;};
        DAOClient daoClient = MockGenerator.createMock(DAOClient.class, callback);
        clientService.setDaoClient(daoClient);

        //when
        boolean clientCreated = clientService.createClient(new Client());

        //then
        assertTrue(clientCreated);

    }

    @Test
    public void clientIsNotCreated() throws Exception {

        //given
        Class<DAOClient> tClass = DAOClient.class;
        CallbackHelper callbackHelper = new CallbackHelper(tClass, null) {
            @Override
            protected Object getCallback(Method method) {
                if ("findByName".equals(method.getName())) {
                    FixedValue callback = () -> {return new Client();};
                    return callback;
                }
                //any other method returns null
                else {
                    FixedValue callback = () -> {return null;};
                    return callback;
                }
            }
        };
        DAOClient daoClient = MockGenerator.createMock(tClass, callbackHelper);
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
        MethodInterceptor methodInterceptor = (Object o, Method method, Object[] args, MethodProxy methodProxy) -> {
            if ("insertClient".equals(method.getName())) {
                counter.increment();
            }

            return null;
        };
        DAOClient daoClient = MockGenerator.createMock(DAOClient.class, methodInterceptor);
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