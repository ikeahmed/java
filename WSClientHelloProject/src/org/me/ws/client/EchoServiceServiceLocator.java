/**
 * EchoServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.me.ws.client;

public class EchoServiceServiceLocator extends org.apache.axis.client.Service implements org.me.ws.client.EchoServiceService {

    public EchoServiceServiceLocator() {
    }


    public EchoServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EchoServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EchoService
    private java.lang.String EchoService_address = "http://localhost:8080/WSHelloProject/services/EchoService";

    public java.lang.String getEchoServiceAddress() {
        return EchoService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EchoServiceWSDDServiceName = "EchoService";

    public java.lang.String getEchoServiceWSDDServiceName() {
        return EchoServiceWSDDServiceName;
    }

    public void setEchoServiceWSDDServiceName(java.lang.String name) {
        EchoServiceWSDDServiceName = name;
    }

    public org.me.ws.client.EchoService getEchoService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EchoService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEchoService(endpoint);
    }

    public org.me.ws.client.EchoService getEchoService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.me.ws.client.EchoServiceSoapBindingStub _stub = new org.me.ws.client.EchoServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getEchoServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEchoServiceEndpointAddress(java.lang.String address) {
        EchoService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.me.ws.client.EchoService.class.isAssignableFrom(serviceEndpointInterface)) {
                org.me.ws.client.EchoServiceSoapBindingStub _stub = new org.me.ws.client.EchoServiceSoapBindingStub(new java.net.URL(EchoService_address), this);
                _stub.setPortName(getEchoServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EchoService".equals(inputPortName)) {
            return getEchoService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "EchoServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "EchoService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EchoService".equals(portName)) {
            setEchoServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
