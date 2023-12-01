package org.app1;

import org.domain.BankTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class BankTransactionAnlayzer {

    static final String RESOURCES = "src/main/resources/";

    //Parsing delegated to BankTransactionCsvParser

    static void analyze(String fileName , IBankTransactionParser bankTransactionParser) throws IOException {
        final Path path = Path.of(RESOURCES + fileName);
        List<String> lines = Files.readAllLines(path);
        List<BankTransaction> transactions = bankTransactionParser.parseLinesFromCSV(lines);

        BankTransactionProcessor txProcessor = new BankTransactionProcessor(transactions);
        collectSummary(txProcessor);
    }


    private static void collectSummary(final BankTransactionProcessor bankTxProcessor) {
        System.out.println("The total for all transactions is "
                + bankTxProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is "
                        +
                        bankTxProcessor.calculateTotalForMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is "
                        +
                        bankTxProcessor.calculateTotalForMonth(Month.FEBRUARY));
        System.out.println("The total salary received is "
                +
                bankTxProcessor.calculateTotalForCategory("Salary"));

        System.out.println("The minimum amount for transactions between 30th January 2017 and 5th Feb 2017 is " +
                bankTxProcessor.minimumWithinDates(LocalDate.of(2017,1,30) ,
                        LocalDate.of(2017,2,5)));
        System.out.println("The maximum amount for transactions between 30th January 2017 and 5th Feb 2017 is " +
                bankTxProcessor.maximumWithinDates(LocalDate.of(2017,1,30) ,
                        LocalDate.of(2017,2,5)));

    }
}
