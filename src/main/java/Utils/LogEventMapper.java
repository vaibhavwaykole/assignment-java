package Utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.LogEvent;

import java.io.IOException;
import java.io.StringWriter;

public class LogEventMapper {

    public static LogEvent deSerialize(String row) {
        ObjectMapper mapper = new ObjectMapper();
        LogEvent logEvent = null;
        try {
            logEvent = mapper.readValue(row, LogEvent.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return logEvent;
    }


    public String serialize(LogEvent logEvent) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        JsonGenerator jsonGenerator = null;
        mapper.writeValue(writer, logEvent);
        return "";


    }


}
