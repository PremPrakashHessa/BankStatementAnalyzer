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


    static double calculateTotalAmount(List<BankTransaction> transactions){
        double amount = 0d;
        for( BankTransaction tx : transactions) amount+= tx.getAmount();
        return amount ;
    }

    static List<BankTransaction> selectInMonth(List<BankTransaction> allTransactions , Month month){
        List<BankTransaction> transactions = new ArrayList<>();
        for(BankTransaction tx : allTransactions)
            if(tx.getDate().getMonth().equals(month)) transactions.add(tx);

        return transactions;
    }

    public static void main(String[] args) throws IOException {

        Path path = Path.of(RESOURCES + args[0]);
        List<String> lines = Files.readAllLines(path);

        BankTransactionCsvParser csvParser = new BankTransactionCsvParser();
        List<BankTransaction> transactions = csvParser.parseLinesFromCSV(lines);

        System.out.println("The total amount is : " + calculateTotalAmount(transactions));
        System.out.println("The transactions in month January are : \n" +
                selectInMonth(transactions,Month.JANUARY).toString() );



    }
}
