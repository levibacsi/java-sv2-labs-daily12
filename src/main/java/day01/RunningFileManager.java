package day01;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RunningFileManager {
    private List<RunLog> running = new ArrayList<>();

    public void readAllLines(String fileName){
        try(BufferedReader br = Files.newBufferedReader(Path.of(fileName))){
            String line;
            br.readLine();
            while((line = br.readLine())!=null){
                RunLog run =  createRunObjectFromLine(line);
                running.add(run);
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot reach file",e);
        }
    }

    public double sumOfMonthAndYear(int year, Month month){
        double sum = 0;
        for(RunLog actual : running){
            if(actual.getDate().getYear()==year && actual.getDate().getMonth()==month){
                sum+=actual.getDistance();
            }
        }
        return sum;
    }

    private RunLog createRunObjectFromLine(String line) {
        String[] temp = line.split(";");
        return new RunLog(Double.parseDouble(temp[0].split(" ")[0]), LocalDate.parse(temp[1]));
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
            System.out.println("Year most be 4 digits");
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
