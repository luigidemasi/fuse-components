package com.redhat.camel.component.cics;

import com.ibm.ctg.client.ECIRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.Optional;

import static com.redhat.camel.component.cics.CICSConstants.CICS_ABEND_CODE_HEADER;
import static com.redhat.camel.component.cics.CICSConstants.CICS_COMM_AREA_SIZE_HEADER;
import static com.redhat.camel.component.cics.CICSConstants.CICS_PROGRAM_NAME_HEADER;
import static com.redhat.camel.component.cics.CICSConstants.CICS_REQUEST_BODY_TYPE_HEADER;
import static com.redhat.camel.component.cics.CICSConstants.CICS_REQUEST_BODY_TYPE_STRING;
import static com.redhat.camel.component.cics.CICSConstants.CICS_RETURN_CODE_STRING_HEADER;
import static com.redhat.camel.component.cics.CICSConstants.CICS_TRANSACTION_ID_HEADER;

public class CICSDefaultEciBinding implements CICSEciBinding{
    private static final Logger LOGGER = LoggerFactory.getLogger(CICSDefaultEciBinding.class);


    private byte[] getBytes(String source, String encoding) throws java.io.UnsupportedEncodingException {
        if (null != encoding) {
            return source.getBytes(encoding);
        }
        return source.getBytes();
    }

    public ECIRequest toECIRequest(Exchange exchange, CICSConfiguration configuration) throws UnsupportedEncodingException {
        Message inMessage = exchange.getMessage();
        // Program Headers: programName, transactionID and commAreaSize
        String programName = inMessage.getHeader(CICS_PROGRAM_NAME_HEADER, String.class);
        String transactionId = inMessage.getHeader(CICS_TRANSACTION_ID_HEADER, String.class);
        Integer commAreaSize = Optional.ofNullable(inMessage.getHeader(CICS_COMM_AREA_SIZE_HEADER, Integer.class)).orElse(-1);

        // Input CommArea Data from Exchange
        Object commArea = inMessage.getBody();
        byte[] byteCommArea;


        if (commArea instanceof String) {
            exchange.getMessage().setHeader(CICS_REQUEST_BODY_TYPE_HEADER, CICS_REQUEST_BODY_TYPE_STRING);
            byteCommArea = stringToBytesCommArea((String) commArea, commAreaSize, configuration);
        } else if (commArea instanceof byte[]) {
            byteCommArea = (byte[]) commArea;
        } else {
            if (commAreaSize > 0) {
                byteCommArea = new byte[commAreaSize];
            } else {
                byteCommArea = new byte[0];
            }
            LOGGER.warn("Run Transaction with data format not available. Defining Default CommArea with size: {}", byteCommArea.length);
        }

        return new ECIRequest(configuration.getServer(), // CICS Server
                configuration.getUserId(), // UserId, null for none
                configuration.getPassword(), // Password, null for none
                programName, // Program name
                byteCommArea, // COMMAREA
                ECIRequest.ECI_NO_EXTEND, ECIRequest.ECI_LUW_NEW);
    }


    public void toExchange(ECIRequest request, Exchange exchange, int iRc, CICSConfiguration configuration) throws UnsupportedEncodingException {
        Message message = exchange.getMessage();
        message.setHeader(CICSConstants.CICS_RETURN_CODE_HEADER, request.getCicsRc());
        message.setHeader(CICSConstants.CICS_RETURN_CODE_STRING_HEADER, request.getCicsRcString());
        message.setHeader(CICSConstants.CICS_RC_HEADER, request.getRc());
        message.setHeader(CICSConstants.CICS_RC_STRING_HEADER, request.getRcString());
        message.setHeader(CICSConstants.CICS_LUW_TOKEN_HEADER, request.Luw_Token);
        message.setHeader(CICSConstants.CICS_EXTEND_MODE_HEADER, request.Extend_Mode);


        if (iRc == 0) {
            LOGGER.debug("Flow executed successfully");
            if(request.Commarea != null &&
                    CICS_RETURN_CODE_STRING_HEADER.equals(message.getHeader(CICS_REQUEST_BODY_TYPE_HEADER))){
                message.setBody(new String(request.Commarea , configuration.getEncoding()));
                return;
            }
            message.setBody(request.Commarea);
            return;
        }

        if (request.getCicsRc() == 0) {
            LOGGER.debug("Gateway Flow Exception. Return code number:" + iRc + " Return code String: " + request.getRcString());
        } else {
            message.setHeader(CICS_ABEND_CODE_HEADER, request.Abend_Code);
            if (request.getCicsRc() == ECIRequest.ECI_ERR_SECURITY_ERROR || (request.Abend_Code != null && request.Abend_Code.equalsIgnoreCase("AEY7"))) {
                LOGGER.debug("Security Flow Exception. Server is unable to validate user ID or password");
            } else if (request.getCicsRc() == ECIRequest.ECI_ERR_TRANSACTION_ABEND) {
                LOGGER.debug("Program Flow Exception. An error was returned from the server. Refer to the abend code for further details. '{}'", request.Abend_Code);
            } else {
                LOGGER.info("Unknown Flow Exception. Return code number: {}. Return code String: {}", iRc, request.getCicsRcString());
            }
        }

        //LOG.debug("Flow Result Code '{}' on Gateway {}", iRc);
        LOGGER.debug("CicsCodes: {}-{}", request.getCicsRc(), request.getCicsRcString());
        LOGGER.debug("RcCodes: {}-{}", request.getRc(), request.getRcString());
    }


    private byte[] stringToBytesCommArea(String inputCommArea, int commAreaSize, CICSConfiguration configuration) throws UnsupportedEncodingException {
        byte[] byteCommArea;
        if (commAreaSize > 0) {
            byteCommArea = new byte[commAreaSize];
            if (inputCommArea != null) {
                // Calls local getBytes function to extract byte array in either ASCII or unconverted form.
                System.arraycopy(getBytes(inputCommArea, configuration.getEncoding()), 0, byteCommArea, 0,
                        Math.min(byteCommArea.length, inputCommArea.length()));
            }
        } else if (inputCommArea != null) {
            // Calls local getBytes function to extract byte array in either ASCII or unconverted form.
            byteCommArea = getBytes(inputCommArea, configuration.getEncoding());
        } else {
            byteCommArea = new byte[commAreaSize];
        }
        LOGGER.info("Input CommArea String Data:\n-** INPUT COMMAREA **-\n{}\n-** END INPUT COMMAREA **-", inputCommArea);
        return byteCommArea;
    }
}


