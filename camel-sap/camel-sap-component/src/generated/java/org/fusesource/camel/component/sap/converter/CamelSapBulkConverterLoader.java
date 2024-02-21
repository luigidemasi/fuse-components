/* Generated by camel build tools - do NOT edit this file! */
package org.fusesource.camel.component.sap.converter;

import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.DeferredContextBinding;
import org.apache.camel.Exchange;
import org.apache.camel.Ordered;
import org.apache.camel.TypeConversionException;
import org.apache.camel.TypeConverterLoaderException;
import org.apache.camel.TypeConverter;
import org.apache.camel.spi.TypeConvertible;
import org.apache.camel.spi.BulkTypeConverters;
import org.apache.camel.spi.TypeConverterLoader;
import org.apache.camel.spi.TypeConverterRegistry;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
@SuppressWarnings("unchecked")
@DeferredContextBinding
public final class CamelSapBulkConverterLoader implements TypeConverterLoader, BulkTypeConverters, CamelContextAware {

    private CamelContext camelContext;

    public CamelSapBulkConverterLoader() {
    }

    @Override
    public void setCamelContext(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    @Override
    public CamelContext getCamelContext() {
        return camelContext;
    }

    @Override
    public int size() {
        return 30;
    }

    @Override
    public void load(TypeConverterRegistry registry) throws TypeConverterLoaderException {
        registry.addBulkTypeConverters(this);
        doRegistration(registry);
    }

    @Override
    public <T> T convertTo(Class<?> from, Class<T> to, Exchange exchange, Object value) throws TypeConversionException {
        try {
            Object obj = doConvertTo(from, to, exchange, value);
            if (obj == Void.class) {;
                return null;
            } else {
                return (T) obj;
            }
        } catch (TypeConversionException e) {
            throw e;
        } catch (Exception e) {
            throw new TypeConversionException(value, to, e);
        }
    }

    private Object doConvertTo(Class<?> from, Class<?> to, Exchange exchange, Object value) throws Exception {
        if (to == java.io.InputStream.class) {
            if (value instanceof org.fusesource.camel.component.sap.model.idoc.impl.DocumentImpl) {
                return org.fusesource.camel.component.sap.converter.DocumentConverter.toInputStream((org.fusesource.camel.component.sap.model.idoc.impl.DocumentImpl) value);
            }
            if (value instanceof org.fusesource.camel.component.sap.model.idoc.impl.DocumentListImpl) {
                return org.fusesource.camel.component.sap.converter.DocumentListConverter.toInputStream((org.fusesource.camel.component.sap.model.idoc.impl.DocumentListImpl) value);
            }
            if (value instanceof org.fusesource.camel.component.sap.model.rfc.impl.RequestImpl) {
                return org.fusesource.camel.component.sap.converter.RequestConverter.toInputStream((org.fusesource.camel.component.sap.model.rfc.impl.RequestImpl) value);
            }
            if (value instanceof org.fusesource.camel.component.sap.model.rfc.impl.ResponseImpl) {
                return org.fusesource.camel.component.sap.converter.ResponseConverter.toInputStream((org.fusesource.camel.component.sap.model.rfc.impl.ResponseImpl) value);
            }
            if (value instanceof org.fusesource.camel.component.sap.model.rfc.impl.StructureImpl) {
                return org.fusesource.camel.component.sap.converter.StructureConverter.toInputStream((org.fusesource.camel.component.sap.model.rfc.impl.StructureImpl) value);
            }
        } else if (to == java.io.OutputStream.class) {
            if (value instanceof org.fusesource.camel.component.sap.model.idoc.impl.DocumentImpl) {
                return org.fusesource.camel.component.sap.converter.DocumentConverter.toOutputStream((org.fusesource.camel.component.sap.model.idoc.impl.DocumentImpl) value);
            }
            if (value instanceof org.fusesource.camel.component.sap.model.idoc.impl.DocumentListImpl) {
                return org.fusesource.camel.component.sap.converter.DocumentListConverter.toOutputStream((org.fusesource.camel.component.sap.model.idoc.impl.DocumentListImpl) value);
            }
            if (value instanceof org.fusesource.camel.component.sap.model.rfc.impl.RequestImpl) {
                return org.fusesource.camel.component.sap.converter.RequestConverter.toOutputStream((org.fusesource.camel.component.sap.model.rfc.impl.RequestImpl) value);
            }
            if (value instanceof org.fusesource.camel.component.sap.model.rfc.impl.ResponseImpl) {
                return org.fusesource.camel.component.sap.converter.ResponseConverter.toOutputStream((org.fusesource.camel.component.sap.model.rfc.impl.ResponseImpl) value);
            }
            if (value instanceof org.fusesource.camel.component.sap.model.rfc.impl.StructureImpl) {
                return org.fusesource.camel.component.sap.converter.StructureConverter.toOutputStream((org.fusesource.camel.component.sap.model.rfc.impl.StructureImpl) value);
            }
        } else if (to == java.lang.String.class) {
            if (value instanceof org.fusesource.camel.component.sap.model.idoc.impl.DocumentImpl) {
                return org.fusesource.camel.component.sap.converter.DocumentConverter.toString((org.fusesource.camel.component.sap.model.idoc.impl.DocumentImpl) value);
            }
            if (value instanceof org.fusesource.camel.component.sap.model.idoc.impl.DocumentListImpl) {
                return org.fusesource.camel.component.sap.converter.DocumentListConverter.toString((org.fusesource.camel.component.sap.model.idoc.impl.DocumentListImpl) value);
            }
            if (value instanceof org.fusesource.camel.component.sap.model.rfc.impl.RequestImpl) {
                return org.fusesource.camel.component.sap.converter.RequestConverter.toString((org.fusesource.camel.component.sap.model.rfc.impl.RequestImpl) value);
            }
            if (value instanceof org.fusesource.camel.component.sap.model.rfc.impl.ResponseImpl) {
                return org.fusesource.camel.component.sap.converter.ResponseConverter.toString((org.fusesource.camel.component.sap.model.rfc.impl.ResponseImpl) value);
            }
            if (value instanceof org.fusesource.camel.component.sap.model.rfc.impl.StructureImpl) {
                return org.fusesource.camel.component.sap.converter.StructureConverter.toString((org.fusesource.camel.component.sap.model.rfc.impl.StructureImpl) value);
            }
        } else if (to == org.fusesource.camel.component.sap.model.idoc.Document.class) {
            if (value instanceof byte[]) {
                return org.fusesource.camel.component.sap.converter.DocumentConverter.toDocument((byte[]) value);
            }
            if (value instanceof java.io.InputStream) {
                return org.fusesource.camel.component.sap.converter.DocumentConverter.toDocument((java.io.InputStream) value);
            }
            if (value instanceof java.lang.String) {
                return org.fusesource.camel.component.sap.converter.DocumentConverter.toDocument((java.lang.String) value);
            }
        } else if (to == org.fusesource.camel.component.sap.model.idoc.DocumentList.class) {
            if (value instanceof byte[]) {
                return org.fusesource.camel.component.sap.converter.DocumentListConverter.toDocumentList((byte[]) value);
            }
            if (value instanceof java.io.InputStream) {
                return org.fusesource.camel.component.sap.converter.DocumentListConverter.toDocumentList((java.io.InputStream) value);
            }
            if (value instanceof java.lang.String) {
                return org.fusesource.camel.component.sap.converter.DocumentListConverter.toDocumentList((java.lang.String) value);
            }
        } else if (to == org.fusesource.camel.component.sap.model.rfc.Request.class) {
            if (value instanceof byte[]) {
                return org.fusesource.camel.component.sap.converter.RequestConverter.toRequest((byte[]) value);
            }
            if (value instanceof java.io.InputStream) {
                return org.fusesource.camel.component.sap.converter.RequestConverter.toRequest((java.io.InputStream) value);
            }
            if (value instanceof java.lang.String) {
                return org.fusesource.camel.component.sap.converter.RequestConverter.toRequest((java.lang.String) value);
            }
        } else if (to == org.fusesource.camel.component.sap.model.rfc.Response.class) {
            if (value instanceof byte[]) {
                return org.fusesource.camel.component.sap.converter.ResponseConverter.toResponse((byte[]) value);
            }
            if (value instanceof java.io.InputStream) {
                return org.fusesource.camel.component.sap.converter.ResponseConverter.toResponse((java.io.InputStream) value);
            }
            if (value instanceof java.lang.String) {
                return org.fusesource.camel.component.sap.converter.ResponseConverter.toResponse((java.lang.String) value);
            }
        } else if (to == org.fusesource.camel.component.sap.model.rfc.Structure.class) {
            if (value instanceof byte[]) {
                return org.fusesource.camel.component.sap.converter.StructureConverter.toStructure((byte[]) value);
            }
            if (value instanceof java.io.InputStream) {
                return org.fusesource.camel.component.sap.converter.StructureConverter.toStructure((java.io.InputStream) value);
            }
            if (value instanceof java.lang.String) {
                return org.fusesource.camel.component.sap.converter.StructureConverter.toStructure((java.lang.String) value);
            }
        }
        return null;
    }

    private void doRegistration(TypeConverterRegistry registry) {
        registry.addConverter(new TypeConvertible<>(org.fusesource.camel.component.sap.model.idoc.impl.DocumentImpl.class, java.io.InputStream.class), this);
        registry.addConverter(new TypeConvertible<>(org.fusesource.camel.component.sap.model.idoc.impl.DocumentListImpl.class, java.io.InputStream.class), this);
        registry.addConverter(new TypeConvertible<>(org.fusesource.camel.component.sap.model.rfc.impl.RequestImpl.class, java.io.InputStream.class), this);
        registry.addConverter(new TypeConvertible<>(org.fusesource.camel.component.sap.model.rfc.impl.ResponseImpl.class, java.io.InputStream.class), this);
        registry.addConverter(new TypeConvertible<>(org.fusesource.camel.component.sap.model.rfc.impl.StructureImpl.class, java.io.InputStream.class), this);
        registry.addConverter(new TypeConvertible<>(org.fusesource.camel.component.sap.model.idoc.impl.DocumentImpl.class, java.io.OutputStream.class), this);
        registry.addConverter(new TypeConvertible<>(org.fusesource.camel.component.sap.model.idoc.impl.DocumentListImpl.class, java.io.OutputStream.class), this);
        registry.addConverter(new TypeConvertible<>(org.fusesource.camel.component.sap.model.rfc.impl.RequestImpl.class, java.io.OutputStream.class), this);
        registry.addConverter(new TypeConvertible<>(org.fusesource.camel.component.sap.model.rfc.impl.ResponseImpl.class, java.io.OutputStream.class), this);
        registry.addConverter(new TypeConvertible<>(org.fusesource.camel.component.sap.model.rfc.impl.StructureImpl.class, java.io.OutputStream.class), this);
        registry.addConverter(new TypeConvertible<>(org.fusesource.camel.component.sap.model.idoc.impl.DocumentImpl.class, java.lang.String.class), this);
        registry.addConverter(new TypeConvertible<>(org.fusesource.camel.component.sap.model.idoc.impl.DocumentListImpl.class, java.lang.String.class), this);
        registry.addConverter(new TypeConvertible<>(org.fusesource.camel.component.sap.model.rfc.impl.RequestImpl.class, java.lang.String.class), this);
        registry.addConverter(new TypeConvertible<>(org.fusesource.camel.component.sap.model.rfc.impl.ResponseImpl.class, java.lang.String.class), this);
        registry.addConverter(new TypeConvertible<>(org.fusesource.camel.component.sap.model.rfc.impl.StructureImpl.class, java.lang.String.class), this);
        registry.addConverter(new TypeConvertible<>(byte[].class, org.fusesource.camel.component.sap.model.idoc.Document.class), this);
        registry.addConverter(new TypeConvertible<>(java.io.InputStream.class, org.fusesource.camel.component.sap.model.idoc.Document.class), this);
        registry.addConverter(new TypeConvertible<>(java.lang.String.class, org.fusesource.camel.component.sap.model.idoc.Document.class), this);
        registry.addConverter(new TypeConvertible<>(byte[].class, org.fusesource.camel.component.sap.model.idoc.DocumentList.class), this);
        registry.addConverter(new TypeConvertible<>(java.io.InputStream.class, org.fusesource.camel.component.sap.model.idoc.DocumentList.class), this);
        registry.addConverter(new TypeConvertible<>(java.lang.String.class, org.fusesource.camel.component.sap.model.idoc.DocumentList.class), this);
        registry.addConverter(new TypeConvertible<>(byte[].class, org.fusesource.camel.component.sap.model.rfc.Request.class), this);
        registry.addConverter(new TypeConvertible<>(java.io.InputStream.class, org.fusesource.camel.component.sap.model.rfc.Request.class), this);
        registry.addConverter(new TypeConvertible<>(java.lang.String.class, org.fusesource.camel.component.sap.model.rfc.Request.class), this);
        registry.addConverter(new TypeConvertible<>(byte[].class, org.fusesource.camel.component.sap.model.rfc.Response.class), this);
        registry.addConverter(new TypeConvertible<>(java.io.InputStream.class, org.fusesource.camel.component.sap.model.rfc.Response.class), this);
        registry.addConverter(new TypeConvertible<>(java.lang.String.class, org.fusesource.camel.component.sap.model.rfc.Response.class), this);
        registry.addConverter(new TypeConvertible<>(byte[].class, org.fusesource.camel.component.sap.model.rfc.Structure.class), this);
        registry.addConverter(new TypeConvertible<>(java.io.InputStream.class, org.fusesource.camel.component.sap.model.rfc.Structure.class), this);
        registry.addConverter(new TypeConvertible<>(java.lang.String.class, org.fusesource.camel.component.sap.model.rfc.Structure.class), this);
        
        
    }

    public TypeConverter lookup(Class<?> to, Class<?> from) {
        if (to == java.io.InputStream.class) {
            if (from == org.fusesource.camel.component.sap.model.idoc.impl.DocumentImpl.class) {
                return this;
            }
            if (from == org.fusesource.camel.component.sap.model.idoc.impl.DocumentListImpl.class) {
                return this;
            }
            if (from == org.fusesource.camel.component.sap.model.rfc.impl.RequestImpl.class) {
                return this;
            }
            if (from == org.fusesource.camel.component.sap.model.rfc.impl.ResponseImpl.class) {
                return this;
            }
            if (from == org.fusesource.camel.component.sap.model.rfc.impl.StructureImpl.class) {
                return this;
            }
        } else if (to == java.io.OutputStream.class) {
            if (from == org.fusesource.camel.component.sap.model.idoc.impl.DocumentImpl.class) {
                return this;
            }
            if (from == org.fusesource.camel.component.sap.model.idoc.impl.DocumentListImpl.class) {
                return this;
            }
            if (from == org.fusesource.camel.component.sap.model.rfc.impl.RequestImpl.class) {
                return this;
            }
            if (from == org.fusesource.camel.component.sap.model.rfc.impl.ResponseImpl.class) {
                return this;
            }
            if (from == org.fusesource.camel.component.sap.model.rfc.impl.StructureImpl.class) {
                return this;
            }
        } else if (to == java.lang.String.class) {
            if (from == org.fusesource.camel.component.sap.model.idoc.impl.DocumentImpl.class) {
                return this;
            }
            if (from == org.fusesource.camel.component.sap.model.idoc.impl.DocumentListImpl.class) {
                return this;
            }
            if (from == org.fusesource.camel.component.sap.model.rfc.impl.RequestImpl.class) {
                return this;
            }
            if (from == org.fusesource.camel.component.sap.model.rfc.impl.ResponseImpl.class) {
                return this;
            }
            if (from == org.fusesource.camel.component.sap.model.rfc.impl.StructureImpl.class) {
                return this;
            }
        } else if (to == org.fusesource.camel.component.sap.model.idoc.Document.class) {
            if (from == byte[].class) {
                return this;
            }
            if (from == java.io.InputStream.class) {
                return this;
            }
            if (from == java.lang.String.class) {
                return this;
            }
        } else if (to == org.fusesource.camel.component.sap.model.idoc.DocumentList.class) {
            if (from == byte[].class) {
                return this;
            }
            if (from == java.io.InputStream.class) {
                return this;
            }
            if (from == java.lang.String.class) {
                return this;
            }
        } else if (to == org.fusesource.camel.component.sap.model.rfc.Request.class) {
            if (from == byte[].class) {
                return this;
            }
            if (from == java.io.InputStream.class) {
                return this;
            }
            if (from == java.lang.String.class) {
                return this;
            }
        } else if (to == org.fusesource.camel.component.sap.model.rfc.Response.class) {
            if (from == byte[].class) {
                return this;
            }
            if (from == java.io.InputStream.class) {
                return this;
            }
            if (from == java.lang.String.class) {
                return this;
            }
        } else if (to == org.fusesource.camel.component.sap.model.rfc.Structure.class) {
            if (from == byte[].class) {
                return this;
            }
            if (from == java.io.InputStream.class) {
                return this;
            }
            if (from == java.lang.String.class) {
                return this;
            }
        }
        return null;
    }

}
