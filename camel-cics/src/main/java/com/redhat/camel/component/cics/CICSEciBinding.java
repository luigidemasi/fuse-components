package com.redhat.camel.component.cics;

import com.ibm.ctg.client.ECIRequest;
import org.apache.camel.Exchange;

import java.io.UnsupportedEncodingException;

public interface CICSEciBinding {

    ECIRequest toECIRequest(Exchange exchange, CICSConfiguration configuration) throws UnsupportedEncodingException;

    void toExchange(ECIRequest request, Exchange exchange, int iRc, CICSConfiguration configuration) throws UnsupportedEncodingException;




    }
