package xyz.apollotv.rover;

import com.fasterxml.jackson.databind.ObjectMapper;
import xyz.apollotv.rover.socketproto.IncomingSocketMessage;
import xyz.apollotv.rover.struct.ContentType;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;

@ServerEndpoint(value = "/rover/scrape")
public class RoverSocket {

    @OnOpen
    public void onOpen(Session session) throws IOException  {

    }

    @OnMessage
    public void onMessage(String msg, Session session) throws IOException {
        IncomingSocketMessage socketMessage = new ObjectMapper().readValue(msg, IncomingSocketMessage.class);

        if(socketMessage.getCommand().equals("ping")){
            session.getAsyncRemote().sendText(socketMessage.buildResponse("pong").serialize());
            return;
        }

        try {
        if(socketMessage.getCommand().equals("scrape")) {

                // Check the content type.
                String typeRaw = socketMessage.getPayload();
                ContentType type;
                try {
                    type = ContentType.valueOf(typeRaw);
                }catch(IllegalArgumentException ignored){
                    session.getAsyncRemote().sendText(
                            socketMessage.buildResponse("ERROR: Invalid content type specified.").serialize()
                    );
                    return;
                }

                // Fetch the metadata.
                String title = (String) socketMessage.getData("title");
                String year = (String) socketMessage.getData("year");
                String seasonNumber = (String) socketMessage.getData("seasonNumber");
                String episodeNumber = (String) socketMessage.getData("episodeNumber");

                // TODO: scrape for results

                // Send results to client
                session.getAsyncRemote().sendText(
                        socketMessage.buildResponse("OK", new HashMap<>()).serialize()
                );
        }

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session) throws IOException {

    }

    @OnError
    public void onError(Session session, Throwable throwable) {

    }

}

