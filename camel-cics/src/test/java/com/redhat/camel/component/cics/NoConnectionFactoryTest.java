package com.redhat.camel.component.cics;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NoConnectionFactoryTest extends AbstractCICSTest {
    public static final Logger LOG = LoggerFactory.getLogger(NoConnectionFactoryTest.class);

    @Override
    protected String getOptions() {
        int  CTG_PORT = ctgContainer.getMappedPort(2006);
        String CTG_HOST =  ctgContainer.getHost();
        return "?host="+CTG_HOST+"&port="+CTG_PORT+"&protocol=tcp";
    }
}
