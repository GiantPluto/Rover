package xyz.apollotv.rover.socketproto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class OutgoingSocketMessage {

    private String command;
    private String payload;
    private Map<String, Object> data;

    public OutgoingSocketMessage(String command, String payload){
        this.command = command;
        this.payload = payload;
    }

    public OutgoingSocketMessage(String command, String payload, Map<String, Object> data){
        this.command = command;
        this.payload = payload;
        this.data = data;
    }

    public String serialize(){
        try {
            return new ObjectMapper().writer().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            System.err.println("Error encoding OutgoingSocketMessage as JSON.");
            e.printStackTrace();
            return null;
        }
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Object getData(String key) {
        return data.get(key);
    }

    public void setData(String key, Object data) {
        this.data.put(key, data);
    }

    public void removeData(String key){
        this.data.remove(key);
    }

    public void clearData(){
        this.data.clear();
    }
}
