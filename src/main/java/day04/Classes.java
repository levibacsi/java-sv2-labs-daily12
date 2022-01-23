package day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Classes {
    public int classesCounter (String name){
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("src/test/resources/beosztas.txt"))) {
            String line;
            int classCount = 0;
            while((line = reader.readLine()) != null) {
                if (line.equals(name)){
                    reader.readLine(); reader.readLine();
                    classCount += Integer.parseInt(reader.readLine());
                }
            }
            return classCount;
        }
        catch (IOException ioe) {
            throw new IllegalStateException("File not found", ioe);
        }
    }

    public static void main(String[] args) {
        Classes classes = new Classes();
        System.out.println(classes.classesCounter("Albatrosz Aladin"));
    }
}
