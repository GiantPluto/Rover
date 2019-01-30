package xyz.apollotv.rover;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class RoverMain {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String index(){
        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("message", "OK");
        return node.toString();
    }

}
