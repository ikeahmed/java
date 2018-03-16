/**
 * EchoServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.me.ws.client;

public interface EchoServiceService extends javax.xml.rpc.Service {
    public java.lang.String getEchoServiceAddress();

    public org.me.ws.client.EchoService getEchoService() throws javax.xml.rpc.ServiceException;

    public org.me.ws.client.EchoService getEchoService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
