package xyz.apollotv.rover.socketproto;

import com.fasterxml.jackson.annotation.JsonProperty;
import xyz.apollotv.rover.socketproto.OutgoingSocketMessage;

import java.util.HashMap;
import java.util.Map;

public class IncomingSocketMessage {

    private String command;
    private String payload;
    private Map<String, Object> data;

    public IncomingSocketMessage(String command){
        this(command, null);
    }

    public IncomingSocketMessage(String command, String payload){
        this(command, payload, new HashMap<>());
    }

    public IncomingSocketMessage(@JsonProperty("command") String command, @JsonProperty("payload") String payload, @JsonProperty("data") Map<String, Object> data){
        this.command = command;
        this.payload = payload;
        this.data = data;
    }

    public OutgoingSocketMessage buildResponse(String payload){
        return new OutgoingSocketMessage(this.command, payload);
    }

    public OutgoingSocketMessage buildResponse(String payload, Map<String, Object> data){
        return new OutgoingSocketMessage(this.command, payload, data);
    }

    public String getCommand(){
        return this.command;
    }

    public String getPayload(){
        return this.payload;
    }

    public Object getData(String key) {
        return data.get(key);
    }

}
