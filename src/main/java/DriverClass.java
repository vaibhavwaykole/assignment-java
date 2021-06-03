import Utils.FileUtils;
import model.LogEvent;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DriverClass {


    public static void main(String[] args) throws IOException {
        String fileName = "batch.txt";
        List<LogEvent> logEventList = FileUtils.getListOfRecordsList(FileUtils.getFileStream(fileName));
        System.out.println(logEventList);
        logEventList.stream()
                .sorted(Comparator.comparing(LogEvent::getTimestamp))
                .collect(Collectors.groupingBy(LogEvent::getId))
                .forEach((key, value) -> {
                    boolean result = verifyIfDifferenceInTimeStampIsGreaterThanOrEqualTo4Secs(value);
                    if (result) {
                        System.out.println("data inconsistent -> "+value);
                        addToDatabase();
                    }

                });

    }

    private static void addToDatabase() {
    }

    private static boolean verifyIfDifferenceInTimeStampIsGreaterThanOrEqualTo4Secs(List<LogEvent> value) {

        if (value.size() == 2) {
            int result = Math.abs(Math.subtractExact(value.get(0).getTimestamp(), value.get(1).getTimestamp()));
            return result >= 4;

        }
        return false;

    }
}