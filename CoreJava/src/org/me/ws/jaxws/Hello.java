package org.me.ws.jaxws;

import javax.jws.WebService;

@WebService
public class Hello
{
    public String getHello(String name)
    {
        return "Hello " + name + "!";
    }
}
