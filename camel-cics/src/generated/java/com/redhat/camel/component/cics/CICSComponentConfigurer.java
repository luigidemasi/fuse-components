/* Generated by camel build tools - do NOT edit this file! */
package com.redhat.camel.component.cics;

import javax.annotation.processing.Generated;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.ExtendedPropertyConfigurerGetter;
import org.apache.camel.spi.PropertyConfigurerGetter;
import org.apache.camel.spi.ConfigurerStrategy;
import org.apache.camel.spi.GeneratedPropertyConfigurer;
import org.apache.camel.util.CaseInsensitiveMap;
import org.apache.camel.support.component.PropertyConfigurerSupport;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointSchemaGeneratorMojo")
@SuppressWarnings("unchecked")
public class CICSComponentConfigurer extends PropertyConfigurerSupport implements GeneratedPropertyConfigurer, PropertyConfigurerGetter {

    private com.redhat.camel.component.cics.CICSConfiguration getOrCreateConfiguration(CICSComponent target) {
        if (target.getConfiguration() == null) {
            target.setConfiguration(new com.redhat.camel.component.cics.CICSConfiguration());
        }
        return target.getConfiguration();
    }

    @Override
    public boolean configure(CamelContext camelContext, Object obj, String name, Object value, boolean ignoreCase) {
        CICSComponent target = (CICSComponent) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "autowiredenabled":
        case "autowiredEnabled": target.setAutowiredEnabled(property(camelContext, boolean.class, value)); return true;
        case "configuration": target.setConfiguration(property(camelContext, com.redhat.camel.component.cics.CICSConfiguration.class, value)); return true;
        case "ctgdebug":
        case "ctgDebug": getOrCreateConfiguration(target).setCtgDebug(property(camelContext, java.lang.Boolean.class, value)); return true;
        case "ecibinding":
        case "eciBinding": getOrCreateConfiguration(target).setEciBinding(property(camelContext, com.redhat.camel.component.cics.CICSEciBinding.class, value)); return true;
        case "ecitimeout":
        case "eciTimeout": getOrCreateConfiguration(target).setEciTimeout(property(camelContext, short.class, value)); return true;
        case "encoding": getOrCreateConfiguration(target).setEncoding(property(camelContext, java.lang.String.class, value)); return true;
        case "gatewayfactory":
        case "gatewayFactory": getOrCreateConfiguration(target).setGatewayFactory(property(camelContext, com.redhat.camel.component.cics.pool.CICSGatewayFactory.class, value)); return true;
        case "host": getOrCreateConfiguration(target).setHost(property(camelContext, java.lang.String.class, value)); return true;
        case "initialflow":
        case "initialFlow": getOrCreateConfiguration(target).setInitialFlow(property(camelContext, java.lang.Boolean.class, value)); return true;
        case "lazystartproducer":
        case "lazyStartProducer": target.setLazyStartProducer(property(camelContext, boolean.class, value)); return true;
        case "password": getOrCreateConfiguration(target).setPassword(property(camelContext, java.lang.String.class, value)); return true;
        case "port": getOrCreateConfiguration(target).setPort(property(camelContext, int.class, value)); return true;
        case "protocol": getOrCreateConfiguration(target).setProtocol(property(camelContext, java.lang.String.class, value)); return true;
        case "server": getOrCreateConfiguration(target).setServer(property(camelContext, java.lang.String.class, value)); return true;
        case "socketconnectiontimeout":
        case "socketConnectionTimeout": getOrCreateConfiguration(target).setSocketConnectionTimeout(property(camelContext, int.class, value)); return true;
        case "sslkeyring":
        case "sslKeyring": getOrCreateConfiguration(target).setSslKeyring(property(camelContext, java.lang.String.class, value)); return true;
        case "sslpassword":
        case "sslPassword": getOrCreateConfiguration(target).setSslPassword(property(camelContext, java.lang.String.class, value)); return true;
        case "userid":
        case "userId": getOrCreateConfiguration(target).setUserId(property(camelContext, java.lang.String.class, value)); return true;
        default: return false;
        }
    }

    @Override
    public String[] getAutowiredNames() {
        return new String[]{"configuration", "gatewayFactory"};
    }

    @Override
    public Class<?> getOptionType(String name, boolean ignoreCase) {
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "autowiredenabled":
        case "autowiredEnabled": return boolean.class;
        case "configuration": return com.redhat.camel.component.cics.CICSConfiguration.class;
        case "ctgdebug":
        case "ctgDebug": return java.lang.Boolean.class;
        case "ecibinding":
        case "eciBinding": return com.redhat.camel.component.cics.CICSEciBinding.class;
        case "ecitimeout":
        case "eciTimeout": return short.class;
        case "encoding": return java.lang.String.class;
        case "gatewayfactory":
        case "gatewayFactory": return com.redhat.camel.component.cics.pool.CICSGatewayFactory.class;
        case "host": return java.lang.String.class;
        case "initialflow":
        case "initialFlow": return java.lang.Boolean.class;
        case "lazystartproducer":
        case "lazyStartProducer": return boolean.class;
        case "password": return java.lang.String.class;
        case "port": return int.class;
        case "protocol": return java.lang.String.class;
        case "server": return java.lang.String.class;
        case "socketconnectiontimeout":
        case "socketConnectionTimeout": return int.class;
        case "sslkeyring":
        case "sslKeyring": return java.lang.String.class;
        case "sslpassword":
        case "sslPassword": return java.lang.String.class;
        case "userid":
        case "userId": return java.lang.String.class;
        default: return null;
        }
    }

    @Override
    public Object getOptionValue(Object obj, String name, boolean ignoreCase) {
        CICSComponent target = (CICSComponent) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "autowiredenabled":
        case "autowiredEnabled": return target.isAutowiredEnabled();
        case "configuration": return target.getConfiguration();
        case "ctgdebug":
        case "ctgDebug": return getOrCreateConfiguration(target).getCtgDebug();
        case "ecibinding":
        case "eciBinding": return getOrCreateConfiguration(target).getEciBinding();
        case "ecitimeout":
        case "eciTimeout": return getOrCreateConfiguration(target).getEciTimeout();
        case "encoding": return getOrCreateConfiguration(target).getEncoding();
        case "gatewayfactory":
        case "gatewayFactory": return getOrCreateConfiguration(target).getGatewayFactory();
        case "host": return getOrCreateConfiguration(target).getHost();
        case "initialflow":
        case "initialFlow": return getOrCreateConfiguration(target).getInitialFlow();
        case "lazystartproducer":
        case "lazyStartProducer": return target.isLazyStartProducer();
        case "password": return getOrCreateConfiguration(target).getPassword();
        case "port": return getOrCreateConfiguration(target).getPort();
        case "protocol": return getOrCreateConfiguration(target).getProtocol();
        case "server": return getOrCreateConfiguration(target).getServer();
        case "socketconnectiontimeout":
        case "socketConnectionTimeout": return getOrCreateConfiguration(target).getSocketConnectionTimeout();
        case "sslkeyring":
        case "sslKeyring": return getOrCreateConfiguration(target).getSslKeyring();
        case "sslpassword":
        case "sslPassword": return getOrCreateConfiguration(target).getSslPassword();
        case "userid":
        case "userId": return getOrCreateConfiguration(target).getUserId();
        default: return null;
        }
    }
}

