package Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.LogEvent;

public class Mapper {
    
    public static LogEvent deSerialize( String row) {
        ObjectMapper mapper = new ObjectMapper();
        LogEvent logEvent = null;
        try {
            logEvent = mapper.readValue(row, LogEvent.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return logEvent;
    }


    public String serialize(Object obj){
        return "";
    }


}
