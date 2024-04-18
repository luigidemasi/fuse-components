package com.redhat.camel.component.cics;

import com.ibm.ctg.client.Container;
import com.ibm.ctg.client.ECIRequest;
import com.redhat.camel.component.cics.binding.CICSChannelEciBinding;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.ibm.ctg.client.Container.ContainerType.*;
import static com.redhat.camel.component.cics.CICSConstants.CICS_CHANNEL_NAME_HEADER;
import static com.redhat.camel.component.cics.CICSConstants.CICS_CONTAINER_NAME_HEADER;
import static com.redhat.camel.component.cics.CICSConstants.CICS_PASSWORD_HEADER;
import static com.redhat.camel.component.cics.CICSConstants.CICS_PROGRAM_NAME_HEADER;
import static com.redhat.camel.component.cics.CICSConstants.CICS_SERVER_HEADER;
import static com.redhat.camel.component.cics.CICSConstants.CICS_TRANSACTION_ID_HEADER;
import static com.redhat.camel.component.cics.CICSConstants.CICS_USER_ID_HEADER;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CICSChannelEciBindingTest extends CamelTestSupport {

    CICSConfiguration configuration = new CICSConfiguration();

    CICSChannelEciBinding  binding = new CICSChannelEciBinding();

    @Override
    public void doPostSetup(){
        configuration.setServer("CEDEXA1I");
        configuration.setUserId("user01");
        configuration.setPassword("foobar01");
    }

    @Test
    public void singleInputContainerTest() throws Exception {


        String expectedChannelName = "mychannel";
        String expectedContainerName = "myContainer";
        String expectedUserId = "user12";
        String expectedPassword = "fooBar12";
        String expectedTransactionId = "1";
        String expectedContainerValue = "My Container Content";
        String expectedServerName = "milkyWay90";

        Exchange exchange = new DefaultExchange(context);
        Message message = exchange.getMessage();
        message.setHeader(CICS_PROGRAM_NAME_HEADER, "ECIREADY");
        message.setHeader(CICS_TRANSACTION_ID_HEADER, expectedTransactionId);
        message.setHeader(CICS_CHANNEL_NAME_HEADER, expectedChannelName);
        message.setHeader(CICS_CONTAINER_NAME_HEADER, expectedContainerName);
        message.setHeader(CICS_USER_ID_HEADER, expectedUserId);
        message.setHeader(CICS_PASSWORD_HEADER, expectedPassword);
        message.setHeader(CICS_SERVER_HEADER, expectedServerName);
        message.setBody(expectedContainerValue);

        ECIRequest request = binding.toECIRequest(exchange, configuration);
        Container container = request.channel.getContainers().stream().toList().get(0);

        assertEquals(expectedChannelName, request.channel.getName() );
        assertEquals(1, request.channel.getContainers().size());
        assertEquals(expectedContainerName, container.getName());
        assertEquals(expectedTransactionId, request.Transid);
        assertEquals(expectedUserId, request.Userid);
        assertEquals(expectedPassword, request.Password);
        assertEquals(CHAR, container.getType());
        assertEquals(expectedContainerValue, container.getCHARData());
        assertEquals(expectedServerName, request.Server);
    }

    @Test
    public void multipleInputContainersTest() throws Exception {
        String expectedChannelName = "mychannel";

        Map<String, Object> containers = new HashMap<>();
        containers.put("FirstChar", "My First Container");
        containers.put("SecondByteArray", "My Second Container".getBytes());

        Exchange exchange = new DefaultExchange(context);
        Message message = exchange.getMessage();
        message.setHeader(CICS_CHANNEL_NAME_HEADER, expectedChannelName);
        message.setBody(containers);

        ECIRequest request = binding.toECIRequest(exchange, configuration);
        List<Container> actualContainers = request.channel.getContainers().stream().toList();
        Container first = actualContainers.get(0);
        Container second = actualContainers.get(1);

        assertEquals(configuration.getServer(), request.Server);
        assertEquals(2, request.channel.getContainers().size());
        assertEquals(expectedChannelName, request.channel.getName() );

        assertEquals("FirstChar", first.getName());
        assertEquals(CHAR, first.getType());
        assertEquals("My First Container", first.getCHARData());

        assertEquals("SecondByteArray", second.getName());
        assertEquals(BIT, second.getType());
        assertEquals("My Second Container", new String(second.getBITData()));

        assertEquals(configuration.getUserId(), request.Userid);
        assertEquals(configuration.getPassword(), request.Password);

    }


}
