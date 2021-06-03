package Utils;


import model.LogEvent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileUtils {

    private static final String resourcesPath = "/Users/vaibhavwaykole/IdeaProjects/assignment-swati/src/main/resources/";


    public static Stream<String> getFileStream(String fileName) throws IOException {

        String filePath = resourcesPath + fileName;
        return Files.lines(Paths.get(filePath));

    }

    public static List<LogEvent> getListOfRecordsList(Stream<String> fileStream) {

        List<LogEvent> logEventList = new ArrayList<>();
        fileStream.forEach(row -> {
                    logEventList.add(Mapper.deSerialize(row));
                }
        );
        return logEventList;

    }


    public static void main(String[] args) throws IOException {
        String fileName = "batch.txt";
        List<LogEvent> logEventList = FileUtils.getListOfRecordsList(FileUtils.getFileStream(fileName));
        System.out.println(logEventList);

    }

}



