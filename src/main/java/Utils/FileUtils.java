package Utils;


import java.io.*;
import java.util.*;

public class FileUtils {

    private static final String resourcesPath = "/Users/vaibhavwaykole/IdeaProjects/assignment-swati/src/main/resources/";



    public List<String> readFile(String fileName) throws IOException {
        List<String> recordsList = new ArrayList<>();
        try {


            File file = new File(resourcesPath + fileName);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                recordsList.add(line);
                sb.append("\n");
            }
            fr.close();
            System.out.println("Contents of File: ");
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return recordsList;
    }



}



