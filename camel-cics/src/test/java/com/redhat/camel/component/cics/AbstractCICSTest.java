package com.redhat.camel.component.cics;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.MountableFile;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.redhat.camel.component.cics.CICSConstants.CICS_COMM_AREA_SIZE_HEADER;
import static com.redhat.camel.component.cics.CICSConstants.CICS_DEFAULT_ENCODING;
import static com.redhat.camel.component.cics.CICSConstants.CICS_PROGRAM_NAME_HEADER;
import static com.redhat.camel.component.cics.CICSConstants.CICS_RC_HEADER;
import static org.apache.camel.ExchangePattern.InOut;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractCICSTest extends CamelTestSupport {

    public static final Logger LOG = LoggerFactory.getLogger(AbstractCICSTest.class);

    protected final static Network network = Network.newNetwork();
    /** CTG Server */
    protected static final String CTG_SERVER = "cics_server_name";

    protected static final GenericContainer<?> ctgContainer = new GenericContainer<>("images.paas.redhat.com/fuseqe/ibm-cicstg-container-linux-x86-trial:9.3")
            .withEnv("LICENSE","accept")
            .withNetwork(network)
            .withNetworkAliases("cgt")
            .withExposedPorts(2006, 2810)
            .withCopyFileToContainer(MountableFile.forClasspathResource("ctg.ini"), "/var/cicscli/ctg.ini")
            .waitingFor(Wait.forLogMessage(".*CTG6512I CICS Transaction Gateway initialization complete.*",1))
            .withStartupTimeout(Duration.ofSeconds(60L));


    protected void doPreSetup() throws Exception {
        ctgContainer.start();
    }


    @Test
    public void testECIREADY() throws Exception {
        assertTrue(ctgContainer.isRunning());
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMinimumMessageCount(1);
        Map headers = new HashMap<>();
        headers.put(CICS_PROGRAM_NAME_HEADER, "ECIREADY");
        headers.put(CICS_COMM_AREA_SIZE_HEADER, "18");
        Object returned = template.sendBodyAndHeaders("direct:test", InOut, null, headers);
        mock.setExpectedMessageCount(1);
        Exchange ex = mock.getExchanges().get(0);
        Assertions.assertEquals(0, ex.getIn().getHeader(CICS_RC_HEADER));
    }

    @Test
    public void testECIB2() throws Exception {
        assertTrue(ctgContainer.isRunning());
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMinimumMessageCount(1);
        Map headers = new HashMap<>();
        headers.put(CICS_PROGRAM_NAME_HEADER, "ECIREADY");
        headers.put(CICS_COMM_AREA_SIZE_HEADER, "18");
        Object s = template.sendBodyAndHeaders("direct:test", InOut,null, headers);
        mock.setExpectedMessageCount(1);
        Exchange ex = mock.getExchanges().get(0);
        LOG.info("response: {}", new String((byte[]) ex.getIn().getBody(),CICS_DEFAULT_ENCODING));
        Assertions.assertEquals(0, ex.getIn().getHeader(CICS_RC_HEADER));
    }

    @Override
    protected RouteBuilder createRouteBuilder() throws Exception {
        int  CTG_PORT = ctgContainer.getMappedPort(2006);
        String CTG_HOST =  ctgContainer.getHost();

        return new RouteBuilder() {
            public void configure() {
                from("direct:test")
                        .log("CTG Endpoing: cics://eci"+getOptions())
                        .log("Calling ${headers.programName} Program")
                        .to("cics:eci"+getOptions())
                        .log("Called ${headers.programName} Program")
                        .to("mock:result");
            }
        };
    }


    protected abstract String getOptions();

}
