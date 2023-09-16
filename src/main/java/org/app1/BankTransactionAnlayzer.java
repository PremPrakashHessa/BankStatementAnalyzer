package org.app1;

import org.domain.BankTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnlayzer {

    static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {

        Path path = Path.of(RESOURCES + args[0]);
        List<String> lines = Files.readAllLines(path);

        BankTransactionCsvParser csvParser = new BankTransactionCsvParser();
        BankTransactionProcessor processor = new BankTransactionProcessor();
        List<BankTransaction> transactions = csvParser.parseLinesFromCSV(lines);

        System.out.println("The total amount is : " + processor.calculateTotalAmount(transactions));
        System.out.println("The transactions in month January are : \n" +
                processor.selectInMonth(transactions,Month.JANUARY).toString() );



    }
}
