package com.redhat.camel.component.cics;

import com.ibm.ctg.client.ECIRequest;
import org.apache.camel.Exchange;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.spi.Registry;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;

import static com.redhat.camel.component.cics.CICSConstants.CICS_COMM_AREA_SIZE_HEADER;
import static com.redhat.camel.component.cics.CICSConstants.CICS_PROGRAM_NAME_HEADER;
import static org.apache.camel.ExchangePattern.InOut;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomBindingTest extends AbstractCICSTest{

    private String expectedHeaderName = "MyCustomHeader";
    private String expectedHeaderValue = "MycustomHeaderValue";

    public static final Logger LOG = LoggerFactory.getLogger(NoConnectionFactoryTest.class);

    @Override
    protected void bindToRegistry(Registry registry) throws Exception {
        CustomEciBinding ceb = new CustomEciBinding();
        registry.bind("customBinding", ceb);
    }

    @Test
    public void shouldContainsCustomHeaders() {
        assertTrue(ctgContainer.isRunning());
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMinimumMessageCount(1);

        Exchange returned = template.send("direct:test", InOut, ex->{
            ex.getMessage().setHeader(CICS_PROGRAM_NAME_HEADER, "ECIREADY");
            ex.getMessage().setHeader(CICS_COMM_AREA_SIZE_HEADER, "18");
        });

        assertEquals(expectedHeaderValue, returned.getMessage().getHeader(expectedHeaderName,String.class));
    }


    @Override
    protected String getOptions() {
        int  CTG_PORT = ctgContainer.getMappedPort(2006);
        String CTG_HOST =  ctgContainer.getHost();
        return "?host="+CTG_HOST+"&port="+CTG_PORT+"&protocol=tcp&eciBinding=#customBinding";
    }

    class CustomEciBinding extends CICSDefaultEciBinding{
        public void toExchange(ECIRequest request, Exchange exchange, int iRc, CICSConfiguration configuration) throws UnsupportedEncodingException {
            super.toExchange(request, exchange, iRc, configuration);
            exchange.getMessage().setHeader(expectedHeaderName, expectedHeaderValue);
        }
    }
}
