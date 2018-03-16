package org.me.ws.client;

public class EchoServiceProxy implements org.me.ws.client.EchoService {
  private String _endpoint = null;
  private org.me.ws.client.EchoService echoService = null;
  
  public EchoServiceProxy() {
    _initEchoServiceProxy();
  }
  
  public EchoServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initEchoServiceProxy();
  }
  
  private void _initEchoServiceProxy() {
    try {
      echoService = (new org.me.ws.client.EchoServiceServiceLocator()).getEchoService();
      if (echoService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)echoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)echoService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (echoService != null)
      ((javax.xml.rpc.Stub)echoService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.me.ws.client.EchoService getEchoService() {
    if (echoService == null)
      _initEchoServiceProxy();
    return echoService;
  }
  
  public java.lang.String doHello(java.lang.String name) throws java.rmi.RemoteException{
    if (echoService == null)
      _initEchoServiceProxy();
    return echoService.doHello(name);
  }
  
  
}