package org.app;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TransactionCountJan {

 /*
 * counts no of transactions in January (solves the second query in requirements gathered)
 *
 * */
    private static final String RESOURCES = "src/main/resources/";
    public static void main(String[] args) throws IOException {

        Path path = Paths.get(RESOURCES + args[0]);
        List<String> transactions = Files.readAllLines(path);

        final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        int count = 0; double amount = 0d;

        for(String transaction : transactions){
            LocalDate date = LocalDate.parse(transaction.split(",")[0], DATE_PATTERN);
            if(date.getMonth().equals(Month.JANUARY)){
                count++;
                amount += Double.parseDouble(transaction.split(",")[1]);

            }
        }
        System.out.println("There were "+count+" transactions in "+Month.JANUARY + " with total amount of : "+amount);
    }
}
