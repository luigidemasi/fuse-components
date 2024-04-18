/**
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 *
 */
package com.redhat.camel.component.cics;

public interface CICSConstants {

    int    CICS_DEFAULT_SERVER_PORT       = 2006;
    String CICS_DEFAULT_ENCODING          = "Cp1145";
    int    CICS_DEFAULT_SOCKET_TIMEOUT    = 0;
    short CICS_DEFAULT_ECI_TIMEOUT        = 0;
    String CICS_RETURN_CODE_HEADER        = "CICS_RETURN_CODE";
    String CICS_RETURN_CODE_STRING_HEADER = "CICS_RETURN_CODE_STRING";
    String CICS_REQUEST_BODY_TYPE_HEADER = "CICS_REQUEST_BODY_TYPE";
    String CICS_REQUEST_BODY_TYPE_STRING = "CICS_REQUEST_BODY_STRING";
    String CICS_REQUEST_BODY_TYPE_BYTE = "CICS_REQUEST_BODY_BYTE";
    String CICS_EXTEND_MODE_HEADER = "CICS_EXTEND_MODE";
    String CICS_LUW_TOKEN_HEADER = "CICS_LUW_TOKEN";
    String CICS_PROGRAM_NAME_HEADER = "CICS_PROGRAM_NAME";
    String CICS_TRANSACTION_ID_HEADER = "CICS_TRANSACTION_ID";
    String CICS_COMM_AREA_SIZE_HEADER = "CICS_COMM_AREA_SIZE";
    String CICS_CHANNEL_NAME_HEADER = "CICS_CHANNEL_NAME";
    String CICS_CONTAINER_NAME_HEADER = "CICS_CONTAINER_NAME";
    String CICS_CHANNEL_CCSID_HEADER = "CICS_CHANNEL_CCSID";
    String CICS_SERVER_HEADER = "CICS_SERVER";

    String CICS_USER_ID_HEADER = "CICS_USER_ID";

    String CICS_PASSWORD_HEADER = "CICS_PASSWORD";



    /** TCP Protocol */
    String GW_PROTOCOL_TCP = "tcp";
    String CICS_RC_HEADER        = "CICS_RC";
    String CICS_RC_STRING_HEADER = "CICS_RC_STRING";
    String CICS_ABEND_CODE_HEADER = "CICS_ABEND_CODE";

    // INTERFACES
    String CICS_ECI_INTERFACE_TYPE = "eci";
    String CICS_DEFAULT_INTERFACE_TYPE = CICS_ECI_INTERFACE_TYPE;


}
