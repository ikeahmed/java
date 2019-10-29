package com.me.jaxws;



//import org.me.ws.jaxws.HelloService;


public class Client
{
   // @WebServiceRef(wsdlLocation="http://localhost:8080/Hello/HelloService?WSDL")
   // static HelloService service;
    
    public static void main(String[] args)
    {
        Client client = new Client();
        client.doHello();
    }
    
    public void doHello()
    {
        try
        {

//			Hello port = service.getHelloPort();
//            String ret = port.getHello(System.getProperty("user.name"));
        	String ret = "John Doe";
            System.out.println("Hello result = " + ret);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}