package com.me.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

//Service Endpoint Interface
@WebService
public interface HelloWorld{
	
	@WebMethod String getHelloWorldAsString(String name);
	
}
