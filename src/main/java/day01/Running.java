package day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Running {
    private List<RunLog> allRuns = new ArrayList<>();

    public void readFromFile(Path path) {
        try {
            allRuns.addAll(stringToRunLog(Files.readAllLines(path)));
        } catch (IOException ioe) {
            throw new IllegalStateException("File not found", ioe);
        }
    }

    protected List<RunLog> stringToRunLog(List<String> lines){
        List<RunLog> dataFromFile = new ArrayList<>();
            for (String s: lines) {
                String[] temp = s.split(" km;");
                try{
                    dataFromFile.add(new RunLog(Double.parseDouble(temp[0]), LocalDate.parse(temp[1])));
                }
                catch (NumberFormatException ignored) {
                }
            }
        return dataFromFile;
    }

    public double distanceCounter (int year, int month){
        double distancePerMonth = 0;
        try {
            for (RunLog run: allRuns){
                if (run.getDate().getYear() == year && run.getDate().getMonthValue() == month){
                    distancePerMonth += run.getDistance();
                }
            }
        }
        catch (NumberFormatException nfe){
            throw new IllegalArgumentException("Year and month must be digits");
        }
        return distancePerMonth;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = 0;
        int month = 0;


        try {
            System.out.println("Year?");
            year = Integer.parseInt(scanner.nextLine());
        }
        catch (NumberFormatException nfe){
            System.out.println("Year must be 4 digits");
        }

        try {
            System.out.println("Month?");
            month = scanner.nextInt();scanner.nextLine();
        }
        catch (InputMismatchException ime){
            System.out.println("Month must be 2 digits");
        }

        Running running = new Running();
        running.readFromFile(Paths.get("src/main/resources/running.csv"));
        System.out.println(running.distanceCounter(year, month));

    }
}
