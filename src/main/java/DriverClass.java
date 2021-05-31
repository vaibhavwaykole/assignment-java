import Utils.FileUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.LogEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DriverClass {
    public static void main(String[] argss) throws IOException {

        String fileName = "batch.txt";
        FileUtils util = new FileUtils();
        List<String> recordList = util.readFile(fileName);
        List<LogEvent> logEventList = new ArrayList<>();
        recordList.forEach(record -> {
            ObjectMapper mapper = new ObjectMapper();
            try {
                LogEvent logEvent = mapper.readValue(record, LogEvent.class);
                logEventList.add(logEvent);
                System.out.println("log event is --> " + logEvent);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });
        Comparator<LogEvent> compareByTimeStamp = Comparator.comparing(LogEvent::getTimestamp);
        Map<String, List<LogEvent>> map = logEventList.stream().sorted(compareByTimeStamp).collect(Collectors.groupingBy(LogEvent::getId));
        map.forEach((key, value) -> {
            System.out.print("Key is: " + key );
            System.out.println("Value is:"+value);
            boolean result = verifyIfDifferenceInTimeStampIsGreaterThanOrEqualTo4Secs(value);
            if (!result) {
                System.out.println("Add Logic to Add this object data in the Database for the Culprit record");




            }

        });
    }

    private static boolean verifyIfDifferenceInTimeStampIsGreaterThanOrEqualTo4Secs(List<LogEvent> value) {
        if (value.size() == 1)
            return true;
        else if (value.size() == 2) {
            int result = Math.subtractExact(value.get(0).getTimestamp(), value.get(1).getTimestamp());
            result = Math.abs(result);
            if (result >= 4) {
                return false;

            }
            System.out.println(" --> is not a culprit with difference as " + result);
        }
        return false;
    }
}
